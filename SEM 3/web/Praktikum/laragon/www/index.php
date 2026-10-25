<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
</head>
<body>
	<?php
		$nama = "Dina";
		$nim = "140810270001";
		$prodi = "Teknik Informatika";
		$nilai = 76;

		function getGrade($nilai) {
			if ($nilai >= 85 && $nilai <= 100) {
				return "A";
			} else if ($nilai >= 75 && $nilai <= 84) {
				return "B";
			} else if ($nilai >= 65 && $nilai <= 74) {
				return "C";
			} else if ($nilai >= 0 && $nilai <= 64) {
				return "D";
			} else {
				return "Nilai di luar range [0,100].";
			}
		}

		function getStatus($nilai) {
			if ($nilai >= 75 && $nilai <= 100) {
				return "Lulus";
			} else if ($nilai >= 0 && $nilai <= 74){
				return "Tidak Lulus";
			} else {
				"Nilai di luar range [0,100].";
			}
		}
	?>	

	<h1>Program Data Mahasiswa PHP</h1>
	<?php 
		echo "<p>Nama: " . $nama . "</p></br>";
		echo "<p>NIM: " . $nim . "</p></br>";
		echo "<p>Prodi: " . $prodi . "</p></br>";
		echo "<p>Nilai: " . $nilai . "</p></br>";
		echo "<p>Grade: " . getGrade($nilai) . "</p></br>";
		echo "<p>Status: " . getStatus($nilai) . "</p></br>";
	?>
</body>
</html>

