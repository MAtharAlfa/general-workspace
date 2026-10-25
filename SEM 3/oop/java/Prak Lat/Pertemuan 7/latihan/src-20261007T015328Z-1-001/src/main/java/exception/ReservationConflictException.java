package exception;

import javax.management.RuntimeErrorException;

/**
 * Dilempar ketika ruangan sudah dipesan pada tanggal dan rentang waktu yang bertabrakan.
 * TODO: jadikan turunan ReservationException.
 */
// TODO: Tentukan superclass yang tepat (tambahkan 'extends ...').
//  Pertimbangkan: checked (Exception) atau unchecked (RuntimeException)? Apa konsekuensinya
//  bagi signature method dan blok try-catch di pemanggil?
// TODO: Buat konstruktor yang menerima pesan (String message) dan meneruskannya ke superclass.
public class ReservationConflictException extends ReservationException {
    public ReservationConflictException(String message) {
        super(message);
    }
}
