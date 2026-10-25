# Nama Program    : Program Pemeriksa Biner
# Nama Pembuat    : Muhammad Athar Alfarisi
# NPM             : 140810250005
# Tanggal Buat    : 22/09/2026
# Deskripsi       : Program memeriksa biner antara dua nilai dan operasi-operasinya

def printIntegerToBinary(nilai):
    hasil = ""

    while True:
        temp = nilai % 2
        hasil += str(temp)
        nilai //= 2

        if nilai <= 0:
            break

    reversed_hasil = ""

    for i in range(len(hasil) - 1, -1, -1):
        reversed_hasil += hasil[i]

    while len(reversed_hasil) < 8:
        reversed_hasil = "0" + reversed_hasil

    print("0b" + reversed_hasil)


def printIntegerToOctal(nilai):
    hasil = ""

    while True:
        temp = nilai % 8
        hasil += str(temp)
        nilai //= 8

        if nilai <= 0:
            break

    reversed_hasil = ""

    for i in range(len(hasil) - 1, -1, -1):
        reversed_hasil += hasil[i]

    print("0o" + reversed_hasil)


def printIntegerToHex(nilai):
    hasil = ""

    while True:
        temp = nilai % 16

        if temp < 10:
            hasil += str(temp)
        else:
            if temp == 10:
                hasil += "A"
            elif temp == 11:
                hasil += "B"
            elif temp == 12:
                hasil += "C"
            elif temp == 13:
                hasil += "D"
            elif temp == 14:
                hasil += "E"
            elif temp == 15:
                hasil += "F"

        nilai //= 16

        if nilai <= 0:
            break

    reversed_hasil = ""

    for i in range(len(hasil) - 1, -1, -1):
        reversed_hasil += hasil[i]

    print("0x" + reversed_hasil)


def cetakHasil(A, B):
    print("Nilai biner", A)
    print("Biner: ", end="")
    printIntegerToBinary(A)

    print("Hex: ", end="")
    printIntegerToHex(A)

    print("Octal: ", end="")
    printIntegerToOctal(A)

    print()

    print("Nilai biner", B)
    print("Biner: ", end="")
    printIntegerToBinary(B)

    print("Hex: ", end="")
    printIntegerToHex(B)

    print("Octal: ", end="")
    printIntegerToOctal(B)

    print()

    # AND
    hasil = A & B

    print("Hasil Operasi Biner", A, "AND", B)
    print("Desimal:", hasil)

    print("Biner: ", end="")
    printIntegerToBinary(hasil)

    print("Hex: ", end="")
    printIntegerToHex(hasil)

    print("Octal: ", end="")
    printIntegerToOctal(hasil)

    print()

    # OR
    hasil = A | B

    print("Hasil Operasi Biner", A, "OR", B)
    print("Desimal:", hasil)

    print("Biner: ", end="")
    printIntegerToBinary(hasil)

    print("Hex: ", end="")
    printIntegerToHex(hasil)

    print("Octal: ", end="")
    printIntegerToOctal(hasil)

    print()

    # XOR
    hasil = A ^ B

    print("Hasil Operasi Biner", A, "XOR", B)
    print("Desimal:", hasil)

    print("Biner: ", end="")
    printIntegerToBinary(hasil)

    print("Hex: ", end="")
    printIntegerToHex(hasil)

    print("Octal: ", end="")
    printIntegerToOctal(hasil)

    print()

    # Left shift
    hasil = A << 2

    print("Hasil Operasi Biner left shift", A, "sebanyak 2:")
    print("Desimal:", hasil)

    print("Biner: ", end="")
    printIntegerToBinary(hasil)

    print("Hex: ", end="")
    printIntegerToHex(hasil)

    print("Octal: ", end="")
    printIntegerToOctal(hasil)

    print()

    # Right shift
    hasil = B >> 1

    print("Hasil Operasi Biner right shift", B, "sebanyak 1:")
    print("Desimal:", hasil)

    print("Biner: ", end="")
    printIntegerToBinary(hasil)

    print("Hex: ", end="")
    printIntegerToHex(hasil)

    print("Octal: ", end="")
    printIntegerToOctal(hasil)


def inputBitOperations():
    A = int(input("Masukan integer: "))
    B = int(input("Masukan integer: "))

    return A, B


def main():
    cetakHasil(19, 53)
    
if __name__ == "__main__":
    main()