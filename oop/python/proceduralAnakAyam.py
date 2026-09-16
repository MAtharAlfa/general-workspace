def inputAnakAyam():
    jumlahAnakAyam = input("Masukkan jumlah anak ayam: ")

    jumlahAnakAyam = int(jumlahAnakAyam)
    return (jumlahAnakAyam)

def jalankanAnakAyam(jumlahAnakAyam):
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
    jalankanAnakAyam(jumlahAnakAyam)

if __name__ == "__main__":
    main()
