import java.time.LocalDateTime;

// TODO: Buat agar KartuKreditPayment mewarisi dari Payment
//  Tambahkan empat properti baru, dengan tipe data yang sesuai
//  Properti tambahan: nomorKartu, cvv, limitKredit, persentaseBiayaLayanan
public class KartuKreditPayment extends Payment {
    private String nomorKartu;
    private String cvv;
    double limitKredit;
    double persentaseBiayaLayanan;
    // TODO: Buat dua constructor, default constructor dan parameterized
    //  constructor yang menerima tiga parameter. Properti persentaseBiayaLayanan
    //  di-set di dalam constructor langsung.
    KartuKreditPayment(String nomorKartu, String cvv, double limitKredit) {
        this.nomorKartu = nomorKartu;
        this.cvv = cvv;
        this.limitKredit= limitKredit;
        persentaseBiayaLayanan = 0.11;
    }

    // TODO: Override method prosesPembayaran
    //  1. Jika nilai amount lebih dari limit kredit, tidak bisa melakukan pembayaran
    //  2. Set properti jumlahDibayar dengan penambahan PPN 11% dan persentaseBiayaLayanan
    //  3. Panggil method informasiPembayaran
    @Override
    public void prosesPembayaran(double input) {
        if (input > limitKredit) {
            System.out.println("tidak bisa melakukan pembayaran: jumlah melebihi limit kredit");
            return;
        } else {
            setJumlahDibayar(super.getJumlahDibayar() + (super.getJumlahDibayar()*persentaseBiayaLayanan));
            setWaktuPembayaran(LocalDateTime.now());
            informasiPembayaran();
        }
    }


    // TODO: Implementasi getter dan setter
    public void setNomorKartu(String nomorKartu) {
        this.nomorKartu = nomorKartu;
    }
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
    public void setLimitKredit(double limitKredit) {
        this.limitKredit = limitKredit;
    }
    public void setPersentaseBiayaLayanan(double persentaseBiayaLayanan) {
        this.persentaseBiayaLayanan = persentaseBiayaLayanan;
    }
    public String getNomorKartu() {
        return nomorKartu;
    }
    public String getCvv() {
        return cvv;
    }
    public double getLimitKredit() {
        return limitKredit;
    }
    public double getPersentaseBiayaLayanan() {
        return persentaseBiayaLayanan;
    }
}
