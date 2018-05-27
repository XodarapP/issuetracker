package com.axmor.service;

import com.axmor.model.Issue;

import java.util.List;

public interface IssueService {
    List<Issue> getAllIssues();

    void addIssue(Issue issue);

    void updateIssue(Issue issue);

    void deleteIssue(long id);

    Issue getIssueById(long id);

    int updateIssueStatus(long issueId, String status);

}
