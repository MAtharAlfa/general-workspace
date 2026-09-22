# Nama Program    : Persegi Luas
# Nama Pembuat    : Muhammad Athar Alfarisi
# NPM             : 140810250005
# Tanggal Buat    : 22/09/2026
# Deskripsi       : Menghitung luas, keliling, dan diagonal persegi panjang 

import math

def inputPersegi():
    panjang = input("Masukkan panjang persegi panjang: ")
    lebar = input("Masukkan lebar persegi panjang: ")

    panjang = float(panjang)
    lebar = float(lebar)
    return (panjang, lebar)


def getLuas(panjang, lebar):
    return (panjang*lebar)

def getKeliling(panjang, lebar):
    return (2*(panjang + lebar))

def getDiagonal(panjang, lebar):
    return math.sqrt(panjang ** 2 + lebar ** 2)

def cetak(panjang, lebar):
    print("Panjang persegi panjang = ", panjang)
    print("Panjang lebar panjang = ", lebar)
    print("Panjang luas panjang = ", getLuas(panjang, lebar))
    print("Panjang keliling panjang = ", getKeliling(panjang, lebar))
    print("Panjang diagonal panjang = ", getDiagonal(panjang, lebar))

def main():
    pjg, lbr = inputPersegi()
    cetak(pjg, lbr)

if __name__ == "__main__":
    main()