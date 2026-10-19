package service;

import exception.InvalidTimeRangeException;
import exception.RoomNotFoundException;
import exception.UserNotFoundException;

import entity.User;
import entity.Room;
import entity.Reservation;
import repository.ReservationRepository;
import repository.RoomRepository;
import repository.UserRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationService {
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;

    public ReservationService(UserRepository userRepository, RoomRepository roomRepository, ReservationRepository reservationRepository) {
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
    }

    public Reservation createReservation(
            String userId, String roomId,
            LocalDate date, LocalTime startTime, LocalTime endTime
    ) {
        // TODO: Implementasikan prosedur berikut, setiap kesalahan logika bisnis yang terjadi lempar exception yang tepat
        //  Kode exception belum tersedia, lakukan analisis exception apa saja yg diperlukan


        //  1) Cari user
        //  Hint: panggil findById() pada repository yang tepat
            User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("Error"));

        //  2) Cari ruangan
        //  Hint: panggil findById() pada repository yang tepat
            Room room = roomRepository.findById(roomId).orElseThrow(() -> new RoomNotFoundException("Error"));

        //  3) Validasi waktu
        //  Hint: Kapan waktu `start` dan `end` dikatakan valid?
            if (startTime.isAfter(endTime) || startTime.equals(endTime)) {
                throw new InvalidTimeRangeException("Error");
            }

        //  4) Periksa jika ada reservasi pada ruangan yang diminta sudah ada
        //  Hint: gunakan repository yg tepat di mana fungsi untuk memeriksa konflik dibuat
            if (ReservationRepository.existsConflict(roomId, date, startTime, endTime)) {
                throw new InvalidTimeRangeException("Error");
            }

        //  5) Buat reservasi
        //  Hint: reservasi adalah class, apa yang dibuat dari sebuah class?

        //  6) Simpan reservasi
        //  Hint: gunakan repository yg tepat di mana fungsi untuk menyimpan reservasi dibuat

        //  7) Kembalikan reservasi yang berhasil dibuat (tidak boleh null)
        //  Hint: ID reservasi boleh dibuat bebas asalkan unik, mis. UUID.randomUUID().toString()

        return null; // TODO: ganti dengan reservasi yang dibuat
    }
}
