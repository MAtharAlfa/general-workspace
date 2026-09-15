/* 
Nama Program    : Program Pencetak Bintang
Nama Pembuat    : Muhammad Athar Alfarisi
NPM             : 140810250005
Tanggal Buat    : 08/09/2026
Deskripsi       : Program memasukan input n untuk membuat pola selebar input n
*/

#include <iostream>
#include <string>

class CetakBintang {
    private:
    int lebarKolom;

    public:

    void jalankanProgramPencetakPola() {
        int input = inputInteger("Masukan lebar kolom (minimal 1): ", 0);

        setLebarKolom(input);

        std::cout << "\nSegitiga: \n";
        cetakBintangPola1();

        std::cout << "Segitiga (pakai while): \n";
        cetakBintangPola1While();

        std::cout << "Pola Dua\n";
        cetakBintangPola2();

        std::cout << "Pola Dua (pakai while):\n";
        cetakBintangPola2While();
    }

    void cetakPola() {
        std::cout << "\nSegitiga: \n";
        cetakBintangPola1();

        std::cout << "Segitiga (pakai while): \n";
        cetakBintangPola1While();

        std::cout << "Pola Dua\n";
        cetakBintangPola2();

        std::cout << "Pola Dua (pakai while):\n";
        cetakBintangPola2While();
    }


    // Constructor with parameter
    CetakBintang(int lebarKolom) {
        this->lebarKolom = lebarKolom;
    }

    // Default constructor
    CetakBintang() {
        this->lebarKolom = 0;
    }


    // Setter
    void setLebarKolom(int lebarKolom) {
        this->lebarKolom = lebarKolom;
    }


    // Getter
    int getLebarKolom() {
        return lebarKolom;
    }


    private:

    void cetakBintangPola1() {
        bool goLeft = false;

        for (
            int helper = 0, i = 0;
            i < lebarKolom + (lebarKolom - 1);
            ++i
        ) {

            std::cout << (i + 1) << ". ";

            for (int j = 0; j < lebarKolom; ++j) {
                if (j <= helper) {
                    std::cout << "*";
                } else {
                    std::cout << " ";
                }
            }

            // If intended width is reached,
            // then go left
            if (helper == (lebarKolom - 1)) {
                goLeft = true;
            }

            // Dictate direction
            if (goLeft == false) {
                ++helper;
            } else {
                --helper;
            }

            std::cout << "\n";
        }
    }


    void cetakBintangPola1While() {
        bool goLeft = false;

        int helper = 0;
        int i = 0;

        while (i < lebarKolom + (lebarKolom - 1)) {

            std::cout << (i + 1) << ". ";

            for (int j = 0; j < lebarKolom; ++j) {
                if (j <= helper) {
                    std::cout << "*";
                } else {
                    std::cout << " ";
                }
            }

            // If intended width is reached,
            // then go left
            if (helper == (lebarKolom - 1)) {
                goLeft = true;
            }

            // Dictate direction
            if (goLeft == false) {
                ++helper;
            } else {
                --helper;
            }

            std::cout << "\n";

            ++i;
        }
    }


    void cetakBintangPola2() {
        bool goRight = false;

        for (
            int helper = lebarKolom - 1, i = 0;
            i < lebarKolom + (lebarKolom - 1);
            ++i
        ) {

            std::cout << (i + 1) << ". ";

            for (int j = 0; j < lebarKolom; ++j) {
                if (j <= helper) {
                    std::cout << "*";
                } else {
                    std::cout << " ";
                }
            }

            // If intended width is reached,
            // then go right
            if (helper == 0) {
                goRight = true;
            }

            // Dictate direction
            if (goRight == false) {
                --helper;
            } else {
                ++helper;
            }

            std::cout << "\n";
        }
    }


    void cetakBintangPola2While() {
        bool goRight = false;

        int helper = lebarKolom - 1;
        int i = 0;

        while (i < lebarKolom + (lebarKolom - 1)) {

            std::cout << (i + 1) << ". ";

            for (int j = 0; j < lebarKolom; ++j) {
                if (j <= helper) {
                    std::cout << "*";
                } else {
                    std::cout << " ";
                }
            }

            // If intended width is reached,
            // then go right
            if (helper == 0) {
                goRight = true;
            }

            // Dictate direction
            if (goRight == false) {
                --helper;
            } else {
                ++helper;
            }

            std::cout << "\n";

            ++i;
        }
    }


    public:
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
    std::cout << "Objek 1: \n";
    CetakBintang bintang1(3);
    bintang1.cetakPola();
    std::cout << "\n";


    // Objek 2
    std::cout << "Objek 2: \n";
    CetakBintang bintang2;
    bintang2.setLebarKolom(2);
    bintang2.cetakPola();
    std::cout << "\n";


    // Objek 3
    std::cout << "Objek 3:\n";
    CetakBintang bintang4;

    bintang4.setLebarKolom(
        CetakBintang::inputInteger("Masukan integer (minimal 1): ", 1)
    );

    bintang4.cetakPola();
    std::cout << "\n";


    // Objek 4
    std::cout << "Objek 4: \n";
    CetakBintang bintang3;
    bintang3.jalankanProgramPencetakPola();
    std::cout << "\n";

    return 0;
}
