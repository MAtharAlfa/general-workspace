package repository;

import entity.Reservation;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ReservationRepository {
    boolean existsConflict(
            String roomId,
            LocalDate date,
            LocalTime startTime,
            LocalTime endTime
    );

    Reservation save(Reservation reservation);
}
