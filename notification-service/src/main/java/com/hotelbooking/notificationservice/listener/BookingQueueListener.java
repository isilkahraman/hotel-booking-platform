package com.hotelbooking.notificationservice.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BookingQueueListener {

    @Value("${rabbitmq.queue.name}")
    private String queueName;

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void receiveBookingMessage(String message) {
        System.out.println("📨 New Booking Notification: " + message);
    }
}
