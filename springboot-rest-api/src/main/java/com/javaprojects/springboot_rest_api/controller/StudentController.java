package com.javaprojects.springboot_rest_api.controller;

import com.javaprojects.springboot_rest_api.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

//    http://localhost:8080/student
    @GetMapping("student")
    public Student getStudent(){

        Student student = new Student(
                1,
                "Mangoo",
                "Mochi"
        );
        return student;
    }

    //    http://localhost:8080/students
    @GetMapping("students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Mangoo", "Mochi"));
        students.add(new Student(2, "Chucha", "Singh") );
        students.add(new Student(3, "Chandu", "Lal") );
        students.add(new Student(4, "Lallu", "Ram") );
        return students;
    }

//    SPRING boot REST API with path variables
//    @GetMapping("students/{id}")
//    public Student studentPathVariable(@PathVariable("id") int studentId){
//        return  new Student(studentId, "Manju", "Gondi");
//    }

    //    SPRING boot REST API with path variables
    //    http://localhost:8080/students/1/admin/adminoal
//    {id} - URI template variable
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId, @PathVariable("first-name") String firstname, @PathVariable("last-name") String lastName){
        return  new Student(studentId, firstname, lastName);
    }

    /*
        In Request param or query parameter url
        i need to annotate id to @RequestParams
     */

//    Spring boot REST API with REQUEST Params (query?id=1)
    //    http://localhost:8080/students/query?id=1
//    @RequestMapping("students/query")
//    public Student studentRequestVariable(@RequestParam int id){
//        return new Student(id, "Madan","Mansukh");
//    }
//    Spring boot REST API with REQUEST Params (query?id=1)
//    http://localhost:8080/students/query?id=1&firstName=Madan&lastName=Mansukh
    @RequestMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName){
        return new Student(id, firstName,lastName);
    }

    //    http://localhost:8080/students/create
//    SPRING Bott REST API that handles HTTP Post requests - create new User - 201 code
//    @PostMapping and @RequestBody
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

//    http://localhost:8080/students/1/update
    //    SPRING Bott REST API that handles HTTP PUT requests - update existing user

    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

//    http://localhost:8080/students/1/delete
//    SPRING Bott REST API that handles HTTP DELETE requests - DELETE existing user
    @DeleteMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return "Student DELETED Successfully!!!!!!";

    }
}
