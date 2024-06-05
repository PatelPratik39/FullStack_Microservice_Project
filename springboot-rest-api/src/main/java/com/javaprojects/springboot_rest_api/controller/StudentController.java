package com.javaprojects.springboot_rest_api.controller;

import com.javaprojects.springboot_rest_api.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

//    http://localhost:8080/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){

        Student student = new Student(
                1,
                "Mangoo",
                "Mochi"
        );
//        return new ResponseEntity<>(student,HttpStatus.OK);
//        return ResponseEntity.ok(student);
        return  ResponseEntity.ok().header("custome-header", "Magan").body(student);

    }

    //    http://localhost:8080/students
    @GetMapping
    public ResponseEntity <List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Mangoo", "Mochi"));
        students.add(new Student(2, "Chucha", "Singh") );
        students.add(new Student(3, "Chandu", "Lal") );
        students.add(new Student(4, "Lallu", "Ram") );
        return ResponseEntity.ok(students);
    }

//    SPRING boot REST API with path variables
//    @GetMapping("students/{id}")
//    public Student studentPathVariable(@PathVariable("id") int studentId){
//        return new Student(studentId, "Manju", "Gondi");
//    }

    //    SPRING boot REST API with path variables
    //    http://localhost:8080/students/1/admin/adminoal
//    {id} - URI template variable
    @GetMapping("/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable( @PathVariable("id") int studentId,
                                                       @PathVariable("first-name") String firstname,
                                                       @PathVariable("last-name") String lastName){
        Student student = new Student(studentId, firstname,lastName);
        return ResponseEntity.ok(student);
//        return new Student(studentId, firstname, lastName);
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
    @RequestMapping("/query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName){
//        return new Student (id, firstName, lastName);
        Student student = new Student(id, firstName,lastName);
        return ResponseEntity.ok(student);
    }

    //    http://localhost:8080/students/create
//    SPRING Bott REST API that handles HTTP Post requests - create new User - 201 code
//    @PostMapping and @RequestBody
    @PostMapping("/create")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

//    http://localhost:8080/students/1/update
    //    SPRING Bott REST API that handles HTTP PUT requests - update existing user

    @PutMapping("/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
//        return student;
        return  ResponseEntity.ok(student);
    }

//    http://localhost:8080/students/1/delete
//    SPRING Bott REST API that handles HTTP DELETE requests - DELETE existing user
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Student DELETED Successfully!!!!!!");

    }
}
