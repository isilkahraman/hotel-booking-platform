package com.hotelbooking.bookhotelservice.dto;

import lombok.*;
import java.time.LocalDate;

@Data
public class BookingRequest {
    private String customerName;
    private String email;
    private Long roomId;
    private LocalDate startDate;
    private LocalDate endDate;
    private int people;
}
