package com.axmor.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
@ToString
class BaseEntity implements Serializable {
    private static final long serialVersionUID = 6401547610940322169L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
}
