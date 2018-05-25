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
@Table(name = "IssueResolver")
public class IssueResolver extends BaseEntity {

    private static final long serialVersionUID = -7908494540095361292L;

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
