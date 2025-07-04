package com.hotelbooking.hoteladminservice.repository;

import com.hotelbooking.hoteladminservice.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
}

