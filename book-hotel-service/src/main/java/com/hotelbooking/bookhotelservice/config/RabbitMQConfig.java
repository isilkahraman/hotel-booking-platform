package com.hotelbooking.bookhotelservice.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.name}")
    private String queue;

    @Bean
    public Queue bookingQueue() {
        return new Queue(queue, false);
    }
}
