<?php
const BOBOT_TUGAS = 0.2; //compile time const
const BOBOT_UTS = 0.3;
const BOBOT_UAS = 0.5;

function calculate_nilai_akhir(float $nilai_tugas, float $nilai_uts, float $nilai_uas) {
    return $nilai_tugas*BOBOT_TUGAS + $nilai_uts*BOBOT_UTS + $nilai_uas*BOBOT_UAS;
  } 

function get_nilai_akhir($nilai_tugas, $nilai_uts, $nilai_uas) {
  return calculate_nilai_akhir($nilai_tugas, $nilai_uts, $nilai_uas);
}

function get_predikat_nilai($nilai_akhir) {
  if ($nilai_akhir <= 100 && $nilai_akhir >= 80) {
    return 'A';
  } else if ($nilai_akhir <= 79 && $nilai_akhir >= 68) {
    return 'B';
  } else if ($nilai_akhir <= 67 && $nilai_akhir >= 56) {
    return 'C';
  } else if ($nilai_akhir <= 55 && $nilai_akhir >= 45) {
    return 'D';
  } else if ($nilai_akhir <= 44 && $nilai_akhir >= 0) {
    return 'E';
  } else {
    return "error get_predikat_nilai(): nilai di luar range 0-100";
  }
}
?>

<?php
$array_mahasiswa = [
  ["Arnold Schwazianeger", "250001", 97, 67, 87],
  ["Friedrich Nietzsche", "250002", 87, 87, 65],
  ["大学行きたくない", "250003", 67, 67, 67]
];
?>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Nilai Mahasiswa</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@6.0.0-alpha.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-B/GM4XqrwHnWXNOWMbloTmrYXZg10cakYGmpfsR/bbzQ6JAJI4ihuyADKLnBgrCe" crossorigin="anonymous">
</head>
<body>
  <p class="h1 text-center p-5 m-10">Array Mahasiswa</p>
  <div style="width:80%;" class="mx-auto">
    <table class="table p-10">
      <thead>
        <tr>
          <th scope="col">NAMA</th>
          <th scope="col">NIM</th>
          <th scope="col">NILAI TUGAS</th>
          <th scope="col">NILAI UTS</th>
          <th scope="col">NILAI UAS</th>
          <th scope="col">NILAI AKHIR</th>
          <th scope="col">PREDIKAT</th>
        </tr>
      </thead>
      <tbody>
        <?php foreach ($array_mahasiswa as $mahasiswa): ?>
          <tr>
            <?php for($i = 0, $mahasiswa_end = count($mahasiswa), $range = count($mahasiswa)+2; $i < $range; $i++): ?>
              <?php $nilai_akhir = get_nilai_akhir($mahasiswa[2], $mahasiswa[3], $mahasiswa[4]) ?>
              <td>
                <!-- isset() untuk cek apakah elemen array ada atau tidak -->
                <?php if (isset($mahasiswa[$i])): ?> 
                    <?= htmlspecialchars($mahasiswa[$i], ENT_QUOTES, "UTF-8") ?>
                  <?php else: ?>
                    <?php if ($i === $mahasiswa_end): echo $nilai_akhir ?>
                    <?php else: echo get_predikat_nilai($nilai_akhir) ?>
                    <?php endif ?>
                <?php endif ?>
              </td>
            <?php endfor ?>
          </tr>
        <?php endforeach ?>
      </tbody>
    </table>
  </div>
</body>
</html>