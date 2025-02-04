package com.sharad.app.controller;

import com.sharad.app.model.Student;
import com.sharad.app.repository.StudentRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class StudentController {

    private final StudentRepo studentRepo;

    public StudentController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @GetMapping("/read")
    public Iterable<Student> read() {
        return studentRepo.findAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody final Student student) {
        System.out.println("Saving student: " + student);
        studentRepo.save(student);
        return "save";
    }
}
