/* 
Nama Program    : Program Pencetak Bintang
Nama Pembuat    : Muhammad Athar Alfarisi
NPM             : 140810250005
Tanggal Buat    : 08/09/2026
Deskripsi       : Program memasukan input n untuk membuat pola selebar input n
*/

import java.util.Scanner;

public class Soal4_MainCetakBintang {
    static public void main(String[] args) {
        System.out.println("Objek 1: ");
        CetakBintang bintang1 = new CetakBintang(3);
        bintang1.cetakPola();
        System.out.println();

        System.out.println("Objek 2: ");
        CetakBintang bintang2 = new CetakBintang();
        bintang2.setLebarKolom(2);
        bintang2.cetakPola();
        System.out.println();

        System.out.println("Objek 3:");
        CetakBintang bintang4 = new CetakBintang();
        bintang4.setLebarKolom(CetakBintang.inputInteger("Masukan integer (minimal 1): ", 1));
        bintang4.cetakPola();
        System.out.println();

        System.out.println("Objek 4: ");
        CetakBintang bintang3 = new CetakBintang();
        bintang3.jalankanProgramPencetakPola();;
        System.out.println();
    }
}

class CetakBintang {
    private int lebarKolom;

    public void jalankanProgramPencetakPola() {
        int input = inputInteger("Masukan lebar kolom (minimal 1): ", 0);
        setLebarKolom(input);

        System.out.println("\nSegitiga: ");
        cetakBintangPola1();
        System.out.println("Segitiga (pakai while): ");
        cetakBintangPola1While();
        System.out.println("Pola Dua");
        cetakBintangPola2();
        System.out.println("Pola Dua (pakai while):");
        cetakBintangPola2While();
    }

    public void cetakPola() {
        System.out.println("\nSegitiga: ");
        cetakBintangPola1();
        System.out.println("Segitiga (pakai while): ");
        cetakBintangPola1While();
        System.out.println("Pola Dua");
        cetakBintangPola2();
        System.out.println("Pola Dua (pakai while):");
        cetakBintangPola2While();
    }

    public CetakBintang(int lebarKolom) {
        this.lebarKolom = lebarKolom;
    }

    public CetakBintang() {
        this(0);
    }

    public void setLebarKolom(int lebarKolom) {
        this.lebarKolom = lebarKolom;
    }

    public int getLebarKolom() {
        return lebarKolom;
    }

    private  void cetakBintangPola1(){
        boolean goLeft = false; //default to going right first then left
        for(int helper = 0, i = 0; i < lebarKolom + (lebarKolom - 1); ++i){ //helper for logic, i for counter.

            System.out.print((i + 1) + ". ");
            for(int j = 0; j < lebarKolom; ++j){
                if (j <= helper) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            
            //if intended width is reached then go left with "*""
            if (helper == (lebarKolom - 1)){
                goLeft = true;
            }

            //dictate direction
            if (goLeft == false){
                ++helper;
            } else{
                --helper;
            }

            System.out.println();
        }
    }

    private void cetakBintangPola1While(){
        boolean goLeft = false; //default to going right first then left
        int helper = 0, i = 0;
        while (i < lebarKolom + (lebarKolom - 1)){

            System.out.print((i + 1) + ". ");
            for(int j = 0; j < lebarKolom; ++j){
                if (j <= helper) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            
            //if intended width is reached then go left with "*""
            if (helper == (lebarKolom - 1)){
                goLeft = true;
            }

            //dictate direction
            if (goLeft == false){
                ++helper;
            } else{
                --helper;
            }

            System.out.println();
            ++i;
        }
    }

    private void cetakBintangPola2(){ 
        boolean goRight = false;
        for(int helper = lebarKolom-1, i = 0; i < lebarKolom + (lebarKolom - 1); ++i){ //helper for logic, i for counter. helper -1 biar shift

            System.out.print((i + 1) + ". ");
            for(int j = 0; j < lebarKolom; ++j){
                if (j <= helper) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            
            //if intended width is reached then go right with " "
            if (helper == 0){ //set 0 as the absolute turning point
                goRight = true;
            }

            //dictate direction
            if (goRight == false){
                --helper;
            } else{
                ++helper;
            }

            System.out.println();
        }
    }

    private void cetakBintangPola2While(){ 
        boolean goRight = false;
        int helper = lebarKolom-1, i = 0;

        while (i < lebarKolom + (lebarKolom - 1)) {
            System.out.print((i + 1) + ". ");
            for(int j = 0; j < lebarKolom; ++j){
                if (j <= helper) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            
            //if intended width is reached then go right with " "
            if (helper == 0){ //set 0 as the absolute turning point
                goRight = true;
            }

            //dictate direction
            if (goRight == false){
                --helper;
            } else{
                ++helper;
            }

            System.out.println();
            ++i;
        }
    }

    static Scanner sc = new Scanner(System.in);

    static Integer inputInteger(String pesan, int min){
        Integer input;

        while (true) {
            System.out.println(pesan);
            input = Integer.parseInt(sc.nextLine());

            if (input >= min) break;

            System.out.println("input error(): nilai tidak valid");
        }

        return input;
    }

    static Integer inputInteger(String pesan){
        Integer input;

        System.out.println(pesan);
        input = Integer.parseInt(sc.nextLine());

        return input;
    }
}
