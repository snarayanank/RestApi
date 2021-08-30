package com.school.restApi.controller;

import com.school.restApi.dao.Student;
import com.school.restApi.service.StudentDaoService;
import com.school.restApi.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class StudentResource {

    @Autowired
    private StudentDaoService service;

    //Retrieve all Students
    @GetMapping("/fetchStudents")
    public List<Student> retrieveAllStudents(){
        return service.findAll();
    }

    //Retrieve Student by id
    @GetMapping("/fetchStudents/{id}")
    public Student retrieveStudent(@PathVariable int id) throws StudentNotFoundException {
        Student student = service.findStudent(id);
        if(student==null)
            throw new StudentNotFoundException("id-"+ id);
        return student;
    }

    //Add Student
    @PostMapping("/fetchStudents")
    public ResponseEntity<Object> saveStudent(@RequestBody Student student){
        Student savedStud = service.saveStudent(student);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedStud.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    //Delete Student
    @DeleteMapping("/fetchStudents/{id}")
    public void deleteStudent(@PathVariable int id){
        Student student = service.deleteById(id);

        if(student==null)
            throw new StudentNotFoundException("id-"+ id);

    }

    //Update Student
    @PutMapping(value ="/fetchStudents/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") int studentId,
                                                   @Valid @RequestBody Student stud) throws StudentNotFoundException {
        return new ResponseEntity<>(service.updateStudent(studentId,stud),HttpStatus.OK);
    }

}
