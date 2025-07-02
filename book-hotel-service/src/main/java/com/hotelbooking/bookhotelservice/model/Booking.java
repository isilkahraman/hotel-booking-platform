// model/Booking.java
package com.hotelbooking.bookhotelservice.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String email;
    private LocalDate startDate;
    private LocalDate endDate;
    private int people;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
