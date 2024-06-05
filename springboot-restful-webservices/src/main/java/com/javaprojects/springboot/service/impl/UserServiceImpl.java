package com.javaprojects.springboot.service.impl;

import com.javaprojects.springboot.entity.User;
import com.javaprojects.springboot.repository.UserRepository;
import com.javaprojects.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

//    I need to use AllArgsConstructor annotation for userRepository to get constructors
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {

        return userRepository.save(user);
    }
}
