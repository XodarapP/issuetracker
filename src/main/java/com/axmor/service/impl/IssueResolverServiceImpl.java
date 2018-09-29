package com.axmor.service.impl;

import com.axmor.model.IssueResolver;
import com.axmor.repository.IssueResolverRepository;
import com.axmor.service.IssueResolverService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("issueResolverService")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class IssueResolverServiceImpl implements IssueResolverService {

    IssueResolverRepository issueResolverRepository;

    @Override
    public void addIssue(IssueResolver issueResolver) {
        issueResolverRepository.save(issueResolver);
    }

    @Override
    public List<IssueResolver> findAllById(long id) {
        return issueResolverRepository.issueResolverCustomSelect(id);
    }
}
