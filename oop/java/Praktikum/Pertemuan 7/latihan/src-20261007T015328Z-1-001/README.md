# Latihan 7 - Exception Handling pada Sistem Reservasi Ruangan

## Tujuan
Berlatih membuat **custom exception**, melempar (`throw`/`throws`) dan menangkapnya (`try-catch`)
pada logika bisnis reservasi ruangan.

## Yang harus dikerjakan (urutan disarankan)
1. **Paket `exception`**: tentukan `extends` dan buat konstruktor `(String message)` pada tiap class.
   `ReservationException` adalah base class, empat lainnya harus menjadi turunannya.
   Pilih checked (`Exception`) atau unchecked (`RuntimeException`), lalu pikirkan konsekuensinya.
2. **`ReservationService.createReservation()`**: ikuti langkah 1-7 pada TODO.
3. **`Main`**: tangani exception dengan `try-catch` (kasus sukses dan kasus gagal).

## Aturan bisnis
| Langkah | Kondisi gagal | Exception |
|---|---|---|
| 1 | User tidak ditemukan | `UserNotFoundException` |
| 2 | Ruangan tidak ditemukan | `RoomNotFoundException` |
| 3 | Waktu mulai tidak sebelum waktu selesai | `InvalidTimeRangeException` |
| 4 | Jadwal bertabrakan (ruangan dan tanggal sama) | `ReservationConflictException` |

Reservasi bersebelahan (selesai 12:00, mulai 12:00) **bukan** konflik.
Jika terjadi kegagalan, tidak boleh ada reservasi yang tersimpan.

## Cara menguji
```
mvn test
```
Test belum bisa dikompilasi sebelum class exception memiliki `extends` yang valid.
Itu bagian dari latihan. Selesai jika semua test hijau dan `Main` berjalan sesuai harapan.

## Pertanyaan refleksi
- Apa perbedaan checked dan unchecked exception, dan apa pilihanmu?
- Apa yang terjadi jika `catch (ReservationException)` ditulis sebelum catch yang spesifik?
