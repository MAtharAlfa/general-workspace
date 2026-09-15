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

    static int inputInteger(std::string pesan, int min) {
        int input;

        while (true) {
            std::cout << pesan << "\n";
            std::cin >> input;

            if (input >= min) {
                break;
            }

            std::cout
                << "input error(): nilai tidak valid\n";
        }

        return input;
    }


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
};


int main() {

    // Objek 1
    std::cout << "Objek 1:\n";

    KombinasiPermutasi KP1(5, 3);

    KP1.printKombinasi();
    KP1.printPermutasi();

    std::cout << "\n";


    // Objek 2
    std::cout << "Objek 2:\n";

    KombinasiPermutasi KP2;

    KP2.setN(4);
    KP2.setR(2);

    KP2.printKombinasi();
    KP2.printPermutasi();

    std::cout << "\n";


    // Objek 3
    std::cout << "Objek 3:\n";

    KombinasiPermutasi KP3;

    std::cout << "Masukan angka (minimal 0)\n";
    int inputN;

    while (true) {
        std::cin >> inputN;

        if (inputN >= 0) {
            break;
        }

        std::cout << "input error(): nilai tidak valid\n";
        std::cout << "Masukan angka (minimal 0)\n";
    }

    KP3.setN(inputN);


    std::cout << "Masukan angka (minimal 0)\n";
    int inputR;

    while (true) {
        std::cin >> inputR;

        if (inputR >= 0) {
            break;
        }

        std::cout << "input error(): nilai tidak valid\n";
        std::cout << "Masukan angka (minimal 0)\n";
    }

    KP3.setR(inputR);

    KP3.printKombinasi();
    KP3.printPermutasi();

    std::cout << "\n";


    // Objek 4
    std::cout << "Objek 4:\n";

    KombinasiPermutasi KP4;

    KP4.jalankanKombinasi();
    KP4.jalankanPermutasi();

    std::cout << "\n";

    return 0;
}
