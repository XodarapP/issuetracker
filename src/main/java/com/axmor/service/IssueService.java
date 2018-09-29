package com.axmor.service;

import com.axmor.model.Issue;

import java.util.List;

public interface IssueService {
    List<Issue> getAllIssues();

    void addIssue(Issue issue);

    Issue getIssueById(long id);

    void updateIssueStatus(long issueId, String status);
}
