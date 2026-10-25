/* 
Nama Program    : Persegi Luas
Nama Pembuat    : Muhammad Athar Alfarisi
NPM             : 140810250005
Tanggal Buat    : 08/09/2026
Deskripsi       : Menghitung luas, keliling, dan diagonal persegi panjang 
*/

#include <iostream>
#include <cmath>

class Persegi {
    private:
    double panjang;
    double lebar;
    
    public:
    Persegi(){
        panjang = 0;
        lebar = 0;
    }
    Persegi(double panjang, double lebar){
        this->panjang = panjang;
        this->lebar = lebar;
    }
    void setPanjang(double panjang) {
        this->panjang = panjang;
    }
    void setLebar(double lebar) {
        this->lebar = lebar;
    }
    void setPersegi(double panjang, double lebar) {
        this->panjang;
        this->lebar;
    }
    double getPanjang() {
        return panjang;
    }
    double getLebar() {
        return lebar;
    }
    double getLuas() {
        return (panjang * lebar);
    }
    double getKeliling() {
        return 2*(panjang + lebar);
    }
    double getDiagonal() {
        return std::sqrt(std::pow(panjang, 2) + std::pow(lebar, 2));
    }
    void cetakInfoPersegi() {
        std::cout << "Panjang: " << panjang << "\n";
        std::cout << "Lebar: " << lebar << "\n";
        std::cout << "Luas: " << getLuas() << "\n";
        std::cout << "Keliling: " << getKeliling() << "\n";
        std::cout << "Diagonal: " << getDiagonal() << "\n";
    }
    void inputData() {
        std::cout << "Input data dari dalam class\n";
        std::cout << "Masukkan panjang: ";
        std::cin >> panjang; std::cout << "\n";
        std::cout << "Masukkan lebar: "; 
        std::cin >> lebar; std::cout << "\n\n";
    }
};

int main() {

    // Objek 1
    Persegi persegi1(3, 4);

    // Objek 2
    Persegi persegi2;
    persegi2.setPanjang(6);
    persegi2.setLebar(8);

    // Objek 3
    Persegi persegi3;
    double input = 0;

    std::cout << "Masukan panjang objek 3: ";
    std::cin >> input;
    persegi3.setPanjang(input);
    std::cin.clear();

    std::cout << "Masukan lebar objek 3: ";
    std::cin >> input;
    persegi3.setLebar(input);
    std::cin.clear();

    // Objek 4
    Persegi persegi4;

    // MENU
    int pilihan;
    do {
        std::cout << "\n========================\n";
        std::cout << "       MENU OBJEK\n";
        std::cout << "========================\n";
        std::cout << "1. Jalankan Objek 1\n";
        std::cout << "2. Jalankan Objek 2\n";
        std::cout << "3. Jalankan Objek 3\n";
        std::cout << "4. Jalankan Objek 4\n";
        std::cout << "0. Keluar\n";
        std::cout << "Pilih objek: ";
        std::cin >> pilihan;

        std::cout << "\n";

        switch (pilihan) {

            case 1:
                std::cout << "===== OBJEK 1 =====\n";
                persegi1.cetakInfoPersegi();
                break;

            case 2:
                std::cout << "===== OBJEK 2 =====\n";
                persegi2.cetakInfoPersegi();
                break;

            case 3:
                std::cout << "===== OBJEK 3 =====\n";
                persegi3.cetakInfoPersegi();
                break;

            case 4:
                std::cout << "===== OBJEK 4 =====\n";

                persegi4.inputData();

                persegi4.cetakInfoPersegi();
                break;

            case 0:
                std::cout << "Program selesai.\n";
                break;

            default:
                std::cout << "Pilihan tidak valid!\n";
        }

    } while (pilihan != 0);

    return 0;
}
