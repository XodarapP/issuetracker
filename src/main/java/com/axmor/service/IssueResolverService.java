package com.axmor.service;

import com.axmor.model.IssueResolver;

import java.util.List;

public interface IssueResolverService {
    void addIssue(IssueResolver issueResolver);

    List<IssueResolver> findAllById(long id);
}
