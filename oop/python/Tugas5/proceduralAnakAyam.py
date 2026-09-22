# Nama Program    : Anak Ayam
# Nama Pembuat    : Muhammad Athar Alfarisi
# NPM             : 140810250005
# Tanggal Buat    : 22/09/2026
# Deskripsi       : Penggunaan konsep perulangan dalam java menggunakan anak ayam 

def inputAnakAyam():
    jumlahAnakAyam = input("Masukkan jumlah anak ayam: ")

    jumlahAnakAyam = int(jumlahAnakAyam)
    return (jumlahAnakAyam)

def jalankanLagu(jumlahAnakAyam):
    while jumlahAnakAyam > 0:
        print("Anak ayam turunlah", jumlahAnakAyam)
        jumlahAnakAyam -= 1
        if (jumlahAnakAyam > 0):
            print("Mati satu tinggallah", jumlahAnakAyam)
        else:
            print("Tinggal induknya")
            jumlahAnakAyam -= 1


def main():
    jumlahAnakAyam = inputAnakAyam()
    print(jumlahAnakAyam)
    jalankanLagu(jumlahAnakAyam)

if __name__ == "__main__":
    main()
