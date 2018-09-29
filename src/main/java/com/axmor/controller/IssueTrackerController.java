package com.axmor.controller;

import com.axmor.model.Issue;
import com.axmor.model.IssueResolver;
import com.axmor.model.User;
import com.axmor.service.IssueResolverService;
import com.axmor.service.IssueService;
import com.axmor.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import spark.ModelAndView;
import spark.Request;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

@Slf4j
public class IssueTrackerController {
    private static final String USER_SESSION_ID = "user";

    private IssueService issueService;
    private IssueResolverService issueResolverService;
    private UserService userService;

    public IssueTrackerController(IssueService issueService, IssueResolverService issueResolverService, UserService userService) {
        this.issueService = issueService;
        this.issueResolverService = issueResolverService;
        this.userService = userService;
        setupRotes();
    }

    private void setupRotes() {
        /*
         * Index page
         */
        get("/", (req, res) -> {
            User user = getAuthenticatedUser(req);
            Map<String, Object> map = new HashMap<>();
            if (user == null) {
                map.put("info", "You must register, or sign in to view issue tracker");
                map.put("register", "REGISTER");
            } else {
                map.put("info", "You are registered and logg in as " + user.getUsername());
                map.put("user", user.getUsername());
            }
            return new ModelAndView(map, "index.ftl");
        }, new FreeMarkerEngine());

        /*
         * Page for registering a new user
         */
        get("/register", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            return new ModelAndView(map, "signup.ftl");
        }, new FreeMarkerEngine());

        before("/register", (req, res) -> {
            User authUser = getAuthenticatedUser(req);
            if (authUser != null) {
                res.redirect("/");
                halt();
            }
        });

        /*
         * Registration for new user
         */
        post("/register", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            User user = new User();
            user.setUsername(req.queryParams("username"));
            user.setPassword(req.queryParams("password"));
            user.setConfirmPassword(req.queryParams("confirm_password"));
            user.setRole("User");
            String error = user.validate();

            if (StringUtils.isEmpty(error)) {
                User existingUser = userService.getUserByName(user.getUsername());
                if (existingUser == null) {
                    userService.addUser(user);
                    res.redirect("/signin");
                    halt();
                } else {
                    error = "The username is already taken";
                }
            }
            map.put("error", error);
            map.put("username", user.getUsername());
            return new ModelAndView(map, "signup.ftl");
        }, new FreeMarkerEngine());

        /*
         * Sign in for user
         */
        get("/signin", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            return new ModelAndView(map, "signin.ftl");
        }, new FreeMarkerEngine());

        /*
         * Sign in for user and check user data
         */
        post("/signin", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            User user = new User();
            user.setUsername(req.queryParams("username"));
            user.setPassword(req.queryParams("password"));
            String error = "";
            User signUpUser = userService.getUserByName(user.getUsername());
            if (signUpUser == null) {
                error = "Invalid username/password";
            } else if (!userService.checkPasswords(user.getPassword(), signUpUser.getPassword())) {
                error = "Invalid username/password";
            } else {
                addAuthenticatedUser(req, signUpUser);
                res.redirect("/issues");
                halt();
            }
            map.put("error", error);
            map.put("username", user.getUsername());
            return new ModelAndView(map, "signin.ftl");
        }, new FreeMarkerEngine());

        before("/signin", (req, res) -> {
            User authUser = getAuthenticatedUser(req);
            if (authUser != null) {
                res.redirect("/");
                halt();
            }
        });

        /*
         * Displays all issues
         */
        get("/issues", (req, res) -> {
            List<Issue> issues = issueService.getAllIssues();
            User user = getAuthenticatedUser(req);
            Map<String, Object> input = new HashMap<>();
            input.put("user", user.getUsername());
            input.put("issues", issues);
            return new ModelAndView(input, "issues.ftl");
        }, new FreeMarkerEngine());

        checkUserAuthentication("/issues");

        /*
         * Detail information about issue
         */
        get("/issue/:id", (req, res) -> {
            String id = req.params(":id");
            User user = getAuthenticatedUser(req);
            Map<String, Object> input = new HashMap<>();
            List<IssueResolver> issueResolvers = issueResolverService.findAllById(Long.parseLong(id));
            Issue issue = issueService.getIssueById(Long.parseLong(id));
            if (issue == null) {
                res.redirect("/notfound");
                halt();
            }
            input.put("issues", issue);
            input.put("user", user.getUsername());
            input.put("issueResolvers", issueResolvers);
            return new ModelAndView(input, "issueDetails.ftl");
        }, new FreeMarkerEngine());

        checkUserAuthentication("/issue/:id");

        /*
         * Create comment for issue
         */
        post("/issue/:id", (req, res) -> {
            String issueId, comment, commentAuthor, status;
            User user = getAuthenticatedUser(req);
            issueId = req.params("id");
            status = req.queryParams("issue_status");
            commentAuthor = user.getUsername();
            comment = req.queryParams("issue_description");

            IssueResolver issueResolver = new IssueResolver();
            issueResolver.setIssueId(Long.parseLong(issueId));
            issueResolver.setUpdateStatus(status);
            issueResolver.setDescriptionAuthor(commentAuthor);
            issueResolver.setDescription(comment);
            issueResolver.setDescriptionDate(new Date());

            issueResolverService.addIssue(issueResolver);
            issueService.updateIssueStatus(Long.parseLong(issueId), status);
            res.redirect("/issue/" + issueId, 301);
            return "";
        });

        /*
         * Page with form for creating new issue
         */
        get("/createIssue", (req, res) -> {
            User user = getAuthenticatedUser(req);
            Map<String, Object> input = new HashMap<>();
            input.put("user", user.getUsername());
            return new ModelAndView(input, "createIssue.ftl");
        }, new FreeMarkerEngine());

        checkUserAuthentication("/createIssue");

        /*
         * Create new issue
         */
        post("/createIssue", (req, res) -> {
            User user = getAuthenticatedUser(req);
            String issueName, author, description;
            issueName = req.queryParams("issue_name");
            author = user.getUsername();
            description = req.queryParams("description");

            Issue issue = new Issue();
            issue.setIssueName(issueName);
            issue.setAuthor(author);
            issue.setIssueDescription(description);
            issue.setDateCreated(new Date());
            issue.setStatus("New");

            issueService.addIssue(issue);
            res.redirect("/issues", 301);
            return "";
        });

        /*
         * Logout for user
         */
        get("/logout", (req, res) -> {
            removeAuthenticatedUser(req);
            res.redirect("/");
            return null;
        });

        get("/notfound", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            return new ModelAndView(map, "notFound.ftl");
        }, new FreeMarkerEngine());
    }

    private void checkUserAuthentication(String path) {
        before(path, (req, res) -> {
            User user = getAuthenticatedUser(req);
            if (user == null) {
                res.redirect("/");
                halt();
            }
        });
    }

    private void addAuthenticatedUser(Request request, User user) {
        request.session().attribute(USER_SESSION_ID, user);
    }

    private void removeAuthenticatedUser(Request request) {
        request.session().removeAttribute(USER_SESSION_ID);
    }

    private User getAuthenticatedUser(Request request) {
        return request.session().attribute(USER_SESSION_ID);
    }
}

