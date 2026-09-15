/* 
Nama Program    : Kombinasi & Permutasi
Nama Pembuat    : Muhammad Athar Alfarisi
NPM             : 140810250005
Tanggal Buat    : 01/09/2026
Deskripsi       : Program menerima input integer lalu memberi nilai permutasi dan kombinasi
*/

import java.util.Scanner;
import java.text.DecimalFormat;

public class Soal5_MainKombinasiPermutasi {
    static public void main(String[] args){
        System.out.println("Objek 1:");
        KombinasiPermutasi KP1 = new KombinasiPermutasi(5,3);
        KP1.printKombinasi();
        KP1.printPermutasi();
        System.out.println();

        System.out.println("Objek 2:");
        KombinasiPermutasi KP2 = new KombinasiPermutasi();
        KP2.setN(4);
        KP2.setR(2);
        KP2.printKombinasi();
        KP2.printPermutasi();
        System.out.println();

        System.out.println("Objek 3:");
        KombinasiPermutasi KP3 = new KombinasiPermutasi();
        KP3.setN(CetakBintang.inputInteger("Masukan angka (minimal 0)", 0));
        KP3.setR(CetakBintang.inputInteger("Masukan angka (minimal 0)", 0));
        KP3.printKombinasi();
        KP3.printPermutasi();
        System.out.println();

        System.out.println("Objek 4:");
        KombinasiPermutasi KP4 = new KombinasiPermutasi();
        KP4.jalankanKombinasi();
        KP4.jalankanPermutasi();
        System.out.println();
    }
}

class KombinasiPermutasi{
    public void jalankanKombinasi() {
        System.out.println("----------Program penghitung kombinatorik----------");
        Integer n = inputInteger("Masukan nilai N: ", 0);
        Integer r = inputInteger("Masukan nilai R: ", 0);

        System.out.println("Hasil: " + df.format(kombinasi(n, r)));
    }

    public void jalankanPermutasi() {
        System.out.println("----------Program penghitung permutasi----------");
        Integer n = inputInteger("Masukan nilai N: ", 0);
        Integer r = inputInteger("Masukan nilai R: ", 0);

        System.out.println("Hasil: " + df.format(permutasi(n, r)));
    }

    public void cetakHasil() {System.out.println("Hasil: " + df.format(permutasi(n, r)));}

    private int n, r;

    public KombinasiPermutasi(int n, int r) {
        this.n = n;
        this.r = r;
    }

    public KombinasiPermutasi() {
        this(-1,-1);
    }

    public void setN(int n) {
        this.n = n;
    }
    
    public void setR(int r) {
        this.r = r;
    }

    public void setFaktorial(int n, int r) {
        this.n = n;
        this.n = r;
    }

    public int getN() {
        return n;
    }

    public int getR() {

        return r;
    }

    public void printKombinasi() {
        System.out.println("Hasil: " + df.format(kombinasi(n, r))); 
    }

    public void printPermutasi() {
        System.out.println("Hasil: " + df.format(permutasi(n, r))); 
    }

    static Scanner sc = new Scanner(System.in);

    private Integer inputInteger(String pesan, int min){
        Integer input;

        while (true) {
            System.out.println(pesan);
            input = Integer.parseInt(sc.nextLine());

            if (input >= min) break;

            System.out.println("input error(): nilai tidak valid");
        }

        return input;
    }

    private Integer factorial(Integer n){
        if (n == 1 || n == 0) return 1;
        return n*(factorial(n-1));
    }

    private Integer kombinasi(Integer n, Integer r) {
        return factorial(n)/(factorial(n-r)*factorial(r));
    }

    private Integer permutasi(Integer n, Integer r) {
        return factorial(n)/(factorial(n-r));
    }

    private DecimalFormat df = new DecimalFormat("#.00");
}