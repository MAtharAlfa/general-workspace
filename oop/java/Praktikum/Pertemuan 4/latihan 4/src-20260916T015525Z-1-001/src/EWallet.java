// TODO 1:
//  1. Warisi (extends) abstract class MetodePembayaran
//  2. Implementasikan (implements) interface DapatDiRefund
public class EWallet extends MetodePembayaran implements DapatDiRefund{
    private String nomorHp;

    public EWallet(String namaMetode, double saldo, String nomorHp) {
        // TODO 2 : Panggil constructor superclass menggunakan super(...)
        super(namaMetode, saldo);
        this.nomorHp = nomorHp;
    }

    // TODO 3 : Override method prosesPembayaran(double jumlah) dari MetodePembayaran
    //  Aturan:
    //  - Memiliki biaya admin tetap sebesar Rp 1.000.
    //  - Total tagihan yang harus dibayar = jumlah + 1000.
    //  - Jika saldo >= total: kurangi saldo dengan total dan cetak:
    //    "[E-Wallet] Pembayaran Rp<jumlah> (+ admin 1000) sukses via <nomorHp>."
    //  - Jika saldo < total: cetak:
    //    "[E-Wallet] Saldo tidak cukup untuk pembayaran + admin."
    @Override
    public void prosesPembayaran(double jumlah) {
        final double biayaAdmin = 1000;
        double totalTagihan = jumlah + biayaAdmin;

        if (saldo >= totalTagihan) {
            saldo -= totalTagihan;
            System.out.println("Pembayaran Rp" + totalTagihan + " sukses via " + nomorHp);
        }
    }

    // TODO 4 : Override method refund(double jumlah) dari interface DapatDiRefund
    //  Aturan:
    //  - Tambahkan saldo dengan jumlah (tanpa potongan admin)
    //  - Cetak: "[E-Wallet] Refund Rp<jumlah> masuk ke akun <nomorHp>."
    @Override
    public void refund(double jumlah) {
        saldo += jumlah;
        System.out.println("Refund Rp" + jumlah + " masuk ke akun " + nomorHp);
    }

    // TODO 5 : Buat method topUp(double nominal)
    //  - Tambahkan saldo dengan nominal
    //  - Cetak: "[E-Wallet] Top up Rp<nominal> berhasil. Saldo baru: Rp<saldo>"
    public void topUp(double nominal) {
        saldo += nominal;
        System.out.println("Top up Rp" + nominal + "berhasil. Saldo baru: Rp" + saldo);
    }

    // TODO 6 : Buat method overloading topUp(double nominal, String kodePromo)
    //  - Jika kodePromo sama dengan "HEMAT" (gunakan .equalsIgnoreCase):
    //    tambahkan saldo dengan nominal + bonus Rp 5.000
    //    Cetak: "[E-Wallet] Promo HEMAT berhasil! Top up Rp<nominal> + bonus Rp 5000. Saldo baru: Rp<saldo>"
    //  - Jika bukan "HEMAT": lakukan top up nominal biasa dan cetak bahwa promo tidak valid.
    public void topUp(double nominal, String kodePromo) {
        if (kodePromo.contentEquals("HEMAT")) {
            final double bonus = 5000;
            saldo += nominal + bonus;
            System.out.print("Promo HEMAT berhasil! Top up Rp" + nominal + " bonus Rp5000. Saldo baru: Rp" + saldo);
        } else {
            saldo += nominal;
            System.out.println("Maaf kode promo tidak berhasil.\nTop up Rp" + nominal + "berhasil. Saldo baru: Rp" + saldo);
        }   
    }

    // ! DON'T MODIFY
    public String getNomorHp() {
        return nomorHp;
    }
    // ! DON'T MODIFY
}
