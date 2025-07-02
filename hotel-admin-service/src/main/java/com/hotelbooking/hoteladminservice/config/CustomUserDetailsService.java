package com.hotelbooking.hoteladminservice.config;

import com.hotelbooking.hoteladminservice.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AdminRepository adminRepo;

    @Override
    public UserDetails loadUserByUsername(String username) {
        var admin = adminRepo.findByUsername(username);
        if (admin == null) throw new UsernameNotFoundException("Admin not found");

        return User.builder()
                .username(admin.getUsername())
                .password(admin.getPassword())
                .roles("ADMIN")
                .build();
    }
}
