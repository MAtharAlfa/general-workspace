//pake docs biar gak compiler error, walaupun sebenarnya masih bisa run

class Barang {
  /** @type {Barang[]} */
  static arrayBarang = [];
  /** @type {string[]} */
  static arrayNamaBarang = [];
  /** @type {string} */
  #nama;

  /** @type {number} */
  #jumlah;

  /**
   * Creates an instance of Barang.
   *
   * @constructor
   * @param {string} nama
   * @param {number} jumlah
   */
  constructor(nama, jumlah) {
    const index = Barang.arrayNamaBarang.indexOf(nama);

    if (index !== -1) {
      Barang.arrayBarang[index].#jumlah += jumlah;
    } else {
      this.#nama = nama;
      this.#jumlah = jumlah;

      Barang.arrayBarang.push(this);
      Barang.arrayNamaBarang.push(this.getNama());
    }
  }

  /**
   * set Nama
   *
   * @param {string} nama
   */
  setNama(nama) {
    this.#nama = nama;
  }

  /**
   * set jumlah
   *
   * @param {number} jumlah
   */
  setjumlah(jumlah) {
    this.#jumlah = jumlah;
  }

  getNama() {
    return this.#nama;
  }

  getjumlah() {
    return this.#jumlah;
  }

  getjumlahToStatus() {
    if (this.#jumlah >= 50) {
      return "Aman";
    } else if (this.#jumlah >= 10 && this.#jumlah <= 49) {
      return "Menipis";
    } else if (this.#jumlah > 0 && this.#jumlah < 10) {
      return "Kritis";
    } else if (this.#jumlah == 0) {
      return "Habis";
    } else {
      console.error("error: getjumlahToStatus() jumlah outside valid range");
      return "ERROR";
    }
  }

  /**
   *
   * @param {string} namaBarang
   */
  static findBarang(namaBarang) {
    Barang.arrayBarang.forEach((element) => {
      if (element.getNama() == namaBarang) {
        return element;
      }
    });

    return null;
  }

  static appendTable() {
    const tableBody = document
      .getElementById("mainTable")
      .getElementsByTagName("tbody")[0];

    tableBody.innerHTML = "";

    Barang.arrayBarang.forEach((element) => {
      const newRow = tableBody.insertRow(-1);

      const cell0 = newRow.insertCell(0);
      const cell1 = newRow.insertCell(1);
      const cell2 = newRow.insertCell(2);

      const status = element.getjumlahToStatus();

      cell0.textContent = element.getNama();
      cell1.textContent = String(element.getjumlah());
      cell2.textContent = status;

      const normalizedStatus = status.trim().toLowerCase();

      if (normalizedStatus === "aman") {
        newRow.style.backgroundColor = "green";
        newRow.style.color = "white";
      } else if (normalizedStatus === "menipis") {
        newRow.style.backgroundColor = "yellow";
      } else if (normalizedStatus === "kritis") {
        newRow.style.backgroundColor = "red";
        newRow.style.color = "white";
      } else {
        newRow.style.backgroundColor = "gray";
      }
    });
  }

  static resetTable() {
    const tableBody = document
      .getElementById("mainTable")
      .getElementsByTagName("tbody")[0];

    tableBody.innerHTML = "";

    const newRow = tableBody.insertRow(-1);
    const cell0 = newRow.insertCell(0);
    const cell1 = newRow.insertCell(1);
    const cell2 = newRow.insertCell(2);

    cell0.textContent = "-";
    cell1.textContent = "-";
    cell2.textContent = "-";

    Barang.arrayBarang.length = 0;
    Barang.arrayNamaBarang.length = 0;
  }

  /**
   *
   * @param {Barang} mahasiswa
   */
}

const inputName = document.getElementById("name");
const inputjumlah = document.getElementById("jumlah");
const processButton = document
  .getElementById("submit")
  .addEventListener("click", () => {
    inputString = inputName.value;
    if (inputString === "") {
      alert("Nama perlu diisi");
      return;
    }
    inputNumber = inputjumlah.valueAsNumber;
    if (!inputjumlah.value || isNaN(inputNumber)) {
      alert("jumlah perlu diisi sebuah angka dalam rentang 0-100");
      return;
    } else if (inputNumber < 0) {
      alert("jumlah perlu diisi sebuah angka lebih sama dengan 0");
      return;
    }

    mhs = new Barang(inputString, inputjumlah.valueAsNumber);

    Barang.appendTable();
  });

const resetTable = document
  .querySelector("#resetTable")
  .addEventListener("click", Barang.resetTable);
