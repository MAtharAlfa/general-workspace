<?php
require_once __DIR__ . "/koneksi.php";

$pesan = "";

if ($_SERVER["REQUEST_METHOD"] === "POST") {
    $nim = trim($_POST["nim"] ?? "");
    $nama = trim($_POST["nama"] ?? "");
    $prodi = trim($_POST["prodi"] ?? "");
    $semester = filter_input(
        INPUT_POST,
        "semester",
        FILTER_VALIDATE_INT
    );

    if (
        $nim === "" ||
        $nama === "" ||
        $prodi === "" ||
        $semester === false ||
        $semester === null ||
        $semester < 1 ||
        $semester > 14
    ) {
        $pesan = "error tambah.php: Invalid input.";
    } else {
        $stmt = $conn->prepare(
            "INSERT INTO mahasiswa
            (nim, nama, prodi, semester)
            VALUES (?, ?, ?, ?)"
        );

        $stmt->bind_param(
            "sssi",
            $nim,
            $nama,
            $prodi,
            $semester
        );

        try {
            if ($stmt->execute()) {
                header("Location: index.php");
                exit;
            }
        } catch (mysqli_sql_exception $e) {
            if ($e->getCode() === 1062) {
                $pesan = "error tambah.php: NIM already exists.";
            } else {
                $pesan = "error tambah.php: Unknown error.";
            }

            $stmt->close();
        }
    }
}
?>

<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Tambah Mahasiswa</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@6.0.0-alpha.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-B/GM4XqrwHnWXNOWMbloTmrYXZg10cakYGmpfsR/bbzQ6JAJI4ihuyADKLnBgrCe" crossorigin="anonymous">
</head>
<body>

    <h2 class="text-center p-4 m-4">Tambah Mahasiswa</h2>

    <p class="text-center p-4 m-8"><?= htmlspecialchars($pesan) ?></p>

    <form method="POST" class="mx-auto" style="width: 75vw">
        <label class="form-label">NIM:</label>
        <input type="text" class="form-control" name="nim" required maxlength="15">
        <br>

        <label class="form-label">Nama:</label>
        <input type="text" class="form-control" name="nama" required maxlength="100">
        <br>

        <label class="form-label">Program Studi:</label>
        <input type="text" class="form-control" name="prodi" required maxlength="100">
        <br>

        <label class="form-label">Semester:</label>
        <input type="number" class="form-control" name="semester" min="1" max="14" required>
        <br>

        <div class="d-flex flex-row justify-content-around p-4 m-4">
            <button class="btn-subtle theme-success" type="submit">Tambah Data</button>
            <a href="index.php">Kembali</a>
        </div>
    </form>
</body>
</html>