package com.hotelbooking.notificationservice.scheduler;

import com.hotelbooking.notificationservice.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class RoomCapacityNotifier {

    private final RoomRepository roomRepo;

    // Run every day at 2am
    @Scheduled(cron = "0 0 2 * * ?")
    public void checkLowCapacityRooms() {
        LocalDate today = LocalDate.now();
        LocalDate nextMonth = today.plusMonths(1);

        var rooms = roomRepo.findByAvailableFromBeforeAndAvailableToAfterAndCapacityLessThan(
                nextMonth, today, 5);

        for (var room : rooms) {
            System.out.printf("Room %d in hotel '%s' has low capacity (%d)%n",
                    room.getId(), room.getHotel().getName(), room.getCapacity());
        }
    }
}
