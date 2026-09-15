/* 
Nama Program    : Hitung Gaji Total
Nama Pembuat    : Muhammad Athar Alfarisi
NPM             : 140810250005
Tanggal Buat    : 08/09/2026
Deskripsi       : Program memasukan input nama dan golongan untuk mencari gaji pokok, tunjangan, potongan, dan gaji utama
*/

// compile pakai: javac -cp "fliptables-1.x.x.jar" CLASS.java
// run pakai: java -cp ".;fliptables-1.x.x.jar" CLASS
// do pay attention to the version that you have

// obj1 -> constructor, obj2 -> setter (konstanta), obj3 -> input/scanner di main masuk ke setter, obj4 -> input dalam class pakai scanner

import java.util.Scanner;
import com.jakewharton.fliptables.FlipTable;
import java.text.DecimalFormat;

public class Soal3_MainPegawai {
    static public void main(String[] args) {
        System.out.println("Objek 1:");
        Pegawai pegawai2 = new Pegawai("Ateng", 2);
        pegawai2.cetakTabel();

        System.out.println("Objek 2:");
        Pegawai pegawai3 = new Pegawai();
        pegawai3.setPegawai("Cicit", 3);
        pegawai3.cetakTabel();
        System.out.println();

        System.out.println("Objek 3:");
        Pegawai pegawai4 = new Pegawai();
        pegawai4.setPegawai(Pegawai.inputString("Masukan nama: "), Pegawai.inputInteger("Masukan integer: ", 1, 4));
        pegawai4.cetakTabel();
        System.out.println();

        System.out.println("Objek 4:");
        Pegawai pegawai1 = new Pegawai();
        pegawai1.hitungGaji();
        System.out.println();
    }
}

class Pegawai {
    private String nama;
    private int golongan;

    public void hitungGaji() {
        System.out.println("----------Tentukan Gaji Pegawai----------");
        String nama = inputString("Masukan nama: ");
        Integer golongan = inputInteger("Masukan golongan: ", 1, 4);
        cetakTabel(nama, golongan);
    }

    public Pegawai(String nama, int golongan) {
        this.nama = nama;
        this.golongan = golongan;
    }

    public Pegawai() {
        this(null, 0);
    }

    public void setPegawai(String nama, int golongan) {
        this.nama = nama;
        this.golongan = golongan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setGolongan(int golongan) {
        this.golongan = golongan;
    }
    public String getNama() {
        return nama;
    }
    public int getGolongan() {
        return golongan;
    }

    void cetakTabel(String nama, Integer golongan){
        String[] headers = {"Nama", "Golongan", "Gaji Pokok", "Tunjangan", "Potongan", "Gaji Total"};
        String[][] data = {{nama,  Integer.toString(golongan), rupiahDFormat.format(tentukanGP(golongan)), rupiahDFormat.format(tentukanTunjangan(golongan)), 
                        rupiahDFormat.format(tentukanPotongan(golongan)), rupiahDFormat.format(tentukanGT(golongan))}};
        
        System.out.println(FlipTable.of(headers, data));
    }

    void cetakTabel(){
        String[] headers = {"Nama", "Golongan", "Gaji Pokok", "Tunjangan", "Potongan", "Gaji Total"};
        String[][] data = {{nama,  Integer.toString(golongan), rupiahDFormat.format(tentukanGP(golongan)), rupiahDFormat.format(tentukanTunjangan(golongan)), 
                        rupiahDFormat.format(tentukanPotongan(golongan)), rupiahDFormat.format(tentukanGT(golongan))}};
        
        System.out.println(FlipTable.of(headers, data));
    }

    //Gaji Utama
    Float tentukanGT(Integer golongan){
        Integer gajiPokok = tentukanGP(golongan);

        return (float)gajiPokok + tentukanTunjangan(golongan) - tentukanPotongan(golongan);
    }

    Float tentukanTunjangan(Integer golongan){
        return tentukanGP(golongan)*tentukanKonstantaTunjangan(golongan);
    }

    Float tentukanPotongan(Integer golongan){
        return tentukanGP(golongan)*tentukanKonstantaPotongan(golongan);
    }

    //Gaji Pokok
    Integer tentukanGP(Integer golongan){
        if (golongan == 1) return 1500000;
        if (golongan == 2) return 2000000;
        if (golongan == 3) return 3000000;
        if (golongan == 4) {return 5000000;}
        else return -1;
    }
    
    Float tentukanKonstantaTunjangan(Integer golongan){
        if (golongan == 1) return 0.1f;
        if (golongan == 2 || golongan == 3) return 0.12f;
        if (golongan == 4) {return 0.15f;}
        else return -1.0f;
    }

    Float tentukanKonstantaPotongan(Integer golongan){
        if (golongan == 1) return 0.01f;
        if (golongan == 2 || golongan == 3) return 0.02f;
        if (golongan == 4) {return 0.04f;}
        else return -1.0f;
    }

    private static Scanner sc = new Scanner(System.in);

    static String inputString(String pesan){
        System.out.println(pesan);
        return sc.nextLine();
    }

    static Integer inputInteger(String pesan, int min, int max){
        Integer input;

        while (true) {
            System.out.println(pesan);
            input = Integer.parseInt(sc.nextLine());

            if (input >= min && input <= max) break;

            System.out.println("input error(): nilai tidak valid");
        }

        return input;
    }

    static private DecimalFormat rupiahDFormat = new DecimalFormat("Rp#,###.00");
}
