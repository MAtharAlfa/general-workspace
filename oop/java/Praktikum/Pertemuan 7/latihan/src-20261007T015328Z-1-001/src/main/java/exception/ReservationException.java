package exception;

/**
 * Base class untuk seluruh kesalahan logika bisnis pada proses reservasi.
 * Semua exception reservasi lain harus menjadi turunan class ini.
 */
// TODO: Tentukan superclass yang tepat (tambahkan 'extends ...').
//  Pertimbangkan: checked (Exception) atau unchecked (RuntimeException)? Apa konsekuensinya
//  bagi signature method dan blok try-catch di pemanggil?
// TODO: Buat konstruktor yang menerima pesan (String message) dan meneruskannya ke superclass.
public class ReservationException extends RuntimeException {
    public ReservationException(String message) {
        super(message);
    }
}
