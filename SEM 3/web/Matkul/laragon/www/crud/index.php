<?php
require_once __DIR__ . "/koneksi.php";

$sql = "SELECT id, nim, nama, prodi, semester
        FROM mahasiswa
        ORDER BY id ASC";

$result = $conn->query($sql);
?>

<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Data Mahasiswa</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@6.0.0-alpha.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-B/GM4XqrwHnWXNOWMbloTmrYXZg10cakYGmpfsR/bbzQ6JAJI4ihuyADKLnBgrCe" crossorigin="anonymous">
</head>
<body>

<h2 class="text-center p-4 m-4">Daftar Mahasiswa</h2>

<div class="text-center p-4 m-4"><a href="tambah.php">Tambah Mahasiswa</a></div>


<table class="table table-striped w-75 mx-auto">
    <tr>
        <th>ID</th>
        <th>NIM</th>
        <th>Nama</th>
        <th>Program Studi</th>
        <th>Semester</th>
        <th>Aksi</th>
    </tr>

    <?php while ($row = $result->fetch_assoc()): ?>
    <tr>
        <td><?= (int) $row["id"] ?></td>
        <td><?= htmlspecialchars($row["nim"]) ?></td>
        <td><?= htmlspecialchars($row["nama"]) ?></td>
        <td><?= htmlspecialchars($row["prodi"]) ?></td>
        <td><?= (int) $row["semester"] ?></td>
        <td>
            <form action="edit.php" method="GET" style="display: inline;">
                
                <input type="hidden" name="id" value="<?= (int) $row["id"] ?>">

                <button type="submit">Edit</button>
            </form>

            <form action="hapus.php" method="POST" style="display:inline" onsubmit="return confirm('Hapus data ini?')">

                <input type="hidden" name="id" value="<?= (int) $row["id"] ?>">

                <button type="submit">Hapus</button>
            </form>
        </td>
    </tr>
    <?php endwhile; ?>
</table>

</body>
</html>