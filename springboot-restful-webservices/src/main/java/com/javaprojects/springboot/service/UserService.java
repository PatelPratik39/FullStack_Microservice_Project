package com.javaprojects.springboot.service;

import com.javaprojects.springboot.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserById(Long userId);

    List<User> getAllUsers();
}
