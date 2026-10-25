# Nama Program    : Hitung Gaji Total
# Nama Pembuat    : Muhammad Athar Alfarisi
# NPM             : 140810250005
# Tanggal Buat    : 22/09/2026
# Deskripsi       : Program memasukan input nama dan golongan untuk mencari gaji pokok, tunjangan, potongan, dan gaji utama

def hitungGaji():
    print("----------Tentukan Gaji Pegawai----------")

    nama = inputString("Masukan nama: ")
    golongan = inputInteger("Masukan golongan: ", 1, 4)

    cetakTabel(nama, golongan)


def cetakTabel(nama, golongan):
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
        rupiahFormat(tentukanGP(golongan)),
        rupiahFormat(tentukanTunjangan(golongan)),
        rupiahFormat(tentukanPotongan(golongan)),
        rupiahFormat(tentukanGT(golongan))
    ]

    printTable(headers, data, 6)


def tentukanGT(golongan):
    gajiPokok = tentukanGP(golongan)

    return (
        float(gajiPokok)
        + tentukanTunjangan(golongan)
        - tentukanPotongan(golongan)
    )


def tentukanTunjangan(golongan):
    return (
        tentukanGP(golongan)
        * tentukanKonstantaTunjangan(golongan)
    )


def tentukanPotongan(golongan):
    return (
        tentukanGP(golongan)
        * tentukanKonstantaPotongan(golongan)
    )


def tentukanGP(golongan):
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


def tentukanKonstantaTunjangan(golongan):
    if golongan == 1:
        return 0.1

    if golongan == 2 or golongan == 3:
        return 0.12

    if golongan == 4:
        return 0.15

    else:
        return -1.0


def tentukanKonstantaPotongan(golongan):
    if golongan == 1:
        return 0.01

    if golongan == 2 or golongan == 3:
        return 0.02

    if golongan == 4:
        return 0.04

    else:
        return -1.0


def inputString(pesan):
    print(pesan)
    return input()


def inputInteger(pesan, minimum, maksimum):
    while True:
        try:
            inputValue = int(input(pesan))

            if minimum <= inputValue <= maksimum:
                return inputValue

            print("input error(): nilai tidak valid")

        except ValueError:
            print("input error(): nilai tidak valid")


def rupiahFormat(nilai):
    return f"Rp{nilai:.2f}"


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
    cetakTabel("Nana", 1)


if __name__ == "__main__":
    main()
