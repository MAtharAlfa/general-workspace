# Nama Program    : Persegi Luas
# Nama Pembuat    : Muhammad Athar Alfarisi
# NPM             : 140810250005
# Tanggal Buat    : 22/09/2026
# Deskripsi       : Menghitung luas, keliling, dan diagonal persegi panjang 

import math

class PersegiPanjang:
    def __init__(self, panjang=0, lebar=0):
        self.panjang = panjang
        self.lebar = lebar

    # Setter
    def setPanjang(self, panjang):
        self.panjang = panjang

    def setLebar(self, lebar):
        self.lebar = lebar

    # Getter
    def getPanjang(self):
        return self.panjang

    def getLebar(self):
        return self.lebar

    def inputData(self):
        self.panjang = float(input("Masukkan panjang: "))
        self.lebar = float(input("Masukkan lebar: "))

    def getLuas(self):
        return self.panjang * self.lebar

    def getKeliling(self):
        return 2 * (self.panjang + self.lebar)

    def getDiagonal(self):
        return math.sqrt(self.panjang ** 2 + self.lebar ** 2)

    def cetak(self):
        print("\n=== Data Persegi Panjang ===")
        print("Panjang   :", self.panjang)
        print("Lebar     :", self.lebar)
        print("Luas      :", self.getLuas())
        print("Keliling  :", self.getKeliling())
        print("Diagonal  :", self.getDiagonal())            


def main():
    print("OBJECT 1 - Constructor")
    pp1 = PersegiPanjang(10, 5)

    print("\nOBJECT 2 - Setter")
    pp2 = PersegiPanjang()
    pp2.setPanjang(20)
    pp2.setLebar(8)

    print("\nOBJECT 3 - Input dari main()")
    pp3 = PersegiPanjang()

    pp3.setPanjang(float(input("Masukkan panjang: ")))
    pp3.setLebar(float(input("Masukkan lebar: ")))

    print("\nOBJECT 4 - Input dari dalam class")
    pp4 = PersegiPanjang()
    pp4.inputData()

    while True:
        print("\n---------- MENU ----------")
        print("1. Jalankan Objek 1")
        print("2. Jalankan Objek 2")
        print("3. Jalankan Objek 3")
        print("4. Jalankan Objek 4")
        print("5. Jalankan Semua Objek")
        print("0. Keluar")
        
        pilihan = input("Pilih menu: ")
        
        if pilihan == "1":
            pp1.cetak()
        
        elif pilihan == "2":
            pp2.cetak()
        
        elif pilihan == "3":
            pp3.cetak()
        
        elif pilihan == "4":
            pp4.cetak()
        
        elif pilihan == "5":
            pp1.cetak()
            pp2.cetak()
            pp3.cetak()
            pp4.cetak()
        
        elif pilihan == "0":
            print("Program selesai.")
            break
        
        else:
            print("Pilihan tidak valid.") 



if __name__ == "__main__":
    main()
