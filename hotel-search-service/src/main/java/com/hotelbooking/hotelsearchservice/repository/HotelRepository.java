package com.hotelbooking.hotelsearchservice.repository;

import com.hotelbooking.hotelsearchservice.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByLocationIgnoreCase(String location);
}
