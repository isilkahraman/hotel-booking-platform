package com.hotelbooking.hoteladminservice.repository;

import com.hotelbooking.hoteladminservice.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
