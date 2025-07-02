package com.hotelbooking.hotelsearchservice.controller;

import com.hotelbooking.hotelsearchservice.dto.*;
import com.hotelbooking.hotelsearchservice.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @PostMapping
    public List<HotelResponse> search(@RequestBody SearchRequest request) {
        return searchService.searchHotels(request);
    }
}
