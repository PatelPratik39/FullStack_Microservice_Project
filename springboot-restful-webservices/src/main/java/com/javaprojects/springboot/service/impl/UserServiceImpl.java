package com.javaprojects.springboot.service.impl;

import com.javaprojects.springboot.dto.UserDTO;
import com.javaprojects.springboot.entity.User;
import com.javaprojects.springboot.mapper.UserMapper;
import com.javaprojects.springboot.repository.UserRepository;
import com.javaprojects.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

//    I need to use AllArgsConstructor annotation for userRepository to get constructors
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
//        Convert UserDTO into User JPA Entity
        User user = UserMapper.mapToUser(userDTO);
       User savedUser =  userRepository.save(user);

//       convert JPA entity to UserDTO
        UserDTO savedUserDTO = UserMapper.mapToUserDTO(savedUser);
        return savedUserDTO;
    }

    @Override
    public UserDTO getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
          User user = optionalUser.get();
          return UserMapper.mapToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users =  userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);

        return UserMapper.mapToUserDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
