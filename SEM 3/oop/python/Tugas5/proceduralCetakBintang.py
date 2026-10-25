# Nama Program    : Program Pencetak Bintang
# Nama Pembuat    : Muhammad Athar Alfarisi
# NPM             : 140810250005
# Tanggal Buat    : 22/09/2026
# Deskripsi       : Program memasukan input n untuk membuat pola selebar input n

def cetakBintangPola1(lebarKolom):
    goLeft = False
    helper = 0

    for i in range(lebarKolom + (lebarKolom - 1)):
        for j in range(lebarKolom):
            if j <= helper:
                print("*", end="")
            else:
                print(" ", end="")

        if helper == lebarKolom - 1:
            goLeft = True

        if goLeft == False:
            helper += 1
        else:
            helper -= 1

        print()


def cetakBintangPola1While(lebarKolom):
    goLeft = False
    helper = 0
    i = 0

    while i < lebarKolom + (lebarKolom - 1):
        for j in range(lebarKolom):
            if j <= helper:
                print("*", end="")
            else:
                print(" ", end="")

        if helper == lebarKolom - 1:
            goLeft = True

        if goLeft == False:
            helper += 1
        else:
            helper -= 1

        print()
        i += 1


def cetakBintangPola2(lebarKolom):
    goRight = False
    helper = lebarKolom - 1

    for i in range(lebarKolom + (lebarKolom - 1)):
        for j in range(lebarKolom):
            if j <= helper:
                print("*", end="")
            else:
                print(" ", end="")

        if helper == 0:
            goRight = True

        if goRight == False:
            helper -= 1
        else:
            helper += 1

        print()


def cetakBintangPola2While(lebarKolom):
    goRight = False
    helper = lebarKolom - 1
    i = 0

    while i < lebarKolom + (lebarKolom - 1):
        for j in range(lebarKolom):
            if j <= helper:
                print("*", end="")
            else:
                print(" ", end="")

        if helper == 0:
            goRight = True

        if goRight == False:
            helper -= 1
        else:
            helper += 1

        print()
        i += 1


def cetakPola(lebarKolom):
    print("\nSegitiga: ")
    cetakBintangPola1(lebarKolom)

    print("Segitiga (pakai while): ")
    cetakBintangPola1While(lebarKolom)

    print("Pola Dua")
    cetakBintangPola2(lebarKolom)

    print("Pola Dua (pakai while):")
    cetakBintangPola2While(lebarKolom)


def inputInteger(pesan, minimum):
    while True:
        try:
            inputNilai = int(input(pesan))

            if inputNilai >= minimum:
                return inputNilai

            print("input error(): nilai tidak valid")

        except ValueError:
            print("input error(): masukkan angka yang valid")


def main():
    cetakBintangPola1(4)
    print()
    cetakBintangPola1While(5)
    print()
    cetakBintangPola2(6)
    print()
    cetakBintangPola2While(7)


if __name__ == "__main__":
    main()
