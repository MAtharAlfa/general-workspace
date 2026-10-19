import entity.Reservation;
import entity.Room;
import entity.User;
import repository.*;
import service.ReservationService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("U001", "Budi"),
                new User("U002", "Siti")
        );

        List<Room> rooms = List.of(
                new Room("R001", "Lab Komputer 1", 30),
                new Room("R002", "Ruang Seminar", 100)
        );

        List<Reservation> reservations = new ArrayList<>();

        UserRepoImpl userRepository = new UserRepoImpl(users);
        RoomRepoImpl roomRepository = new RoomRepoImpl(rooms);
        ReservationRepoImpl reservationRepository = new ReservationRepoImpl(reservations);

        ReservationService reservationService = new ReservationService(userRepository, roomRepository, reservationRepository);

        // TODO: Panggil mekanisme untuk membuat reservasi, buat penanganan khusus untuk exception yang terjadi
        //  Hint: "Coba dulu, jika gagal lemparkan sesuatu, buat mekanisme untuk menangkap objek yang dilempar"
        //
        //  Demonstrasikan dua kasus (logika service diverifikasi oleh unit test, bukan di sini):
        //  1) Kasus sukses     : U001 memesan R001 pada 2026-10-08, 10:00 - 12:00
        //     Harapan output   : cetak ringkasan reservasi yang berhasil dibuat
        //  2) Kasus gagal      : U999 (tidak terdaftar) memesan R001 pada waktu yang sama
        //     Harapan output   : cetak nama class exception dan pesannya, program tidak berhenti
        //  Tangkap exception spesifik terlebih dahulu, lalu base class ReservationException.
    }
}
