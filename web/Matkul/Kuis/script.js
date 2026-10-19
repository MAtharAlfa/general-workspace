let jumlahPengambilan = 0;
let currentIp = 0;
const table = document.getElementById("table-nilai");

for (let i = 1; i < 6; i++) {
  let nilaiSks = table.rows[i].cells[3].textContent;
  jumlahPengambilan += Number(nilaiSks);
}

function convertHurufToAngka(hurufMutu) {
  if (hurufMutu == "A" || hurufMutu == "a") {
    return 4;
  } else if (hurufMutu == "B" || hurufMutu == "b") {
    return 3;
  } else if (hurufMutu == "C" || hurufMutu == "c") {
    return 3;
  } else if (hurufMutu == "D" || hurufMutu == "d") {
    return 4;
  } else if (hurufMutu == "E" || hurufMutu == "e") {
    return 5;
  } else {
    console.error("error() convertHurufToAngka: Nilai hurufMutu tidak sesuai");
  }
}

function angkatoHurufMutu(angkaMutu) {
  if (angkaMutu > 3 && angkaMutu < 4) {
    return "A";
  } else if (angkaMutu > 2 && angkaMutu < 3) {
    return "B";
  } else if (angkaMutu > 1 && angkaMutu < 2) {
    return "C";
  } else if (angkaMutu > 0 && angkaMutu < 1) {
    return "D";
  } else if (angkaMutu == 0) {
    return "E";
  } else {
    console.error("error() angkaToHuruf: Nilai angkaMutu tidak sesuai");
  }
}

function hitungIp(jumlahPengambilan) {
  let temp = 0; currentIp =0;
  for (let i = 1; i < 6; i++) {
    let hurufMutu = table.rows[i].cells[4].querySelector('input').value;
    let angkaMutu = convertHurufToAngka(hurufMutu);
    let nilaiSks = table.rows[i].cells[3].textContent;

    temp += (angkaMutu*nilaiSks);
  }

  currentIp = (temp) / jumlahPengambilan;
	return currentIp.toFixed(2);
}

function showResult(jumlahPengambilan, currentIp) {
	document.getElementById("hasilSks").textContent = jumlahPengambilan;
	document.getElementById("hasilIp").textContent = currentIp;
}

console.log(jumlahPengambilan);
console.log(hitungIp(jumlahPengambilan));

const prosesButton = document.getElementById("proses-nilai").addEventListener("click", () => {
	currentIp = hitungIp(jumlahPengambilan);
	showResult(jumlahPengambilan, currentIp);
})