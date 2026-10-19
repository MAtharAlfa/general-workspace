package service;

import entity.Reservation;
import entity.Room;
import entity.User;
import exception.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import repository.ReservationRepoImpl;
import repository.RoomRepoImpl;
import repository.UserRepoImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Spesifikasi perilaku ReservationService.
 * Jika file ini gagal dikompilasi, pastikan class di paket `exception` sudah memiliki `extends` yang tepat.
 * Test netral terhadap checked/unchecked: pemanggilan memakai assertThrows (tanpa try-catch).
 */
class ReservationServiceTest {
    private static final LocalDate DATE = LocalDate.of(2026, 10, 8);

    private ReservationRepoImpl reservationRepository;
    private ReservationService service;

    private static LocalTime t(int hour) {
        return LocalTime.of(hour, 0);
    }

    @BeforeEach
    void setUp() {
        reservationRepository = new ReservationRepoImpl();
        service = new ReservationService(
                new UserRepoImpl(List.of(new User("U001", "Budi"), new User("U002", "Siti"))),
                new RoomRepoImpl(List.of(new Room("R001", "Lab Komputer 1", 30), new Room("R002", "Ruang Seminar", 100))),
                reservationRepository
        );
    }

    private int total() {
        return reservationRepository.getReservations().size();
    }

    @Nested
    @DisplayName("Reservasi berhasil")
    class HappyPath {
        @Test
        @DisplayName("mengembalikan reservasi dengan data sesuai dan menyimpannya")
        void success() throws Exception {
            Reservation r = service.createReservation("U001", "R001", DATE, t(10), t(12));

            assertNotNull(r, "Reservasi yang dibuat tidak boleh null");
            assertEquals("U001", r.getUser().getId());
            assertEquals("R001", r.getRoom().getId());
            assertEquals(DATE, r.getDate());
            assertEquals(t(10), r.getStartTime());
            assertEquals(t(12), r.getEndTime());
            assertEquals(1, total());
        }

        @Test
        @DisplayName("reservasi bersebelahan (selesai = mulai berikutnya) bukan konflik")
        void adjacent() throws Exception {
            service.createReservation("U001", "R001", DATE, t(10), t(12));
            service.createReservation("U002", "R001", DATE, t(12), t(14));
            assertEquals(2, total());
        }

        @Test
        @DisplayName("ruangan berbeda pada waktu yang sama diperbolehkan")
        void differentRoom() throws Exception {
            service.createReservation("U001", "R001", DATE, t(10), t(12));
            service.createReservation("U002", "R002", DATE, t(10), t(12));
            assertEquals(2, total());
        }

        @Test
        @DisplayName("tanggal berbeda pada ruangan dan waktu yang sama diperbolehkan")
        void differentDate() throws Exception {
            service.createReservation("U001", "R001", DATE, t(10), t(12));
            service.createReservation("U002", "R001", DATE.plusDays(1), t(10), t(12));
            assertEquals(2, total());
        }
    }

    @Nested
    @DisplayName("Data tidak ditemukan")
    class NotFound {
        @Test
        @DisplayName("user tidak ada -> UserNotFoundException")
        void userNotFound() {
            assertThrows(UserNotFoundException.class,
                    () -> service.createReservation("U999", "R001", DATE, t(10), t(12)));
            assertEquals(0, total());
        }

        @Test
        @DisplayName("ruangan tidak ada -> RoomNotFoundException")
        void roomNotFound() {
            assertThrows(RoomNotFoundException.class,
                    () -> service.createReservation("U001", "R999", DATE, t(10), t(12)));
            assertEquals(0, total());
        }
    }

    @Nested
    @DisplayName("Validasi waktu")
    class TimeValidation {
        @Test
        @DisplayName("waktu mulai setelah waktu selesai -> InvalidTimeRangeException")
        void startAfterEnd() {
            assertThrows(InvalidTimeRangeException.class,
                    () -> service.createReservation("U001", "R001", DATE, t(12), t(10)));
            assertEquals(0, total());
        }

        @Test
        @DisplayName("waktu mulai sama dengan waktu selesai -> InvalidTimeRangeException")
        void startEqualsEnd() {
            assertThrows(InvalidTimeRangeException.class,
                    () -> service.createReservation("U001", "R001", DATE, t(10), t(10)));
            assertEquals(0, total());
        }
    }

    @Nested
    @DisplayName("Konflik jadwal")
    class Conflict {
        @Test
        @DisplayName("tumpang tindih sebagian -> ReservationConflictException")
        void partialOverlap() throws Exception {
            service.createReservation("U001", "R001", DATE, t(10), t(12));
            assertThrows(ReservationConflictException.class,
                    () -> service.createReservation("U002", "R001", DATE, t(11), t(13)));
            assertEquals(1, total());
        }

        @Test
        @DisplayName("berada sepenuhnya di dalam reservasi lain -> ReservationConflictException")
        void fullyInside() throws Exception {
            service.createReservation("U001", "R001", DATE, t(10), t(14));
            assertThrows(ReservationConflictException.class,
                    () -> service.createReservation("U002", "R001", DATE, t(11), t(12)));
            assertEquals(1, total());
        }
    }

    @Nested
    @DisplayName("Hierarki exception")
    class Hierarchy {
        @Test
        @DisplayName("semua exception turunan ReservationException")
        void allExtendBase() {
            assertTrue(ReservationException.class.isAssignableFrom(UserNotFoundException.class));
            assertTrue(ReservationException.class.isAssignableFrom(RoomNotFoundException.class));
            assertTrue(ReservationException.class.isAssignableFrom(InvalidTimeRangeException.class));
            assertTrue(ReservationException.class.isAssignableFrom(ReservationConflictException.class));
        }
    }
}
