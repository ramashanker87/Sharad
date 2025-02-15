package com.sharad.app.repository;

import com.sharad.app.service.UserService;
import com.sharad.app.entity.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.Optional;

public class UserRepository {
    public Optional<User> findById(int id) {
        return null;
    }
}