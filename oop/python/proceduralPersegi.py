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
    return math.sqrt(pow(panjang, 2) + pow(lebar, 2))

def cetak(panjang, lebar):
    print("Panjang persegi panjang = ", panjang)
    print("Panjang persegi panjang = ", lebar)
    print("Panjang persegi panjang = ", getLuas(panjang, lebar))
    print("Panjang persegi panjang = ", getKeliling(panjang, lebar))
    print("Panjang persegi panjang = ", getDiagonal(panjang, lebar))

def main():
    pjg, lbr = inputPersegi()
    cetak(pjg, lbr)

if __name__ == "__main__":
    main()