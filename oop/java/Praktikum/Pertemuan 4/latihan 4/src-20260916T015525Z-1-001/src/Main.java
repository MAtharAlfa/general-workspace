public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("             SIMULASI PAYMENT GATEWAY            ");
        System.out.println("=================================================");

        // TODO 1 (Polimorfisme - Upcasting):
        // Buat array polimorfik bertipe MetodePembayaran dengan kapasitas 3 elemen:
        // - Indeks 0: Objek TransferBank("BCA", 150000, "1234567890")
        // - Indeks 1: Objek EWallet("GoPay", 70000, "08123456789")
        // - Indeks 2: Objek CashOnDelivery("COD", 0, "Jl. Dipati Ukur No. 35")
        MetodePembayaran[] daftarBayar = new MetodePembayaran[3];
        // Inisialisasi ketiga elemen array di bawah sini...
        MetodePembayaran TFBank = new TransferBank("BCA", 150000, "123467890");
        daftarBayar[0] = TFBank;
        MetodePembayaran EWallet = new EWallet("GoPay", 70000, "08123456789");
        daftarBayar[1] = EWallet;
        MetodePembayaran CashOnDelivery = new CashOnDelivery("COD", 0, "Jl. Dipati Ukur No. 35");
        daftarBayar[2] = CashOnDelivery;

        double tagihanBelanja = 50000;
        double nominalRefund = 20000;

        // TODO 2 (Dynamic Method Dispatch):
        // Lakukan perulangan (for atau for-each) pada daftarBayar:
        // Di dalam perulangan:
        //  a. Cetak info awal saldo/metode menggunakan bayar.cetakInformasi()
        //  b. Panggil bayar.prosesPembayaran(tagihanBelanja) secara polimorfik
        System.out.println("INFORMATION:");
        for (MetodePembayaran metodePembayaran : daftarBayar) {
            metodePembayaran.cetakInformasi();
            System.out.println("    Proses Pembayaran:");
            metodePembayaran.prosesPembayaran(tagihanBelanja);
        }
        //
        // TODO 3 (Keyword instanceof & Downcasting ke Interface):
        //  c. Periksa apakah objek saat ini mengimplementasikan interface DapatDiRefund:
        //     - Jika true: lakukan downcasting ke DapatDiRefund, lalu panggil refund(nominalRefund)
        //     - Jika false: cetak pesan bahwa metode tersebut tidak mendukung refund
        System.out.println("\nREFUND:");
        for (MetodePembayaran metodePembayaran : daftarBayar) {
            if (metodePembayaran instanceof DapatDiRefund) {
                DapatDiRefund objekRefund = (DapatDiRefund)metodePembayaran;
                objekRefund.refund(nominalRefund);
                System.out.println("");
            } else {
                System.out.println("Metode ini tidak mendukung sistem refund.");
                System.out.println("");
            }
        }
        //
        // TODO 4 (Subclass-specific Downcasting):
        //  d. Periksa apakah objek saat ini merupakan instance dari EWallet:
        //     - Jika true: lakukan downcasting ke EWallet dan panggil topUp(20000, "HEMAT")
        //     - Jika false: cetak pesan bahwa metode tersebut tidak mendukung top-up
            System.out.println("TOP UP:");
        for (MetodePembayaran metodePembayaran : daftarBayar) {
            if (metodePembayaran instanceof EWallet) {
                EWallet objekEWallet = (EWallet)metodePembayaran;
                objekEWallet.topUp(20000, "HEMAT");
                System.out.println("");
                System.out.println("");
            } else {
                System.out.println("Metode ini tidak mendukung top-up.");
                System.out.println("");
            }
        }
        //
        //  e. Cetak informasi saldo akhir menggunakan bayar.cetakInformasi()
        System.out.println("INFORMATION:");
        for (MetodePembayaran metodePembayaran : daftarBayar) {
            metodePembayaran.cetakInformasi();
        }
        //  f. Cetak garis pemisah: System.out.println("-------------------------------------------------");
        
    }
}
