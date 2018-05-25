package com.axmor.repository;

import com.axmor.model.IssueResolver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IssueResolverRepository extends JpaRepository<IssueResolver, Long> {
    @Query("select i from IssueResolver i where i.issueId = :issueId")
    List<IssueResolver> issueResolverCustomSelect (@Param("issueId") long issueId);
}
