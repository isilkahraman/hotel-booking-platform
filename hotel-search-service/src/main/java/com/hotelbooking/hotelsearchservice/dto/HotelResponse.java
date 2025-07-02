package com.hotelbooking.hotelsearchservice.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
public class HotelResponse {
    private String name;
    private String location;
    private int stars;
    private List<RoomDTO> rooms;
}
