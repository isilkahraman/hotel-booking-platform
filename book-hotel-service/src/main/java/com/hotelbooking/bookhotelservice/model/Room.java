// model/Room.java
package com.hotelbooking.bookhotelservice.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double price;
    private int capacity;
    private LocalDate availableFrom;
    private LocalDate availableTo;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
