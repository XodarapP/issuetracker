package com.axmor.service;

import com.axmor.model.IssueResolver;

import java.util.List;

public interface IssueResolverService {
    List<IssueResolver> getAllIssues();

    void addIssue(IssueResolver issueResolver);

    void updateIssue(IssueResolver issueResolver);

    void deleteIssue(long id);

    IssueResolver getIssueResolverById(long id);
}
