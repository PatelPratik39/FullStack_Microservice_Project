package com.blogsApp.springboot_rest_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Response body and Controller
@RestController
public class HelloWorld {

//    HTTP Get Request
//    http://localhost:8080/hello

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World, Lets Create BlogzApp using spring boot";
    }

}
