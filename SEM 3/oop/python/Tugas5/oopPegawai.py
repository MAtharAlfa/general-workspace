# Nama Program    : Hitung Gaji Total
# Nama Pembuat    : Muhammad Athar Alfarisi
# NPM             : 140810250005
# Tanggal Buat    : 22/09/2026
# Deskripsi       : Program memasukan input nama dan golongan untuk mencari gaji pokok, tunjangan, potongan, dan gaji utama

class Pegawai:
    def __init__(self, nama="", golongan=0):
        self.nama = nama
        self.golongan = golongan

    def setPegawai(self, nama, golongan):
        self.nama = nama
        self.golongan = golongan

    def setNama(self, nama):
        self.nama = nama

    def setGolongan(self, golongan):
        self.golongan = golongan

    def getNama(self):
        return self.nama

    def getGolongan(self):
        return self.golongan

    def hitungGaji(self):
        print("----------Tentukan Gaji Pegawai----------")

        nama = self.inputString("Masukan nama: ")
        golongan = self.inputInteger("Masukan golongan: ", 1, 4)

        self.cetakTabel(nama, golongan)

    def cetakTabel(self, nama=None, golongan=None):
        if nama is None:
            nama = self.nama

        if golongan is None:
            golongan = self.golongan

        headers = [
            "Nama",
            "Golongan",
            "Gaji Pokok",
            "Tunjangan",
            "Potongan",
            "Gaji Total"
        ]

        data = [
            nama,
            str(golongan),
            self.rupiahFormat(self.tentukanGP(golongan)),
            self.rupiahFormat(self.tentukanTunjangan(golongan)),
            self.rupiahFormat(self.tentukanPotongan(golongan)),
            self.rupiahFormat(self.tentukanGT(golongan))
        ]

        self.printTable(headers, data, 6)

    def tentukanGT(self, golongan):
        gajiPokok = self.tentukanGP(golongan)

        return (float(gajiPokok) + self.tentukanTunjangan(golongan) - self.tentukanPotongan(golongan))

    def tentukanTunjangan(self, golongan):
        return (
            self.tentukanGP(golongan)
            * self.tentukanKonstantaTunjangan(golongan)
        )

    def tentukanPotongan(self, golongan):
        return (
            self.tentukanGP(golongan)
            * self.tentukanKonstantaPotongan(golongan)
        )

    def tentukanGP(self, golongan):
        if golongan == 1:
            return 1500000

        if golongan == 2:
            return 2000000

        if golongan == 3:
            return 3000000

        if golongan == 4:
            return 5000000

        else:
            return -1

    def tentukanKonstantaTunjangan(self, golongan):
        if golongan == 1:
            return 0.1

        if golongan == 2 or golongan == 3:
            return 0.12

        if golongan == 4:
            return 0.15

        else:
            return -1.0

    def tentukanKonstantaPotongan(self, golongan):
        if golongan == 1:
            return 0.01

        if golongan == 2 or golongan == 3:
            return 0.02

        if golongan == 4:
            return 0.04

        else:
            return -1.0

    @staticmethod
    def inputString(pesan):
        print(pesan)
        return input()

    @staticmethod
    def inputInteger(pesan, minimum, maksimum):
        while True:
            try:
                inputValue = int(input(pesan))

                if minimum <= inputValue <= maksimum:
                    return inputValue

                print("input error(): nilai tidak valid")

            except ValueError:
                print("input error(): nilai tidak valid")

    @staticmethod
    def rupiahFormat(nilai):
        return f"Rp{nilai:.2f}"

    @staticmethod
    def printTable(headers, data, jumlahKolom):

        # Menentukan lebar setiap kolom
        lebar = []

        for i in range(jumlahKolom):
            lebar.append(
                max(len(headers[i]), len(data[i]))
            )

        # Top border
        print("+", end="")

        for i in range(jumlahKolom):
            print("-" * (lebar[i] + 2), end="")
            print("+", end="")

        print()

        # Headers
        print("|", end="")

        for i in range(jumlahKolom):
            print(
                " "
                + headers[i].ljust(lebar[i])
                + " |",
                end=""
            )

        print()

        # Header separator
        print("+", end="")

        for i in range(jumlahKolom):
            print("-" * (lebar[i] + 2), end="")
            print("+", end="")

        print()

        # Data
        print("|", end="")

        for i in range(jumlahKolom):
            print(
                " "
                + data[i].ljust(lebar[i])
                + " |",
                end=""
            )

        print()

        # Bottom border
        print("+", end="")

        for i in range(jumlahKolom):
            print("-" * (lebar[i] + 2), end="")
            print("+", end="")

        print()


def main():
    print("OBJECT 1 - Constructor")    
    pegawai1 = Pegawai("Ateng", 2)

    print("\nOBJECT 2 - Setter")
    pegawai2 = Pegawai()
    pegawai2.setPegawai("Cicit", 3)

    print("\nOBJECT 3 - Input dari main()")
    pegawai3 = Pegawai()

    print("\nOBJECT 4 - Input dari dalam class")    
    pegawai4 = Pegawai()

    pilihan = 0

    while pilihan != 5:

        print("\n---------- MENU ----------")
        print("1. Jalankan Objek 1")
        print("2. Jalankan Objek 2")
        print("3. Jalankan Objek 3")
        print("4. Jalankan Objek 4")
        print("5. Keluar")

        pilihan = Pegawai.inputInteger("Pilih menu: ", 1, 5)
        print()

        if pilihan == 1:
            pegawai1.cetakTabel()

        elif pilihan == 2:
            pegawai2.cetakTabel()

        elif pilihan == 3:
            pegawai3.setPegawai(
                Pegawai.inputString("Masukan nama: "),
                Pegawai.inputInteger("Masukan golongan: ", 1, 4)
            )

            pegawai3.cetakTabel()

        elif pilihan == 4:
            print("========== OBJEK 4 ==========")
            pegawai4.hitungGaji()

        elif pilihan == 5:
            print("Program selesai.")


if __name__ == "__main__":
    main()
