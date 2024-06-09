package com.blogsApp.Blogs_springboot_rest_api.controller;

import com.blogsApp.Blogs_springboot_rest_api.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

//    http:localhost:8080/student
    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(
               1,
               "Mangal",
                "Murthi"
        );
        return student;
    }
//  HTTP request using GET method
//    http:localhost/students
    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Mangal", "Murthi"));
        students.add(new Student(2,"Sankat", "Mochan"));
        students.add(new Student(3,"Ram", "Bhakat"));
        students.add(new Student(4,"Bajrang", "Bali"));
        students.add(new Student(5,"Pawan", "Putra"));
        students.add(new Student(5,"Kesari", "Nandan"));
        return students;
    }

//     Spring Boot REST API with Path Variable
    @GetMapping("students/{id}")
    public Student studentPathVariable(@PathVariable("id") int id){
        return new Student(id, "KastBhanjan", "Dev");
    }

}
