package com.hotelbooking.bookhotelservice.service;

import com.hotelbooking.bookhotelservice.dto.BookingRequest;
import com.hotelbooking.bookhotelservice.model.*;
import com.hotelbooking.bookhotelservice.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final RoomRepository roomRepo;
    private final BookingRepository bookingRepo;
    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.queue.name}")
    private String queueName;

    public Booking bookRoom(BookingRequest req) {
        Room room = roomRepo.findById(req.getRoomId()).orElseThrow();

        // Check availability and capacity
        boolean isAvailable = !room.getAvailableFrom().isAfter(req.getStartDate()) &&
                !room.getAvailableTo().isBefore(req.getEndDate()) &&
                room.getCapacity() >= req.getPeople();

        if (!isAvailable) throw new RuntimeException("Room not available");

        // Book room
        Booking booking = new Booking(null, req.getCustomerName(), req.getEmail(),
                req.getStartDate(), req.getEndDate(), req.getPeople(), room);
        bookingRepo.save(booking);

        // Optional: Reduce room capacity (business logic assumption)
        room.setCapacity(room.getCapacity() - req.getPeople());
        roomRepo.save(room);

        // Send message to queue
        rabbitTemplate.convertAndSend(queueName, "New booking for: " + req.getCustomerName() +
                ", Hotel: " + room.getHotel().getName() +
                ", Dates: " + req.getStartDate() + " to " + req.getEndDate());

        return booking;
    }
}
