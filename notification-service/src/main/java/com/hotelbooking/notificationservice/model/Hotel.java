// model/Hotel.java
package com.hotelbooking.notificationservice.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private int stars;

    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;
}
