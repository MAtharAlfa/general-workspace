/* 
Nama Program    : Anak Ayam
Nama Pembuat    : Muhammad Athar Alfarisi
NPM             : 140810250005
Tanggal Buat    : 08/09/2026
Deskripsi       : Menghitung luas, keliling, dan diagonal persegi panjang 
*/

import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

public class Soal2_MainPersegiPanjang {
    public static void main(String[] args) {
        System.out.println("Objek 1:");
        PersegiPanjang persegiPanjang2 = new PersegiPanjang(6, 8);
        persegiPanjang2.cetakInfoPersegiPanjang();
        System.out.println();

        System.out.println("Objek 2:");
        PersegiPanjang persegiPanjang3 = new PersegiPanjang();
        persegiPanjang3.setPanjang(9);
        persegiPanjang3.setLebar(12);
        persegiPanjang3.cetakInfoPersegiPanjang();

        System.out.println("Objek 3:");
        PersegiPanjang persegiPanjang4 = new PersegiPanjang();
        persegiPanjang4.setPanjang(PersegiPanjang.inputInteger("Masukan panjang: "));
        persegiPanjang4.setLebar(PersegiPanjang.inputInteger("Masukan lebar: "));
        persegiPanjang4.cetakInfoPersegiPanjang();

        System.out.println("Objek 4:");
        PersegiPanjang persegiPanjang1 = new PersegiPanjang();
        persegiPanjang1.inputPersegiPanjang();
        persegiPanjang1.cetakInfoPersegiPanjang();
        System.out.println();
    }
}

class PersegiPanjang {
    private double panjang;
    private double lebar;

    public PersegiPanjang(int panjang, int lebar){
        this.panjang = panjang;
        this.lebar = lebar;
    }

    public PersegiPanjang(){
        this(0,0);
    }

    public double getLebar() {
        return lebar;
    }
    public double getPanjang() {
        return panjang;
    }
    public void setLebar(double lebar) {
        this.lebar = lebar;
    }
    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }
    public void setPersegiPanjang(double panjang, double lebar){
        this.panjang = panjang;
        this.lebar = lebar;
    }
    public void cetakInfoPersegiPanjang(){
        System.out.println("---------------------------------------");
        System.out.println("Panjang: " + df.format(panjang));
        System.out.println("Lebar: " + df.format(lebar));
        System.out.println("Luas: " + df.format(cariLuas()));
        System.out.println("Keliling: " + df.format(cariKeliling()));
        System.out.println("Diagonal: " + df.format(cariDiagonal()));
        System.out.println("---------------------------------------");
    }
    public double cariLuas(){
        return (panjang * lebar);
    }
    public double cariKeliling(){
        return (2*(panjang + lebar));
    }
    public double cariDiagonal(){
        return Math.sqrt(Math.pow(panjang, 2) + Math.pow(lebar,2));
    }

    public void inputPersegiPanjang() {
        setPanjang(inputInteger("Masukan nilai panjang (minimal 1):"));
        setLebar(inputInteger("Masukan nilai lebar (minimal 1):"));
    }

    private static Scanner sc = new Scanner(System.in);

    static Integer inputInteger(String pesan){
        Integer input;

        while (true) {
            System.out.println(pesan);
            input = Integer.parseInt(sc.nextLine());

            if (input > 0) break;

            System.out.println("input error(): nilai tidak valid");
        }

        return input;
    }

    private DecimalFormat df = new DecimalFormat("#.00");
}