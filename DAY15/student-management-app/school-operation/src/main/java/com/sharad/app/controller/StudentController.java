package com.sharad.app.controller;

import com.sharad.app.model.Student;
import com.sharad.app.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/school")
public class StudentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
    private final StudentRepository studentRepository;
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @PostMapping("/save")
    public Student save(@RequestBody Student student) throws Exception {
        LOGGER.info("save student {}", student);
        return studentRepository.save(student);
    }
    @GetMapping("/read")
    public Iterable<Student> readAll() throws InterruptedException {
        LOGGER.info("Reading all students");
        return studentRepository.findAll();
    }

}