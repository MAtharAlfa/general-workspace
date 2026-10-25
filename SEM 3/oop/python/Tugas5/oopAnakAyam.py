# Nama Program    : Anak Ayam
# Nama Pembuat    : Muhammad Athar Alfarisi
# NPM             : 140810250005
# Tanggal Buat    : 22/09/2026
# Deskripsi       : Penggunaan konsep perulangan dalam java menggunakan anak ayam 


class AnakAyam:
    def __init__(self, jumlahAnak=0):
        self.jumlahAnak = jumlahAnak

    def setJumlahAnak(self, jumlahAnak):
        self.jumlahAnak = jumlahAnak

    def getJumlahAnak(self):
        return self.jumlahAnak

    def jalankanLagu(self):
        jumlahAnak = self.jumlahAnak
        print("\n")
        while jumlahAnak > 0:
            print("Anak ayam turunlah", jumlahAnak)
            jumlahAnak -= 1
            if (jumlahAnak > 0):
                print("Mati satu tinggallah", jumlahAnak)
            else:
                print("Tinggal induknya")

    def inputData(self):
        self.jumlahAnak = int(input("Masukkan jumlah anak ayam: "))


def main():
    print("OBJECT 1 - Constructor")
    anakAyam1 = AnakAyam(5)

    print("\nOBJECT 2 - Setter")
    anakAyam2 = AnakAyam()
    anakAyam2.setJumlahAnak(4)

    print("\nOBJECT 3 - Input dari main()")
    anakAyam3 = AnakAyam()

    anakAyam3.setJumlahAnak(int(input("Masukkan jumlah anak ayam: ")))

    print("\nOBJECT 4 - Input dari dalam class")
    anakAyam4 = AnakAyam()
    anakAyam4.inputData()
    
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
            anakAyam1.jalankanLagu()
        
        elif pilihan == "2":
            anakAyam2.jalankanLagu()
        
        elif pilihan == "3":
            anakAyam3.jalankanLagu()
        
        elif pilihan == "4":
            anakAyam4.jalankanLagu()
        
        elif pilihan == "5":
            anakAyam1.jalankanLagu()
            anakAyam2.jalankanLagu()
            anakAyam3.jalankanLagu()
            anakAyam4.jalankanLagu()
        
        elif pilihan == "0":
            print("Program selesai.")
            break
        
        else:
            print("Pilihan tidak valid.")

if __name__ == "__main__":
    main()