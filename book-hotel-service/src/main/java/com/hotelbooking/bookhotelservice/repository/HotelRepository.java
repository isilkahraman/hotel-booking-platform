package com.hotelbooking.bookhotelservice.repository;

import com.hotelbooking.bookhotelservice.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {}

