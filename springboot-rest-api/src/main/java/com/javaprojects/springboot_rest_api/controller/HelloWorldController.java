package com.javaprojects.springboot_rest_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

//    creste rest API
//    http://localhost:8080/hello_world

    @GetMapping("/hello_world")
    public String helloWorld(){
        return "Hello Word";
    }


}
