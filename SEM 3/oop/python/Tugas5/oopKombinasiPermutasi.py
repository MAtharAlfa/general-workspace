# Nama Program    : Kombinasi & Permutasi
# Nama Pembuat    : Muhammad Athar Alfarisi
# NPM             : 140810250005
# Tanggal Buat    : 22/09/2026
# Deskripsi       : Program menerima input integer lalu memberi nilai permutasi dan kombinasi

class KombinasiPermutasi:
    def __init__(self, n=0, r=0):
        self.n = n
        self.r = r

    def setN(self, n):
        self.n = n

    def setR(self, r):
        self.r = r

    def getN(self):
        return self.n

    def getR(self):
        return self.r

    def factorial(self, n):
        if n == 1 or n == 0:
            return 1

        return n * self.factorial(n - 1)

    def kombinasi(self, n, r):
        return self.factorial(n) // (
            self.factorial(n - r) * self.factorial(r)
        )

    def permutasi(self, n, r):
        return self.factorial(n) // self.factorial(n - r)

    def decimalFormat(self, nilai):
        return f"{nilai:.2f}"

    @staticmethod
    def inputInteger(pesan, minimum, maksimum=None):
        while True:
            try:
                nilai = int(input(pesan))

                if maksimum is None:
                    if nilai >= minimum:
                        return nilai
                else:
                    if minimum <= nilai <= maksimum:
                        return nilai

                print("input error(): nilai tidak valid")

            except ValueError:
                print("input error(): masukkan angka yang valid")

    def jalankanKombinasi(self):
        print("----------Program penghitung kombinatorik----------")

        n = self.inputInteger("Masukan nilai N: ", 0)
        r = self.inputInteger("Masukan nilai R: ", 0, n)

        print("Hasil:", self.decimalFormat(self.kombinasi(n, r)))

    def jalankanPermutasi(self):
        print("----------Program penghitung permutasi----------")

        n = self.inputInteger("Masukan nilai N: ", 0)
        r = self.inputInteger("Masukan nilai R: ", 0, n)

        print("Hasil:", self.decimalFormat(self.permutasi(n, r)))

    def printKombinasi(self):
        print("Hasil:", self.decimalFormat(self.kombinasi(self.n, self.r)))

    # Mencetak hasil permutasi
    def printPermutasi(self):
        print("Hasil:", self.decimalFormat(self.permutasi(self.n, self.r)))


def main():
    print("OBJECT 1 - Constructor")
    kp1 = KombinasiPermutasi(5, 2)

    print("\nOBJECT 2 - Setter")
    kp2 = KombinasiPermutasi()
    kp2.setN(6)
    kp2.setR(3)

    print("\nOBJECT 3 - Input dari main()")
    kp3 = KombinasiPermutasi()

    kp3.setN(KombinasiPermutasi.inputInteger("Masukan nilai N: ", 0))

    kp3.setR(KombinasiPermutasi.inputInteger("Masukan nilai R: ",0,kp3.getN()))

    print("\nOBJECT 4 - Input dari dalam class")
    kp4 = KombinasiPermutasi()

    while True:
        print("\n---------- MENU ----------")
        print("1. Jalankan Objek 1 - Kombinasi")
        print("2. Jalankan Objek 2 - Permutasi")
        print("3. Jalankan Objek 3 - Kombinasi")
        print("4. Jalankan Objek 4 - Permutasi")
        print("5. Jalankan Semua Objek")
        print("0. Keluar")

        pilihan = input("Pilih menu: ")

        if pilihan == "1":
            kp1.printKombinasi()

        elif pilihan == "2":
            kp2.printPermutasi()

        elif pilihan == "3":
            kp3.printKombinasi()

        elif pilihan == "4":
            kp4.jalankanPermutasi()

        elif pilihan == "5":
            print("\nOBJECT 1")
            kp1.printKombinasi()

            print("\nOBJECT 2")
            kp2.printPermutasi()

            print("\nOBJECT 3")
            kp3.printKombinasi()

            print("\nOBJECT 4")
            kp4.jalankanPermutasi()

        elif pilihan == "0":
            print("Program selesai.")
            break

        else:
            print("Pilihan tidak valid.")


if __name__ == "__main__":
    main()