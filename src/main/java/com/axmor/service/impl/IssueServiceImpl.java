package com.axmor.service.impl;

import com.axmor.model.Issue;
import com.axmor.repository.IssueRepository;
import com.axmor.service.IssueService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("issueService")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class IssueServiceImpl implements IssueService {
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
    public Issue getIssueById(long id) {
        return repository.findOne(id);
    }

    @Override
    @Transactional
    public void updateIssueStatus(long issueId, String status) {
        repository.updateIssueStatus(issueId, status);
    }
}
