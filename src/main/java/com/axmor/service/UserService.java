package com.axmor.service;

import com.axmor.model.User;

public interface UserService {
    void addUser(User user);

    User getUserByName(String name);

    boolean checkPasswords(String pass, String password);
}