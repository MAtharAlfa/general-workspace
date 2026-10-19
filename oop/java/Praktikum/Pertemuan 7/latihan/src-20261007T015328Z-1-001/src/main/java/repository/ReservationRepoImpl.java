package repository;

import entity.Reservation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReservationRepoImpl implements ReservationRepository {
    private final List<Reservation> reservations;

    public ReservationRepoImpl() {
        this.reservations = new ArrayList<>();
    }

    public ReservationRepoImpl(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public boolean existsConflict(String roomId, LocalDate date, LocalTime startTime, LocalTime endTime) {
        return reservations.stream()
                .anyMatch(reservation -> {
                    if (!reservation.getRoom().getId().equals(roomId)) {
                        return false;
                    }

                    if (!reservation.getDate().equals(date)) {
                        return false;
                    }

                    return startTime.isBefore(reservation.getEndTime())
                            && endTime.isAfter(reservation.getStartTime());
                });
    }

    @Override
    public Reservation save(Reservation reservation) {
        reservations.add(reservation);
        return reservation;
    }

    public List<Reservation> getReservations() {
        return Collections.unmodifiableList(reservations);
    }
}
