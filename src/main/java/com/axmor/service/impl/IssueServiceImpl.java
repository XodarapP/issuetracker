package com.axmor.service.impl;

import com.axmor.model.Issue;
import com.axmor.repository.IssueRepository;
import com.axmor.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("issueService")
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepository repository;

    @Override
    @Transactional
    public List<Issue> getAllIssues() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void addIssue(Issue issue) {
        repository.save(issue);
    }

    @Override
    @Transactional
    public void updateIssue(Issue issue) {
        repository.save(issue);
    }

    @Override
    @Transactional
    public void deleteIssue(long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Issue getIssueById(long id) {
        return repository.getOne(id);
    }
}
