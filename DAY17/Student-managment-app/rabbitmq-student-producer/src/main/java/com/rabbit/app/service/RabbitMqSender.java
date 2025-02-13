package com.rabbit.app.service;

import com.rabbit.app.module.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSender {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMqSender.class.getName());
    private final AmqpTemplate amqpTemplate;
    @Value("student.exchange")
    String exchangeName;
    @Value("name.routingkey")
    String routingKeyName;
    @Value("student.routingkey")
    String studentRoutingKeyName;

    public RabbitMqSender(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }
    public void send(String student) {
        logger.info("sending message: {}", student);
        amqpTemplate.convertAndSend(exchangeName, routingKeyName, student);
    }
    public void sendStudent(Student student) {
        logger.info("Sending student to RabbitMQ: {} ", student.toString() );
        amqpTemplate.convertAndSend(exchangeName, studentRoutingKeyName, student);

    }
    public void deleteStudent(String student) {
        logger.info("Deleting student from RabbitMQ: {} ", student.toString() );
        amqpTemplate.convertAndSend(exchangeName, studentRoutingKeyName, student);
    }
}