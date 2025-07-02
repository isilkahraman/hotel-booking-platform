package com.hotelbooking.notificationservice.controller;

import com.hotelbooking.notificationservice.scheduler.RoomCapacityNotifier;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schedule")
@RequiredArgsConstructor
public class SchedulerController {

    private final RoomCapacityNotifier notifier;

    @GetMapping("/low-capacity-check")
    public String runLowCapacityCheck() {
        notifier.checkLowCapacityRooms();
        return "Low capacity check triggered.";
    }
}

