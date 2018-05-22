package com.axmor.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Issue")
@Proxy(lazy = false)
public class Issue implements Serializable {

    private static final long serialVersionUID = 4841459368286842781L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "IssueName", nullable = false, length = 256)
    private String issueName;

    @Column(name = "Author", nullable = false, length = 256)
    private String author;

    @Column(name = "IssueDescription", nullable = false, length = 256)
    private String issueDescription;

    @Column(name = "DateCreated", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "Status", nullable = false)
    private String status;
}
