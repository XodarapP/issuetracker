package com.axmor;

import com.axmor.controller.IssueTrackerController;
import com.axmor.service.IssueResolverService;
import com.axmor.service.IssueService;
import com.axmor.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import static spark.Spark.*;
/**
 * Application entry point
 */

@Configuration
@ComponentScan({"com.axmor"})
public class Main {
    public static void main (String[]args){
        staticFileLocation("/public");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        new IssueTrackerController(
                ctx.getBean(IssueService.class),
                ctx.getBean(IssueResolverService.class),
                ctx.getBean(UserService.class));
        ctx.registerShutdownHook();
    }
}

