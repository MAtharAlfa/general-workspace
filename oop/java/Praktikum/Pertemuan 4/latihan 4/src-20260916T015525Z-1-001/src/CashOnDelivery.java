// TODO 1:
//  1. Warisi (extends) abstract class MetodePembayaran
//  PERHATIAN: CashOnDelivery TIDAK mengimplementasikan interface DapatDiRefund!
public class CashOnDelivery extends MetodePembayaran {
    private String alamatPengiriman;

    public CashOnDelivery(String namaMetode, double saldo, String alamatPengiriman) {
        // TODO 2 : Panggil constructor superclass menggunakan super(...)
        super(namaMetode, saldo);
        this.alamatPengiriman = alamatPengiriman;
    }

    // TODO 3 : Override method prosesPembayaran(double jumlah) dari MetodePembayaran
    //  Aturan:
    //  - Biaya penanganan COD adalah Rp 2.000.
    //  - Cetak: "[COD] Pesanan dikirim ke <alamatPengiriman>. Siapkan tunai sebesar Rp<jumlah + 2000>."
    @Override
    public void prosesPembayaran(double jumlah) {
        final double penangananCod = 2000;
        System.out.println("Pesanan dikirim ke " + alamatPengiriman + ". Siapkan tunai sebesar Rp" + (jumlah+penangananCod));
    }

    // ! DON'T MODIFY
    public String getAlamatPengiriman() {
        return alamatPengiriman;
    }
    // ! DON'T MODIFY
}
