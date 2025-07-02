package com.hotelbooking.hotelsearchservice.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SearchRequest {
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    private int people;
    private boolean isClient; // for 15% discount
}
