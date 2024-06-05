package com.javaprojects.springboot.controller;

import com.javaprojects.springboot.entity.User;
import com.javaprojects.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
//    http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        User singleUser = userService.getUserById(userId);
        return new ResponseEntity<>(singleUser, HttpStatus.OK);
    }

//    Build GET All User REST API
//    http://localhost:8080/api/users
    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users =  userService.getAllUsers();
        return  new ResponseEntity<>(users, HttpStatus.OK);
    }

//        Build UPDATE User REST API
//    http://localhost:8080/api/users/1

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser( @PathVariable("id") Long userId,
                                            @RequestBody User user) {
        user.setId(userId);  // I have to provide setId(userId) to prevent nullpoint exception because i have passes getId() in service class
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }


    //    Build DELETE User REST API
//    http://localhost:8080/api/users/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
       return new ResponseEntity<>("User successfully DELETED, Man !!!!", HttpStatus.OK);
    }

}
