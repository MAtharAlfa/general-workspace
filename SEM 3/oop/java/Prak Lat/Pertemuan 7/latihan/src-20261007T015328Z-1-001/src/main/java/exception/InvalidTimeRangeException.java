package exception;

/**
 * Dilempar ketika rentang waktu tidak valid (waktu mulai tidak sebelum waktu selesai).
 * TODO: jadikan turunan ReservationException.
 */
// TODO: Tentukan superclass yang tepat (tambahkan 'extends ...').
//  Pertimbangkan: checked (Exception) atau unchecked (RuntimeException)? Apa konsekuensinya
//  bagi signature method dan blok try-catch di pemanggil?
// TODO: Buat konstruktor yang menerima pesan (String message) dan meneruskannya ke superclass.
public class InvalidTimeRangeException extends ReservationException {
    public InvalidTimeRangeException(String message) {
        super(message);
    }
}
