package com.axmor.service.impl;

import com.axmor.model.User;
import com.axmor.repository.UserRepository;
import com.axmor.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.getUserByName(name);
    }

    @Override
    public boolean checkPasswords(String pass, String password) {
        return pass.equalsIgnoreCase(password);
    }
}
