#include <iostream>
#include <iomanip>
#include <sstream>

class Pegawai {
    private:
    std::string nama;
    int golongan;

    public:

    void hitungGaji() {
        std::cout << "----------Tentukan Gaji Pegawai----------\n";

        std::string nama = inputString("Masukan nama: ");
        int golongan = inputInteger("Masukan golongan: ", 1, 4);

        cetakTabel(nama, golongan);
    }

    // Constructor with parameters
    Pegawai(std::string nama, int golongan) {
        this->nama = nama;
        this->golongan = golongan;
    }

    // Default constructor
    Pegawai() {
        this->nama = "";
        this->golongan = 0;
    }

    // Setter
    void setPegawai(std::string nama, int golongan) {
        this->nama = nama;
        this->golongan = golongan;
    }

    void setNama(std::string nama) {
        this->nama = nama;
    }

    void setGolongan(int golongan) {
        this->golongan = golongan;
    }

    // Getter
    std::string getNama() {
        return nama;
    }

    int getGolongan() {
        return golongan;
    }

    void cetakTabel(std::string nama, int golongan) {
        std::string headers[] = {
            "Nama",
            "Golongan",
            "Gaji Pokok",
            "Tunjangan",
            "Potongan",
            "Gaji Total"
        };

        std::string data[] = {
            nama,
            std::to_string(golongan),
            rupiahFormat(tentukanGP(golongan)),
            rupiahFormat(tentukanTunjangan(golongan)),
            rupiahFormat(tentukanPotongan(golongan)),
            rupiahFormat(tentukanGT(golongan))
        };

        printTable(headers, data, 6);
    }

    void cetakTabel() {
        std::string headers[] = {
            "Nama",
            "Golongan",
            "Gaji Pokok",
            "Tunjangan",
            "Potongan",
            "Gaji Total"
        };

        std::string data[] = {
            nama,
            std::to_string(golongan),
            rupiahFormat(tentukanGP(golongan)),
            rupiahFormat(tentukanTunjangan(golongan)),
            rupiahFormat(tentukanPotongan(golongan)),
            rupiahFormat(tentukanGT(golongan))
        };

        printTable(headers, data, 6);
    }


    // Gaji Utama
    float tentukanGT(int golongan) {
        int gajiPokok = tentukanGP(golongan);

        return (float)gajiPokok
             + tentukanTunjangan(golongan)
             - tentukanPotongan(golongan);
    }

    float tentukanTunjangan(int golongan) {
        return tentukanGP(golongan)
             * tentukanKonstantaTunjangan(golongan);
    }

    float tentukanPotongan(int golongan) {
        return tentukanGP(golongan)
             * tentukanKonstantaPotongan(golongan);
    }


    // Gaji Pokok
    int tentukanGP(int golongan) {
        if (golongan == 1) {
            return 1500000;
        }

        if (golongan == 2) {
            return 2000000;
        }

        if (golongan == 3) {
            return 3000000;
        }

        if (golongan == 4) {
            return 5000000;
        }

        else {
            return -1;
        }
    }


    float tentukanKonstantaTunjangan(int golongan) {
        if (golongan == 1) {
            return 0.1f;
        }

        if (golongan == 2 || golongan == 3) {
            return 0.12f;
        }

        if (golongan == 4) {
            return 0.15f;
        }

        else {
            return -1.0f;
        }
    }


    float tentukanKonstantaPotongan(int golongan) {
        if (golongan == 1) {
            return 0.01f;
        }

        if (golongan == 2 || golongan == 3) {
            return 0.02f;
        }

        if (golongan == 4) {
            return 0.04f;
        }

        else {
            return -1.0f;
        }
    }


    static std::string inputString(std::string pesan) {
        std::string input;

        std::cout << pesan << "\n";
        std::cin >> input;

        return input;
    }


    static int inputInteger(std::string pesan, int min, int max) {
        int input;

        while (true) {
            std::cout << pesan << "\n";
            std::cin >> input;

            if (input >= min && input <= max) {
                break;
            }

            std::cout << "input error(): nilai tidak valid\n";
        }

        return input;
    }


    private:

    // Equivalent=nya Java DecimalFormat("Rp#,###.00")
    static std::string rupiahFormat(float nilai) {
        std::stringstream ss;

        ss << "Rp"
           << std::fixed
           << std::setprecision(2)
           << nilai;

        return ss.str();
    }


    // Equivalent-nya FlipTable.of(headers, data)
    static void printTable(
        std::string headers[],
        std::string data[],
        int jumlahKolom
    ) {
        // array of column's width
        int lebar[6];

        // set each column widths
        for (int i = 0; i < jumlahKolom; i++) {
            lebar[i] = headers[i].length();

            if (data[i].length() > lebar[i]) {
                lebar[i] = data[i].length();
            }
        }

        // Top border
        std::cout << "+";
        for (int i = 0; i < jumlahKolom; i++) {
            for (int j = 0; j < lebar[i] + 2; j++) {
                std::cout << "-";
            }
            std::cout << "+";
        }
        std::cout << "\n";

        // Headers
        std::cout << "|";
        for (int i = 0; i < jumlahKolom; i++) {
            std::cout << " "
                      << std::left
                      << std::setw(lebar[i])
                      << headers[i]
                      << " |";
        }
        std::cout << "\n";

        // Header separator
        std::cout << "+";
        for (int i = 0; i < jumlahKolom; i++) {
            for (int j = 0; j < lebar[i] + 2; j++) {
                std::cout << "-";
            }
            std::cout << "+";
        }
        std::cout << "\n";

        // Data
        std::cout << "|";
        for (int i = 0; i < jumlahKolom; i++) {
            std::cout << " "
                      << std::left
                      << std::setw(lebar[i])
                      << data[i]
                      << " |";
        }
        std::cout << "\n";

        // Bottom border
        std::cout << "+";
        for (int i = 0; i < jumlahKolom; i++) {
            for (int j = 0; j < lebar[i] + 2; j++) {
                std::cout << "-";
            }
            std::cout << "+";
        }
        std::cout << "\n";
    }
};


int main() {

    // Objek 1
    std::cout << "Objek 1:\n";
    Pegawai pegawai2("Ateng", 2);
    pegawai2.cetakTabel();


    // Objek 2
    std::cout << "Objek 2:\n";
    Pegawai pegawai3;
    pegawai3.setPegawai("Cicit", 3);
    pegawai3.cetakTabel();
    std::cout << "\n";


    // Objek 3
    std::cout << "Objek 3:\n";
    Pegawai pegawai4;

    pegawai4.setPegawai(
        Pegawai::inputString("Masukan nama: "),
        Pegawai::inputInteger("Masukan integer: ", 1, 4)
    );

    pegawai4.cetakTabel();
    std::cout << "\n";


    // Objek 4
    std::cout << "Objek 4:\n";
    Pegawai pegawai1;
    pegawai1.hitungGaji();
    std::cout << "\n";

    return 0;
}
