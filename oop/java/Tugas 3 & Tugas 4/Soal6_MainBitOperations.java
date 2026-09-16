/* 
Nama Program    : Program Pemeriksa Biner
Nama Pembuat    : Muhammad Athar Alfarisi
NPM             : 140810250005
Tanggal Buat    : 01/09/2026
Deskripsi       : Program memeriksa biner antara dua nilai dan operasi-operasinya
*/

public class Soal6_MainBitOperations {
    static public void main(String[] args){
        System.out.println("Objek 1:");
        BitOperations BO1 = new BitOperations(53,19);
        BO1.cetakHasil();
        System.out.println();

        System.out.println("Objek 2:");
        BitOperations BO2 = new BitOperations();
        BO2.setA(53);
        BO2.setB(19);
        BO2.cetakHasil();
        System.out.println();

        System.out.println("Objek 3:");
        BitOperations BO3 = new BitOperations();
        BO3.setA(CetakBintang.inputInteger("Masukan angka (minimal 0)", 0));
        BO3.setB(CetakBintang.inputInteger("Masukan angka (minimal 0)", 0));
        BO3.cetakHasil();
        System.out.println();

        System.out.println("Objek 4:");
        BitOperations BO4 = new BitOperations();
        BO4.inputBitOperations();
        BO4.cetakHasil();
        System.out.println();
    }
}

class BitOperations {
    public void cetakHasil() {
        System.out.println("Nilai biner " + A);
        System.out.print("Biner: "); printIntegerToBinary(A);
        System.out.print("Hex: "); printIntegerToHex(A);
        System.out.print("Octal: "); printIntegerToOctal(A);
        System.out.println("\n");

        System.out.println("Nilai biner " + B);
        System.out.print("Biner: "); printIntegerToBinary(B);
        System.out.print("Hex: "); printIntegerToHex(B);
        System.out.print("Octal: "); printIntegerToOctal(B);
        System.out.println("\n");

        System.out.println("Hasil Operasi Biner " + A + " AND " + B);
        System.out.println("Desimal: " + (A & B));
        System.out.print("Biner: "); printIntegerToBinary(A & B);
        System.out.print("Hex: "); printIntegerToHex(A & B);
        System.out.print("Octal: "); printIntegerToOctal(A & B);
        System.out.println("\n");

        System.out.println("Hasil Operasi Biner " + A + " OR " + B);
        System.out.println("Desimal: " + (A | B));
        System.out.print("Biner: "); printIntegerToBinary(A | B);
        System.out.print("Hex: "); printIntegerToHex(A | B);
        System.out.print("Octal: "); printIntegerToOctal(A | B);
        System.out.println("\n");

        System.out.println("Hasil Operasi Biner " + A + " XOR " + B);
        System.out.println("Desimal: " + (A ^ B));
        System.out.print("Biner: "); printIntegerToBinary(A ^ B);
        System.out.print("Hex: "); printIntegerToHex(A ^ B);
        System.out.print("Octal: "); printIntegerToOctal(A ^ B);
        System.out.println("\n");

        System.out.println("Hasil Operasi Biner left shift " + A + " sebanyak 2:");
        System.out.println("Desimal: " + (A << 2));
        System.out.print("Biner: "); printIntegerToBinary(A << 2);
        System.out.print("Hex: "); printIntegerToHex(A << 2);
        System.out.print("Octal: "); printIntegerToOctal(A << 2);
        System.out.println("\n");

        System.out.println("Hasil Operasi Biner right shift " + B + " sebanyak 1:");
        System.out.println("Desimal: " + (B >> 1));
        System.out.print("Biner: "); printIntegerToBinary(B >> 1);
        System.out.print("Hex: "); printIntegerToHex(B >> 1);
        System.out.print("Octal: "); printIntegerToOctal(B >> 1);
    }

    private int A, B;

    public BitOperations(int A, int B) {
        this.A = A; 
        this.B = B;
    }

    public BitOperations() {
        this(0,0);
    }

    public void setA(int a) {
        A = a;
    }

    public void setB(int b) {
        B = b;
    }

    public int getA() {
        return A;
    }

    public int getB() {
        return B;
    }

    public void inputBitOperations() {
        setA(CetakBintang.inputInteger("Masukan integer: "));
        setB(CetakBintang.inputInteger("Masukan integer: "));
    }

    private void printIntegerToBinary(Integer nilai){
        StringBuilder hasil = new StringBuilder();
        do {
            Integer temp = nilai % 2;
            hasil.append(temp.toString());
            nilai /= 2; 
        } while (nilai > 0);

        String paddZero = String.format("%08d", Long.parseLong(hasil.reverse().toString()));
        System.out.println("0b" + paddZero);
    }

    private void printIntegerToOctal(Integer nilai){
        StringBuilder hasil = new StringBuilder();
        do {
            Integer temp = nilai % 8;
            hasil.append(temp.toString());
            nilai /= 8;     
        } while (nilai > 0);

        System.out.println("0o" + hasil.reverse().toString());
    }

    private void printIntegerToHex(Integer nilai){
        StringBuilder hasil = new StringBuilder();
        {
            Integer temp = nilai % 16;
            if (temp < 10) {
                hasil.append(temp.toString());   
            } else {
                switch (temp) {
                    case 10:
                        hasil.append('A');
                        break;
                    case 11:
                        hasil.append('B');
                        break;
                    case 12:
                        hasil.append('C');
                        break;
                    case 13:
                        hasil.append('D');
                        break;
                    case 14:
                        hasil.append('E');
                        break;
                    case 15:
                        hasil.append('F');
                        break;
                
                    default:
                        System.out.println();
                        System.out.println("error");
                        break;
                }
            }
            nilai /= 16;     
        }
        System.out.println("0x" + hasil.reverse().toString());
    }
}
