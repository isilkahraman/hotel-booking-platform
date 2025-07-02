package com.hotelbooking.hotelsearchservice.service;

import com.hotelbooking.hotelsearchservice.dto.*;
import com.hotelbooking.hotelsearchservice.model.*;
import com.hotelbooking.hotelsearchservice.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final HotelRepository hotelRepo;

    @Cacheable(value = "searchResults", key = "#request.location + #request.startDate + #request.endDate + #request.people")
    public List<HotelResponse> searchHotels(SearchRequest request) {
        List<Hotel> hotels = hotelRepo.findByLocationIgnoreCase(request.getLocation());
        List<HotelResponse> result = new ArrayList<>();

        for (Hotel hotel : hotels) {
            List<RoomDTO> availableRooms = new ArrayList<>();
            for (Room room : hotel.getRooms()) {
                boolean isAvailable = !room.getAvailableFrom().isAfter(request.getStartDate()) &&
                        !room.getAvailableTo().isBefore(request.getEndDate()) &&
                        room.getCapacity() >= request.getPeople();
                if (isAvailable) {
                    double price = room.getPrice();
                    if (request.isClient()) {
                        price *= 0.85; // 15% discount
                    }
                    availableRooms.add(new RoomDTO(price, room.getCapacity(), room.getAvailableFrom(), room.getAvailableTo()));
                }
            }

            if (!availableRooms.isEmpty()) {
                result.add(new HotelResponse(hotel.getName(), hotel.getLocation(), hotel.getStars(), availableRooms));
            }
        }
        return result;
    }
}
