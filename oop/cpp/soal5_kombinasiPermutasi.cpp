/* 
Nama Program    : Kombinasi & Permutasi
Nama Pembuat    : Muhammad Athar Alfarisi
NPM             : 140810250005
Tanggal Buat    : 01/09/2026
Deskripsi       : Program menerima input integer lalu memberi nilai permutasi dan kombinasi
*/

#include <iostream>
#include <string>
#include <iomanip>
#include <sstream>

class KombinasiPermutasi {
    private:
    int n;
    int r;

    public:

    void jalankanKombinasi() {
        std::cout
            << "----------Program penghitung kombinatorik----------\n";

        int n = inputInteger("Masukan nilai N: ", 0);
        int r = inputInteger("Masukan nilai R: ", 0);

        std::cout
            << "Hasil: "
            << decimalFormat(kombinasi(n, r))
            << "\n";
    }


    void jalankanPermutasi() {
        std::cout
            << "----------Program penghitung permutasi----------\n";

        int n = inputInteger("Masukan nilai N: ", 0);
        int r = inputInteger("Masukan nilai R: ", 0);

        std::cout
            << "Hasil: "
            << decimalFormat(permutasi(n, r))
            << "\n";
    }


    void cetakHasil() {
        std::cout
            << "Hasil: "
            << decimalFormat(permutasi(n, r))
            << "\n";
    }


    // Constructor with parameters
    KombinasiPermutasi(int n, int r) {
        this->n = n;
        this->r = r;
    }


    // Default constructor
    KombinasiPermutasi() {
        this->n = -1;
        this->r = -1;
    }


    // Setter
    void setN(int n) {
        this->n = n;
    }

    void setR(int r) {
        this->r = r;
    }


    void setFaktorial(int n, int r) {
        this->n = n;
        this->n = r;
    }


    // Getter
    int getN() {
        return n;
    }

    int getR() {
        return r;
    }


    void printKombinasi() {
        std::cout
            << "Hasil: "
            << decimalFormat(kombinasi(n, r))
            << "\n";
    }


    void printPermutasi() {
        std::cout
            << "Hasil: "
            << decimalFormat(permutasi(n, r))
            << "\n";
    }


    private:

    int factorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }


    int kombinasi(int n, int r) {
        return factorial(n)
             / (factorial(n - r) * factorial(r));
    }


    int permutasi(int n, int r) {
        return factorial(n)
             / factorial(n - r);
    }


    // Equivalent to DecimalFormat("#.00")
    std::string decimalFormat(float nilai) {
        std::stringstream ss;

        ss << std::fixed
           << std::setprecision(2)
           << nilai;

        return ss.str();
    }

    public:
    static int inputInteger(std::string pesan, int min, int max) {
        int input;

        while (true) {
            std::cout << pesan << "\n";
            std::cin >> input;

            if (input <=max && input >= min) {
                break;
            }

            std::cout << "input error(): nilai tidak valid\n";
        }

        return input;
    }

    static int inputInteger(std::string pesan, int min) {
        int input;

        while (true) {
            std::cout << pesan << "\n";
            std::cin >> input;

            if (input >= min) {
                break;
            }

            std::cout << "input error(): nilai tidak valid\n";
        }

        return input;
    }


    static int inputInteger(std::string pesan) {
        int input;

        std::cout << pesan << "\n";
        std::cin >> input;

        return input;
    }
};


int main() {
    // Objek 1
    KombinasiPermutasi KP1(5, 3);
    // Objek 2
    KombinasiPermutasi KP2;
    KP2.setN(4);
    KP2.setR(2);
    // Objek 3
    KombinasiPermutasi KP3;
    // Objek 4
    KombinasiPermutasi KP4;
    int pilihan;

    do {
        std::cout << "\n========================================\n";
        std::cout << "    MENU PROGRAM KOMBINASI PERMUTASI\n";
        std::cout << "========================================\n";
        std::cout << "1. Jalankan Objek 1\n";
        std::cout << "2. Jalankan Objek 2\n";
        std::cout << "3. Jalankan Objek 3\n";
        std::cout << "4. Jalankan Objek 4\n";
        std::cout << "5. Keluar\n";
        std::cout << "========================================\n";
        pilihan = KombinasiPermutasi::inputInteger("Pilih menu (1-5): ", 1, 5);
        std::cout << "\n";
        switch (pilihan) {
            case 1:
                std::cout << "========== OBJEK 1 ==========\n";
                KP1.printKombinasi();
                KP1.printPermutasi();
                break;
            case 2:
                std::cout << "========== OBJEK 2 ==========\n";
                KP2.printKombinasi();
                KP2.printPermutasi();
                break;
            case 3:
                std::cout << "========== OBJEK 3 ==========\n";
                std::cout << "Masukan angka N (minimal 0): ";
                int inputN;
                while (true) {
                    std::cin >> inputN;
                    if (inputN >= 0) {
                        break;
                    }
                    std::cout << "input error(): nilai tidak valid\n";
                    std::cout << "Masukan angka N (minimal 0): ";
                }
                KP3.setN(inputN);
                std::cout << "Masukan angka R (minimal 0): ";
                int inputR;
                while (true) {
                    std::cin >> inputR;
                    if (inputR >= 0) {
                        break;
                    }
                    std::cout << "input error(): nilai tidak valid\n";
                    std::cout << "Masukan angka R (minimal 0): ";
                }
                KP3.setR(inputR);
                KP3.printKombinasi();
                KP3.printPermutasi();
                break;
            case 4:
                std::cout << "========== OBJEK 4 ==========\n";
                KP4.jalankanKombinasi();
                KP4.jalankanPermutasi();
                break;
            case 5:
                std::cout << "Program selesai.\n";
                break;
        }
    } while (pilihan != 5);

    return 0;
}
