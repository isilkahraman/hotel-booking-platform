package com.hotelbooking.bookhotelservice.controller;

import com.hotelbooking.bookhotelservice.dto.BookingRequest;
import com.hotelbooking.bookhotelservice.model.Booking;
import com.hotelbooking.bookhotelservice.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public Booking book(@RequestBody BookingRequest request) {
        return bookingService.bookRoom(request);
    }
}
