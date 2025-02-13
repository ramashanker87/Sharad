package com.rabbit.app.consumer;
import com.rabbit.app.model.Student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
@Service
public class RabbitMqConsumer {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMqConsumer.class.getName());
    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @RabbitListener(queues= "name.out")
    public void receiveName(Student student) {
        logger.info("receive message: {}", student.toString());
    }
    @RabbitListener(queues= "student.out")
    public void receiveStudent(Student student) {
        logger.info("receive message: {}", student.toString());
    }


}