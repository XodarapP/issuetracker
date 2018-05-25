package com.axmor.service.impl;

import com.axmor.model.Issue;
import com.axmor.repository.IssueRepository;
import com.axmor.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("issueService")
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepository repository;

    @Override
    public List<Issue> getAllIssues() {
        return repository.findAll();
    }

    @Override
    public void addIssue(Issue issue) {
        repository.save(issue);
    }

    @Override
    public void updateIssue(Issue issue) {
        repository.save(issue);
    }

    @Override
    public void deleteIssue(long id) {
        repository.delete(id);
    }

    @Override
    public Issue getIssueById(long id) {
        return repository.findOne(id);
    }

}
