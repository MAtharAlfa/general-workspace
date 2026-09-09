import java.time.LocalDateTime;

// TODONE: Buat agar EWalletPayment mewarisi dari Payment
//  Tambahkan dua properti baru, dengan tipe data yang sesuai
//  Properti tambahan: nomorTelepon, saldo
public class EWalletPayment extends Payment {

    private String nomorTelepon;
    private double saldo;

    // TODO: Buat dua constructor, default constructor dan parameterized
    //  constructor yang menerima dua parameter. Setiap properti dapat nilai dari
    //  constructornya langsung
    EWalletPayment(String nomorTelepon, double saldo) {
        this.nomorTelepon = nomorTelepon;
        this.saldo = saldo;
    }

    // TODO: Override method prosesPembayaran
    //  1. Jika nilai amount lebih dari saldo, tidak bisa melakukan pembayaran
    //  2. Set properti jumlahDibayar dengan penambahan PPN 11% dan tambahan biaya, besaran dibebaskan
    //  3. Panggil method informasiPembayaran 
    @Override
    public void prosesPembayaran(double tagihan) {
        if (saldo < tagihan) {
            System.out.println("tidak bisa melakukan pembayaran: jumlah melebihi saldo");
            return;
        } else {
            setJumlahDibayar(tagihan * 1.11 + 4000);
            setWaktuPembayaran(LocalDateTime.now());
            informasiPembayaran();
        }
    }

    // TODO: Implementasi getter dan setter
    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public String getNomorTelepon() {
        return nomorTelepon;
    }
    public double getSaldo() {
        return saldo;
    }
}
