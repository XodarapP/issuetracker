package com.axmor.repository;

import com.axmor.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IssueRepository extends JpaRepository<Issue, Long> {
    @Modifying
    @Query("UPDATE Issue i set i.status = :status WHERE i.id = :issueId")
    void updateIssueStatus (@Param("issueId") long issueId, @Param("status") String status);
}
