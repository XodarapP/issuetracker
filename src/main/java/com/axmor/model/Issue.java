package com.axmor.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Issues")
public class Issue extends BaseEntity {
    private static final long serialVersionUID = 4577013807050898316L;

    @Column(name = "IssueName", nullable = false, length = 256)
    private String issueName;

    @Column(name = "Author", nullable = false, length = 256)
    private String author;

    @Column(name = "IssueDescription", nullable = false, length = 1000)
    private String issueDescription;

    @Column(name = "DateCreated", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "Status", nullable = false)
    private String status;
}
