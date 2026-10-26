<?php
require_once __DIR__ . "/koneksi.php";

$id = filter_input(INPUT_GET, "id", FILTER_VALIDATE_INT);

if (!$id || $id < 1) {
    exit("error edit.php: Invalid id.");
}

$stmt = $conn->prepare(
    "SELECT nim, nama, prodi, semester
     FROM mahasiswa
     WHERE id = ?"
);
$stmt->bind_param("i", $id);
$stmt->execute();

$data = $stmt->get_result()->fetch_assoc();
$stmt->close();

if (!$data) {
    exit("error edit.php: Data with id " . $id . " not found.");
}

$pesan = "";

if ($_SERVER["REQUEST_METHOD"] === "POST") {
    $nama = trim($_POST["nama"] ?? "");
    $prodi = trim($_POST["prodi"] ?? "");
    $semester = filter_input(
        INPUT_POST,
        "semester",
        FILTER_VALIDATE_INT
    );

    if (
        $nama === "" ||
        $prodi === "" ||
        $semester === false ||
        $semester === null ||
        $semester < 1 ||
        $semester > 14
    ) {
        $pesan = "error edit.php: Invalid data.";
    } else {
        $stmt = $conn->prepare(
            "UPDATE mahasiswa
             SET nama = ?, prodi = ?, semester = ?
             WHERE id = ?"
        );

        $stmt->bind_param(
            "ssii",
            $nama,
            $prodi,
            $semester,
            $id
        );

        if ($stmt->execute()) {
            header("Location: index.php");
            exit;
        }

        $pesan = "error edit.php: Failed to update data.";
        $stmt->close();
    }
}
?>

<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Edit Mahasiswa</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@6.0.0-alpha.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-B/GM4XqrwHnWXNOWMbloTmrYXZg10cakYGmpfsR/bbzQ6JAJI4ihuyADKLnBgrCe" crossorigin="anonymous">
</head>
<body>

    <h2 class="text-center p-4 m-4">Edit Mahasiswa</h2>

    <p class="text-center p-4 m-8"><?= htmlspecialchars($pesan) ?></p>


    <form method="POST" class="mx-auto" style="width: 75vw">
        <label class="form-label">NIM:</label>
        <input type="text" class="form-control" value="<?= htmlspecialchars($data["nim"]) ?>" disabled>
        <br>

        <label class="form-label">Nama:</label>
        <input type="text" class="form-control" name="nama" value="<?= htmlspecialchars($data["nama"]) ?>" required maxlength="100">
        <br>

        <label class="form-label">Program Studi:</label>
        <input type="text" class="form-control" name="prodi" value="<?= htmlspecialchars($data["prodi"]) ?>" required maxlength="100">
        <br>

        <label class="form-label">Semester:</label>
        <input type="number" class="form-control" name="semester" min="1" max="14" value="<?= (int) $data["semester"] ?>" required>
        <br>

        <div class="d-flex flex-row justify-content-around p-4 m-4">
            <button class="btn-subtle theme-success" type="submit">Simpan Perubahan</button>
            <a href="index.php">Kembali</a>
        </div>
    </form>
</body>
</html>