package com.sharad.app.service;

import com.sharad.app.entity.User;
import com.sharad.app.repository.UserRepository;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

public class UserService {
    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserDetails(int userid) {
        return userRepository.findById(userid)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
    }
}
