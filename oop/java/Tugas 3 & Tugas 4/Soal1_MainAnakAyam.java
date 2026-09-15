/* 
Nama Program    : Anak Ayam
Nama Pembuat    : Muhammad Athar Alfarisi
NPM             : 140810250005
Tanggal Buat    : 08/09/2026
Deskripsi       : Penggunaan konsep perulangan dalam java menggunakan anak ayam 
*/

import java.util.Scanner;

public class Soal1_MainAnakAyam {
    public static void main(String[] args){
        System.out.println("Objek 1:");
        AnakAyam ayam1 = new AnakAyam(3);
        ayam1.cetakAnakAyam();
        System.out.println();

        System.out.println("Objek 2:");
        AnakAyam ayam2 = new AnakAyam();
        ayam2.setAnakAyam(3);
        ayam2.cetakAnakAyam();
        System.out.println();

        System.out.println("Objek 3:");
        AnakAyam ayam3 = new AnakAyam();
        ayam3.setAnakAyam(AnakAyam.inputInteger("Masukan integer nilai: "));
        ayam3.cetakAnakAyam();
        System.out.println();

        System.out.println("Objek 4:");
        AnakAyam ayam4 = new AnakAyam();
        ayam4.runAnakAyam();
    }
}

class AnakAyam {
    private int anakAyam;

    public AnakAyam(int anakAyam) {
        this.anakAyam = anakAyam;
    }

    public AnakAyam(){
        this(0);
    }

    public void setAnakAyam(int anakAyam) {
        this.anakAyam = anakAyam;
    }

    public int getAnakAyam() {
        return anakAyam;
    }

    public void runAnakAyam() {
        Integer input = inputInteger("Banyak anak ayam (minimal 1): ");

        for (int i = input; i > 0;) {
            if (i != 0) System.out.println("Anak ayam turunlah " + i);
            --i;
            
            if (i > 0) {
                System.out.println("Mati satu tinggallah " + i);   
            } else {
                System.out.println("Mati satu tinggal induknya.");
            }
        }
    }

    public void cetakAnakAyam() {
        for (int i = anakAyam; i > 0;) {
            if (i != 0) System.out.println("Anak ayam turunlah " + i);
            --i;
            
            if (i > 0) {
                System.out.println("Mati satu tinggallah " + i);   
            } else {
                System.out.println("Mati satu tinggal induknya.");
            }
        }
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
}