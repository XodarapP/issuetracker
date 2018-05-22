package com.axmor.controller;

import com.axmor.model.Issue;
import com.axmor.service.IssueResolverService;
import com.axmor.service.IssueService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class IssueTrackerController {
    private final Configuration configuration = new Configuration(Configuration.VERSION_2_3_19);
    private IssueService issueService;
    private IssueResolverService issueResolverService;

    public IssueTrackerController(IssueService issueService, IssueResolverService issueResolverService) {
        this.issueService = issueService;
        this.issueResolverService = issueResolverService;
        configuration.setClassForTemplateLoading(IssueTrackerController.class,"/templates");
        setupRotes();
    }

    private void setupRotes(){

        get("/issues", (req, res) -> {
            List<Issue> issues = issueService.getAllIssues();
            StringWriter writer = new StringWriter();
            try {
                Map<String, List<Issue>> input = new HashMap<>();
                input.put("issues", issues);
                Template template = configuration.getTemplate("issues.ftl");
                template.process(input,writer);
            } catch (IOException | TemplateException e) {
                e.printStackTrace();
            }
            return writer;
        });
    }
}
