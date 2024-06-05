package com.javaprojects.springboot.controller;

import com.javaprojects.springboot.entity.User;
import com.javaprojects.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

//    Built create User REST API
    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

//    Build GET User By ID REST API
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        User singleUser = userService.getUserById(userId);
        return new ResponseEntity<>(singleUser, HttpStatus.OK);
    }
}
