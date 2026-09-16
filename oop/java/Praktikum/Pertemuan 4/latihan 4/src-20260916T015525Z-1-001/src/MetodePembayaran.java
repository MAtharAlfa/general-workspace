// TODO 1 : Ubah class ini menjadi Abstract Class
public abstract class MetodePembayaran {
    // ! DON'T MODIFY
    protected String namaMetode;
    protected double saldo;

    public MetodePembayaran(String namaMetode, double saldo) {
        this.namaMetode = namaMetode;
        this.saldo = saldo;
    }
    // ! DON'T MODIFY

    // TODO 2 : Deklarasikan abstract method prosesPembayaran yang menerima parameter jumlah (double) tanpa body / implementasi
    public abstract void prosesPembayaran(double jumlah);

    // ! DON'T MODIFY
    public void cetakInformasi() {
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("[%s] Saldo saat ini: Rp%,.0f%n", namaMetode, saldo);
        System.out.println("-----------------------------------------------------------------------");
    }

    public String getNamaMetode() {
        return namaMetode;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    // ! DON'T MODIFY
}
