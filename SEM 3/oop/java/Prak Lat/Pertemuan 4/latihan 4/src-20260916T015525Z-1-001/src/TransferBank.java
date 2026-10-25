// TODO 1 :
//  1. Warisi (extends) abstract class MetodePembayaran
//  2. Implementasikan (implements) interface DapatDiRefund
public class TransferBank extends MetodePembayaran implements DapatDiRefund {
    private String nomorRekening;

    public TransferBank(String namaMetode, double saldo, String nomorRekening) {
        // TODO: Panggil constructor superclass menggunakan super(...)
        super(namaMetode, saldo);
        this.nomorRekening = nomorRekening;
    }

    // TODO 2 : Override method prosesPembayaran(double jumlah) dari MetodePembayaran
    //  Aturan:
    //  - Jika saldo >= jumlah: kurangi saldo dengan jumlah dan cetak:
    //    "[Bank] > sukses via No Rek <nomorRekening>."
    //  - Jika saldo < jumlah: cetak:
    //    "[Bank] Saldo rekening tidak mencukupi."
    @Override
    public void  prosesPembayaran(double jumlah) {
        if (saldo >= jumlah) {
            saldo -= jumlah;
            System.out.println("Sukses via No Rek: " + nomorRekening);
        } else {
            System.out.println("Saldo rekening tidak mencukupi!");
        }
    }

    // TODO 3 : Override method refund(double jumlah) dari interface DapatDiRefund
    //  Aturan:
    //  - Tambahkan saldo dengan jumlah
    //  - Cetak: "[Bank] Refund Rp<jumlah> berhasil dikembalikan ke Rek <nomorRekening>."
    @Override 
    public void refund(double jumlah) {
        saldo += jumlah;
        System.out.println("Refund Rp" + jumlah + " berhasil dikembalikan ke Rek " + nomorRekening);
    }

    // ! DON'T MODIFY
    public String getNomorRekening() {
        return nomorRekening;
    }
    // ! DON'T MODIFY
}
