/* 
Nama Program    : Anak Ayam
Nama Pembuat    : Muhammad Athar Alfarisi
NPM             : 140810250005
Tanggal Buat    : 08/09/2026
Deskripsi       : Penggunaan konsep perulangan dalam java menggunakan anak ayam 
*/

#include <iostream>
#include <string>

class AnakAyam {
    private:
    int anakAyam;

    public:
    // Constructor with parameter
    AnakAyam(int anakAyam) {
        this->anakAyam = anakAyam;
    }

    // Default constructor
    AnakAyam() {
        this->anakAyam = 0;
    }

    // Setter
    void setAnakAyam(int anakAyam) {
        this->anakAyam = anakAyam;
    }

    // Getter
    int getAnakAyam() {
        return anakAyam;
    }

    void runAnakAyam() {
        int input = inputInteger("Banyak anak ayam (minimal 1): ");

        for (int i = input; i > 0;) {
            if (i != 0) {
                std::cout << "Anak ayam turunlah " << i << "\n";
            }

            --i;

            if (i > 0) {
                std::cout << "Mati satu tinggallah " << i << "\n";
            } else {
                std::cout << "Mati satu tinggal induknya.\n";
            }
        }
    }

    void cetakAnakAyam() {
        for (int i = anakAyam; i > 0;) {
            if (i != 0) {
                std::cout << "Anak ayam turunlah " << i << "\n";
            }

            --i;

            if (i > 0) {
                std::cout << "Mati satu tinggallah " << i << "\n";
            } else {
                std::cout << "Mati satu tinggal induknya.\n";
            }
        }
    }

    static int inputInteger(std::string pesan) {
        int input;

        while (true) {
            std::cout << pesan << "\n";
            std::cin >> input;

            if (input > 0) {
                break;
            }

            std::cout << "input error(): nilai tidak valid\n";
        }

        return input;
    }
};


int main() {

    // Objek 1
    std::cout << "Objek 1:\n";
    AnakAyam ayam1(3);
    ayam1.cetakAnakAyam();
    std::cout << "\n";


    // Objek 2
    std::cout << "Objek 2:\n";
    AnakAyam ayam2;
    ayam2.setAnakAyam(3);
    ayam2.cetakAnakAyam();
    std::cout << "\n";


    // Objek 3
    std::cout << "Objek 3:\n";
    AnakAyam ayam3;
    ayam3.setAnakAyam(
        AnakAyam::inputInteger("Masukan integer nilai: ")
    );
    ayam3.cetakAnakAyam();
    std::cout << "\n";


    // Objek 4
    std::cout << "Objek 4:\n";
    AnakAyam ayam4;
    ayam4.runAnakAyam();

    return 0;
}
