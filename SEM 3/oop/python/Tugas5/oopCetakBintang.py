# Nama Program    : Program Pencetak Bintang
# Nama Pembuat    : Muhammad Athar Alfarisi
# NPM             : 140810250005
# Tanggal Buat    : 22/09/2026
# Deskripsi       : Program memasukan input n untuk membuat pola selebar input n

class CetakBintang:
    def __init__(self, lebarKolom=0):
        self.lebarKolom = lebarKolom

    def setLebarKolom(self, lebarKolom):
        self.lebarKolom = lebarKolom

    def getLebarKolom(self):
        return self.lebarKolom

    def inputData(self):
        self.lebarKolom = self.inputInteger(
            "Masukan lebar kolom (minimal 1): ",
            1
        )

    # Pola 1 menggunakan for
    def cetakBintangPola1(self):
        goLeft = False
        helper = 0

        for i in range(self.lebarKolom + (self.lebarKolom - 1)):
            for j in range(self.lebarKolom):
                if j <= helper:
                    print("*", end="")
                else:
                    print(" ", end="")

            if helper == self.lebarKolom - 1:
                goLeft = True

            if not goLeft:
                helper += 1
            else:
                helper -= 1

            print()

    # Pola 1 menggunakan while
    def cetakBintangPola1While(self):
        goLeft = False
        helper = 0
        i = 0

        while i < self.lebarKolom + (self.lebarKolom - 1):
            for j in range(self.lebarKolom):
                if j <= helper:
                    print("*", end="")
                else:
                    print(" ", end="")

            if helper == self.lebarKolom - 1:
                goLeft = True

            if not goLeft:
                helper += 1
            else:
                helper -= 1

            print()
            i += 1

    # Pola 2 menggunakan for
    def cetakBintangPola2(self):
        goRight = False
        helper = self.lebarKolom - 1

        for i in range(self.lebarKolom + (self.lebarKolom - 1)):
            for j in range(self.lebarKolom):
                if j <= helper:
                    print("*", end="")
                else:
                    print(" ", end="")

            if helper == 0:
                goRight = True

            if not goRight:
                helper -= 1
            else:
                helper += 1

            print()

    # Pola 2 menggunakan while
    def cetakBintangPola2While(self):
        goRight = False
        helper = self.lebarKolom - 1
        i = 0

        while i < self.lebarKolom + (self.lebarKolom - 1):
            for j in range(self.lebarKolom):
                if j <= helper:
                    print("*", end="")
                else:
                    print(" ", end="")

            if helper == 0:
                goRight = True

            if not goRight:
                helper -= 1
            else:
                helper += 1

            print()
            i += 1

    def cetakPola(self):
        print("\nSegitiga: ")
        self.cetakBintangPola1()

        print("Segitiga (pakai while): ")
        self.cetakBintangPola1While()

        print("Pola Dua")
        self.cetakBintangPola2()

        print("Pola Dua (pakai while):")
        self.cetakBintangPola2While()

    def jalankanProgramPencetakPola(self):
        self.inputData()
        self.cetakPola()

    @staticmethod
    def inputInteger(pesan, minimum=None):
        while True:
            try:
                nilai = int(input(pesan))

                if minimum is None or nilai >= minimum:
                    return nilai

                print("input error(): nilai tidak valid")

            except ValueError:
                print("input error(): masukkan angka yang valid")


def main():
    print("OBJECT 1 - Constructor")
    cb1 = CetakBintang(5)

    print("\nOBJECT 2 - Setter")
    cb2 = CetakBintang()
    cb2.setLebarKolom(7)

    print("\nOBJECT 3 - Input dari main()")
    cb3 = CetakBintang()
    cb3.setLebarKolom(
        CetakBintang.inputInteger(
            "Masukan lebar kolom (minimal 1): ",
            1
        )
    )

    print("\nOBJECT 4 - Input dari dalam class")
    cb4 = CetakBintang()
    cb4.inputData()

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
            cb1.cetakPola()

        elif pilihan == "2":
            cb2.cetakPola()

        elif pilihan == "3":
            cb3.cetakPola()

        elif pilihan == "4":
            cb4.cetakPola()

        elif pilihan == "5":
            cb1.cetakPola()
            cb2.cetakPola()
            cb3.cetakPola()
            cb4.cetakPola()

        elif pilihan == "0":
            print("Program selesai.")
            break

        else:
            print("Pilihan tidak valid.")


if __name__ == "__main__":
    main()
