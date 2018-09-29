package com.axmor;

import com.axmor.controller.IssueTrackerController;
import com.axmor.service.IssueResolverService;
import com.axmor.service.IssueService;
import com.axmor.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

/**
 * Application entry point
 */
@Slf4j
@Configuration
@ComponentScan({"com.axmor"})
public class Main {
    public static void main(String[] args) {
        staticFileLocation("/public");
        port(8080);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        new IssueTrackerController(
                ctx.getBean(IssueService.class),
                ctx.getBean(IssueResolverService.class),
                ctx.getBean(UserService.class));
        ctx.registerShutdownHook();
        LOGGER.info("Service started");
    }
}

