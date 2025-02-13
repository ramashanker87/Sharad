package com.rabbit.app.configuration;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class RabbitMqConfig {
    @Value("student.exchange")
    String exchangeName;
    @Value("student.out")
    String studentqueuename;
    @Value("name.out")
    String namequeuename;
    @Value("student.routingkey")
    String studentRoutingKeyName;
    @Value("name.routingkey")
    String nameRoutingKeyName;
    @Bean
    public Queue studentQueue() {
        return new Queue(studentqueuename, true);
    }
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Binding studentBinding(Queue studentQueue, DirectExchange exchange) {
        return BindingBuilder.bind(studentQueue).to(exchange).with(studentRoutingKeyName);
    }
    @Bean
    public Queue nameQueue() {
        return new Queue(namequeuename, true);
    }
    @Bean
    public Binding nameBinding(Queue nameQueue, DirectExchange exchange) {
        return BindingBuilder.bind(nameQueue).to(exchange).with(nameRoutingKeyName);
    }
    @Bean
    public MessageConverter JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setMessageConverter(JsonMessageConverter());
        return rabbitTemplate;
    }


}