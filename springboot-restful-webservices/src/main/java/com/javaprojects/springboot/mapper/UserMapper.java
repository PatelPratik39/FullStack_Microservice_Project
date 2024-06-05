package com.javaprojects.springboot.mapper;

import com.javaprojects.springboot.dto.UserDTO;
import com.javaprojects.springboot.entity.User;

public class UserMapper {

//    Convert User JPA Entity into UserDTO
    public static UserDTO mapToUserDTO(User user){
        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDTO;
    }

//    Convert UserDTO into User JPA Entity

    public static User mapToUser(UserDTO userDTO){
        User user = new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail()
        );
        return user;
    }
}
