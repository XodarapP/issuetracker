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
@Table(name = "IssueResolver")
@Proxy(lazy = false)
public class IssueResolver implements Serializable {

    private static final long serialVersionUID = 3332305606506460573L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "IssueId", nullable = false)
    private long issueId;

    @Column(name = "Comment", length = 1000)
    private String comment;

    @Column(name = "CommentAuthor", length = 256, nullable = false)
    private String commentAuthor;

    @Column(name = "CommentDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentDate;

    @Column(name = "UpdateStatus", length = 55, nullable = false)
    private String updateStatus;
}
