package com.hotelbooking.notificationservice.repository;

import com.hotelbooking.notificationservice.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByAvailableFromBeforeAndAvailableToAfterAndCapacityLessThan(
            LocalDate start, LocalDate end, int capacity);
}
