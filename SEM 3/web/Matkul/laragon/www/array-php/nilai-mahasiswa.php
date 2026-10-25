<?php
class Mahasiswa {
  public string $nama;
  public string $nim;
  public float $nilai_tugas;
  public float $nilai_uts;
  public float $nilai_uas;

  const BOBOT_TUGAS = 0.2; //compile time const
  const BOBOT_UTS = 0.3;
  const BOBOT_UAS = 0.5;

  public function __construct(string $nama = '', string $nim = '', 
  float $nilai_tugas = 0.0, float $nilai_uts = 0.0, float $nilai_uas = 0.0) {
    $this->nama = $nama;
    $this->nim = $nim;
    $this->nilai_tugas = $nilai_tugas;
    $this->nilai_uts = $nilai_uts;
    $this->nilai_uas = $nilai_uas;
  }

  static public function calculate_nilai_akhir(float $nilai_tugas, float $nilai_uts, float $nilai_uas) {
    return $nilai_tugas*self::BOBOT_TUGAS + $nilai_uts*self::BOBOT_UTS + $nilai_uas*self::BOBOT_UAS;
  } 

  public function get_nilai_akhir() {
    return self::calculate_nilai_akhir($this->nilai_tugas, $this->nilai_uts, $this->nilai_uas);
  }

  public function get_predikat_nilai() {
    $nilai_akhir = $this->get_nilai_akhir();

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
}
?>

<?php
$array_mahasiswa = [
  new Mahasiswa("Arnold Schwazianeger", "250001", 97, 67, 87),
  new Mahasiswa("Friedrich Nietzsche", "250002", 87, 97, 65),
  new Mahasiswa("大学行きたくない", "250002", 67, 67, 67),
  new Mahasiswa("Rafflesia Arnoldi", "250003", 86, 54, 43),
  new Mahasiswa("Indit Kulyah", "250003", 8, 5, 3),
  new Mahasiswa("Khaled Meshaal Ahmadinejad Mujaddid Thariq Mardova Fadhillah", "250056", 100, 100, 100)
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
  <div>

  </div>
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
          <td><?php echo $mahasiswa->nama ?></td>
          <td><?php echo $mahasiswa->nim ?></td>
          <td><?php echo $mahasiswa->nilai_tugas ?></td>
          <td><?php echo $mahasiswa->nilai_uts ?></td>
          <td><?php echo $mahasiswa->nilai_uas ?></td>
          <td><?php echo $mahasiswa->get_nilai_akhir() ?></td>
          <td><?php echo $mahasiswa->get_predikat_nilai() ?></td>
        </tr>
      <?php endforeach ?>
    </tbody>
  </table>
  </div>
</body>
</html>