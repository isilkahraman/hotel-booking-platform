package com.hotelbooking.hoteladminservice.controller;

import com.hotelbooking.hoteladminservice.dto.*;
import com.hotelbooking.hoteladminservice.model.*;
import com.hotelbooking.hoteladminservice.repository.*;
import com.hotelbooking.hoteladminservice.config.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminRepository adminRepo;
    private final HotelRepository hotelRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest req) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword())
            );
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(req.getUsername());
        return new AuthResponse(token);
    }

    @PostMapping("/hotels")
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelRepo.save(hotel);
    }

    @PutMapping("/hotels/{id}")
    public Hotel updateHotel(@PathVariable Long id, @RequestBody Hotel updated) {
        Hotel existing = hotelRepo.findById(id).orElseThrow();
        existing.setName(updated.getName());
        existing.setLocation(updated.getLocation());
        existing.setStars(updated.getStars());
        return hotelRepo.save(existing);
    }

    @GetMapping("/hotels")
    public List<Hotel> getAll() {
        return hotelRepo.findAll();
    }

}
