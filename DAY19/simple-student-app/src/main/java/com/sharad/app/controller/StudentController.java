package com.sharad.app.controller;

import com.sharad.app.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
    private Map<String, Student> students = new HashMap<>();

    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student student) {
        String name = student.getName();
        students.put(name, student);
        return student;
    }

    @GetMapping("/get")
    public Student getStudent(@RequestParam String name) {
        return students.get(name);
    }

    @GetMapping("/get/all")
    public Map<String, Student> getAllStudent() {
        return students;
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestParam String name,@RequestParam int id) {
        Student student = students.get(name);
        student.setId(id);
        students.put(name, student);
        return student;
    }

    @DeleteMapping("/delete")
    public void deleteStudent(@RequestParam String name) {
        students.remove(name);
    }

}