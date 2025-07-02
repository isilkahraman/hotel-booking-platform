package com.hotelbooking.hotelsearchservice.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class RoomDTO {
    private double price;
    private int capacity;
    private LocalDate from;
    private LocalDate to;
}
