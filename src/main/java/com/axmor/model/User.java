package com.axmor.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Users")

public class User extends BaseEntity {

    private static final long serialVersionUID = 6352503253954445201L;

    @Column(name = "Username", length = 50, nullable = false)
    private String username;
    @Column(name = "Password", length = 50, nullable = false)
    private String password;

    private String confirmPassword;
    @Column(name = "Role", length = 50, nullable = false)
    private String role;

    public String validate() {
        String error = null;
        if(StringUtils.isEmpty(username)) {
            error = "You have to enter a username";
        } else if(StringUtils.isEmpty(password)) {
            error = "You have to enter a password";
        } else if(!password.equals(confirmPassword)) {
            error = "The two passwords do not match";
        }
        return error;
    }
}
