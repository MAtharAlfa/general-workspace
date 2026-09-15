/* 
Nama Program    : Program Pemeriksa Biner
Nama Pembuat    : Muhammad Athar Alfarisi
NPM             : 140810250005
Tanggal Buat    : 01/09/2026
Deskripsi       : Program memeriksa biner antara dua nilai dan operasi-operasinya
*/

#include <iostream>
#include <string>
#include <sstream>
#include <iomanip>

class BitOperations {
    private:
    int A;
    int B;

    public:
    // Constructor with parameters
    BitOperations(int A, int B) {
        this->A = A;
        this->B = B;
    }

    // Default constructor
    BitOperations() {
        this->A = 0;
        this->B = 0;
    }

    // Setter
    void setA(int a) {
        A = a;
    }

    void setB(int b) {
        B = b;
    }

    // Getter
    int getA() {
        return A;
    }

    int getB() {
        return B;
    }

    void cetakHasil() {
        std::cout << "Nilai biner " << A << "\n";
        std::cout << "Biner: ";
        printIntegerToBinary(A);
        std::cout << "Hex: ";
        printIntegerToHex(A);
        std::cout << "Octal: ";
        printIntegerToOctal(A);
        std::cout << "\n";

        std::cout << "Nilai biner " << B << "\n";
        std::cout << "Biner: ";
        printIntegerToBinary(B);
        std::cout << "Hex: ";
        printIntegerToHex(B);
        std::cout << "Octal: ";
        printIntegerToOctal(B);
        std::cout << "\n";

        std::cout << "Hasil Operasi Biner " << A << " AND " << B << "\n";
        std::cout << "Desimal: " << (A & B) << "\n";
        std::cout << "Biner: ";
        printIntegerToBinary(A & B);
        std::cout << "Hex: ";
        printIntegerToHex(A & B);
        std::cout << "Octal: ";
        printIntegerToOctal(A & B);
        std::cout << "\n";

        std::cout << "Hasil Operasi Biner " << A << " OR " << B << "\n";
        std::cout << "Desimal: " << (A | B) << "\n";
        std::cout << "Biner: ";
        printIntegerToBinary(A | B);
        std::cout << "Hex: ";
        printIntegerToHex(A | B);
        std::cout << "Octal: ";
        printIntegerToOctal(A | B);
        std::cout << "\n";

        std::cout << "Hasil Operasi Biner " << A << " XOR " << B << "\n";
        std::cout << "Desimal: " << (A ^ B) << "\n";
        std::cout << "Biner: ";
        printIntegerToBinary(A ^ B);
        std::cout << "Hex: ";
        printIntegerToHex(A ^ B);
        std::cout << "Octal: ";
        printIntegerToOctal(A ^ B);
        std::cout << "\n";

        std::cout << "Hasil Operasi Biner left shift " << A
                  << " sebanyak 2:\n";
        std::cout << "Desimal: " << (A << 2) << "\n";
        std::cout << "Biner: ";
        printIntegerToBinary(A << 2);
        std::cout << "Hex: ";
        printIntegerToHex(A << 2);
        std::cout << "Octal: ";
        printIntegerToOctal(A << 2);
        std::cout << "\n";

        std::cout << "Hasil Operasi Biner right shift " << B
                  << " sebanyak 1:\n";
        std::cout << "Desimal: " << (B >> 1) << "\n";
        std::cout << "Biner: ";
        printIntegerToBinary(B >> 1);
        std::cout << "Hex: ";
        printIntegerToHex(B >> 1);
        std::cout << "Octal: ";
        printIntegerToOctal(B >> 1);
    }

    void inputBitOperations() {
        std::cout << "Masukan integer: ";
        std::cin >> A;

        std::cout << "Masukan integer: ";
        std::cin >> B;
    }

    private:

    void printIntegerToBinary(int nilai) {
        std::string hasil = "";

        do {
            int temp = nilai % 2;
            hasil += std::to_string(temp);
            nilai /= 2;
        } while (nilai > 0);

        // Reverse the string
        std::string reversed = "";
        for (int i = hasil.length() - 1; i >= 0; i--) {
            reversed += hasil[i];
        }

        // Pad with zeros until 8 characters
        while (reversed.length() < 8) {
            reversed = "0" + reversed;
        }

        std::cout << "0b" << reversed << "\n";
    }

    void printIntegerToOctal(int nilai) {
        std::string hasil = "";

        do {
            int temp = nilai % 8;
            hasil += std::to_string(temp);
            nilai /= 8;
        } while (nilai > 0);

        // Reverse the string
        std::string reversed = "";
        for (int i = hasil.length() - 1; i >= 0; i--) {
            reversed += hasil[i];
        }

        std::cout << "0o" << reversed << "\n";
    }

    void printIntegerToHex(int nilai) {
        std::string hasil = "";

        do {
            int temp = nilai % 16;

            if (temp < 10) {
                hasil += std::to_string(temp);
            } else {
                switch (temp) {
                    case 10:
                        hasil += 'A';
                        break;
                    case 11:
                        hasil += 'B';
                        break;
                    case 12:
                        hasil += 'C';
                        break;
                    case 13:
                        hasil += 'D';
                        break;
                    case 14:
                        hasil += 'E';
                        break;
                    case 15:
                        hasil += 'F';
                        break;
                }
            }

            nilai /= 16;
        } while (nilai > 0);

        // Reverse the string
        std::string reversed = "";
        for (int i = hasil.length() - 1; i >= 0; i--) {
            reversed += hasil[i];
        }

        std::cout << "0x" << reversed << "\n";
    }
};


int main() {

    // objek 1
    std::cout << "Objek 1:\n";
    BitOperations BO1(53, 19);
    BO1.cetakHasil();
    std::cout << "\n\n";


    // objek 2
    std::cout << "Objek 2:\n";
    BitOperations BO2;
    BO2.setA(53);
    BO2.setA(19);
    BO2.cetakHasil();
    std::cout << "\n\n";


    // objek 3
    std::cout << "Objek 3:\n";
    BitOperations BO3;

    int input;

    std::cout << "Masukan angka: ";
    std::cin >> input;
    BO3.setA(input);

    std::cout << "Masukan angka: ";
    std::cin >> input;
    BO3.setB(input);

    BO3.cetakHasil();
    std::cout << "\n\n";


    // objek 4
    std::cout << "Objek 4:\n";
    BitOperations BO4;
    BO4.inputBitOperations();
    BO4.cetakHasil();
    std::cout << "\n";

    return 0;
}
