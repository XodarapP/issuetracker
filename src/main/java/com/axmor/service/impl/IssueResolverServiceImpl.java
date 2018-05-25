package com.axmor.service.impl;

import com.axmor.model.IssueResolver;
import com.axmor.repository.IssueResolverRepository;
import com.axmor.service.IssueResolverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("issueResolverService")
public class IssueResolverServiceImpl implements IssueResolverService {

    @Autowired
    IssueResolverRepository issueResolverRepository;

    @Override
    public List<IssueResolver> getAllIssues() {
        return issueResolverRepository.findAll();
    }

    @Override
    public void addIssue(IssueResolver issueResolver) {
        issueResolverRepository.save(issueResolver);
    }

    @Override
    public void updateIssue(IssueResolver issueResolver) {
        issueResolverRepository.save(issueResolver);
    }

    @Override
    public void deleteIssue(long id) {
        issueResolverRepository.delete(id);
    }

    @Override
    public IssueResolver getIssueResolverById(long id) {
        return issueResolverRepository.findOne(id);
    }

    @Override
    public List<IssueResolver> findAllById(long id) {
        return issueResolverRepository.issueResolverCustomSelect(id);
    }
}
