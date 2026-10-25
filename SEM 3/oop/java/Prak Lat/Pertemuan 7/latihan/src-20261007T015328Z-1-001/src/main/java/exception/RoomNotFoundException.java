package exception;

/**
 * Dilempar ketika ruangan dengan ID yang diminta tidak ditemukan.
 * TODO: jadikan turunan ReservationException.
 */
// TODO: Tentukan superclass yang tepat (tambahkan 'extends ...').
//  Pertimbangkan: checked (Exception) atau unchecked (RuntimeException)? Apa konsekuensinya
//  bagi signature method dan blok try-catch di pemanggil?
// TODO: Buat konstruktor yang menerima pesan (String message) dan meneruskannya ke superclass.
public class RoomNotFoundException extends ReservationException {
    public RoomNotFoundException(String message) {
        super(message);
    }
}
