package com.javaprojects.springboot.service;

import com.javaprojects.springboot.dto.UserDTO;
import com.javaprojects.springboot.entity.User;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO user);

    UserDTO getUserById(Long userId);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(UserDTO user);

    void deleteUser(Long userId);
}
