# Nama Program    : Program Pemeriksa Biner
# Nama Pembuat    : Muhammad Athar Alfarisi
# NPM             : 140810250005
# Tanggal Buat    : 22/09/2026
# Deskripsi       : Program memeriksa biner antara dua nilai dan operasi-operasinya

class BitOperations:
# Constructor with parameters
    def __init__(self, A=0, B=0):
        self.A = A
        self.B = B

    # Setter
    def setA(self, a):
        self.A = a

    def setB(self, b):
        self.B = b

    # Getter
    def getA(self):
        return self.A

    def getB(self):
        return self.B

    # Convert integer to binary
    def printIntegerToBinary(self, nilai):
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

    # Convert integer to octal
    def printIntegerToOctal(self, nilai):
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

    # Convert integer to hexadecimal
    def printIntegerToHex(self, nilai):
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

    # Print all results
    def cetakHasil(self):
        print("Nilai biner", self.A)
        print("Biner: ", end="")
        self.printIntegerToBinary(self.A)

        print("Hex: ", end="")
        self.printIntegerToHex(self.A)

        print("Octal: ", end="")
        self.printIntegerToOctal(self.A)

        print()

        print("Nilai biner", self.B)
        print("Biner: ", end="")
        self.printIntegerToBinary(self.B)

        print("Hex: ", end="")
        self.printIntegerToHex(self.B)

        print("Octal: ", end="")
        self.printIntegerToOctal(self.B)

        print()

        # AND
        hasil = self.A & self.B

        print("Hasil Operasi Biner",
            self.A,
            "AND",
            self.B
        )

        print("Desimal:", hasil)

        print("Biner: ", end="")
        self.printIntegerToBinary(hasil)

        print("Hex: ", end="")
        self.printIntegerToHex(hasil)

        print("Octal: ", end="")
        self.printIntegerToOctal(hasil)

        print()

        # OR
        hasil = self.A | self.B

        print(
            "Hasil Operasi Biner",
            self.A,
            "OR",
            self.B
        )

        print("Desimal:", hasil)

        print("Biner: ", end="")
        self.printIntegerToBinary(hasil)

        print("Hex: ", end="")
        self.printIntegerToHex(hasil)

        print("Octal: ", end="")
        self.printIntegerToOctal(hasil)

        print()

        # XOR
        hasil = self.A ^ self.B

        print(
            "Hasil Operasi Biner",
            self.A,
            "XOR",
            self.B
        )

        print("Desimal:", hasil)

        print("Biner: ", end="")
        self.printIntegerToBinary(hasil)

        print("Hex: ", end="")
        self.printIntegerToHex(hasil)

        print("Octal: ", end="")
        self.printIntegerToOctal(hasil)

        print()

        # Left shift
        hasil = self.A << 2

        print(
            "Hasil Operasi Biner left shift",
            self.A,
            "sebanyak 2:"
        )

        print("Desimal:", hasil)

        print("Biner: ", end="")
        self.printIntegerToBinary(hasil)

        print("Hex: ", end="")
        self.printIntegerToHex(hasil)

        print("Octal: ", end="")
        self.printIntegerToOctal(hasil)

        print()

        # Right shift
        hasil = self.B >> 1

        print(
            "Hasil Operasi Biner right shift",
            self.B,
            "sebanyak 1:"
        )

        print("Desimal:", hasil)

        print("Biner: ", end="")
        self.printIntegerToBinary(hasil)

        print("Hex: ", end="")
        self.printIntegerToHex(hasil)

        print("Octal: ", end="")
        self.printIntegerToOctal(hasil)

    # Input from inside class
    def inputBitOperations(self):
        self.A = int(input("Masukan integer: "))
        self.B = int(input("Masukan integer: "))


def main():
    print("OBJECT 1 - Constructor")
    bit1 = BitOperations(10, 5)

    print("\nOBJECT 2 - Setter")
    bit2 = BitOperations()
    bit2.setA(20)
    bit2.setB(8)

    print("\nOBJECT 3 - Input dari main()")
    bit3 = BitOperations()

    bit3.setA(int(input("Masukan integer A: ")))
    bit3.setB(int(input("Masukan integer B: ")))

    print("\nOBJECT 4 - Input dari dalam class")
    bit4 = BitOperations()
    bit4.inputBitOperations()

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
            bit1.cetakHasil()

        elif pilihan == "2":
            bit2.cetakHasil()

        elif pilihan == "3":
            bit3.cetakHasil()

        elif pilihan == "4":
            bit4.cetakHasil()

        elif pilihan == "5":
            print("\nOBJECT 1")
            bit1.cetakHasil()

            print("\nOBJECT 2")
            bit2.cetakHasil()

            print("\nOBJECT 3")
            bit3.cetakHasil()

            print("\nOBJECT 4")
            bit4.cetakHasil()

        elif pilihan == "0":
            print("Program selesai.")
            break

        else:
            print("Pilihan tidak valid.")


if __name__ == "__main__":
    main()