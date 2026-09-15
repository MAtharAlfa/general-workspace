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
    //objek 1
    Persegi persegi1(3, 4);
    std:: cout << "Objek 1:\n";
    persegi1.cetakInfoPersegi();
    std::cout << std::endl;

    //objek 2
    Persegi persegi2;
    std:: cout << "Objek 2:\n";
    persegi2.setPanjang(6);
    persegi2.setLebar(8);
    persegi2.cetakInfoPersegi();
    std::cout << std::endl;


    //objek 3
    Persegi persegi3;
    double input = 0;
    std:: cout << "Objek 3:\n";
    std:: cout << "Masukan panjang: ";
    std::cin >> input;
    persegi3.setPanjang(input);
    std::cin.clear();

    std:: cout << "Masukan lebar: ";
    std::cin >> input;
    persegi3.setLebar(input);
    std::cin.clear();

    persegi3.cetakInfoPersegi();
    std::cout << std::endl;

    
    //objek 4
    Persegi persegi4;
    std:: cout << "Objek 4:\n";
    persegi4.inputData();
    persegi4.cetakInfoPersegi();
}