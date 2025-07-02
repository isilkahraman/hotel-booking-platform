package com.hotelbooking.hoteladminservice.repository;

import com.hotelbooking.hoteladminservice.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
