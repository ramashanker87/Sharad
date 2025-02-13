package com.rabbit.app.controller;

import com.rabbit.app.module.Student;
import com.rabbit.app.service.RabbitMqSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class.getName());
    private final RabbitMqSender rabbitMqSender;

    public StudentController(RabbitMqSender rabbitMqSender) {
        this.rabbitMqSender = rabbitMqSender;
    }
    @PostMapping("/save")
    public Student student(@RequestBody Student student) {
        rabbitMqSender.sendStudent(student);
        return student;
    }
    @DeleteMapping("/delete")
    public void deleteStudent(@RequestParam String name) {
        rabbitMqSender.deleteStudent(name);

    }
}