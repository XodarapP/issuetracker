package com.axmor.service;

import com.axmor.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(long id);

    User getUserById(long id);

    User getUserByName(String name);

    boolean checkPasswords(String pass, String password);
}