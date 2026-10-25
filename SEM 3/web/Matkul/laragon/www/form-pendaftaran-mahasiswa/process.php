
<?php
$nama = trim($_POST["nama"] ?? "");
$nim = trim($_POST["nim"] ?? "");
$email = trim($_POST["email"] ?? "");
$prodi = trim($_POST["prodi"] ?? "");
$semester = trim($_POST["semester"] ?? "");

$errors = [];

if ($nama === "") {
	$errors[] = "Nama tidak boleh kosong";
}

if ($nim === "") {
	$errors[] = "NIM tidak boleh kosong";
}

if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
	$errors[] = "Email tidak valid";
}

if ($prodi === "") {
	$errors[] = "Program Studi tidak boleh kosong";
}

$validSem = filter_var($semester, FILTER_VALIDATE_INT);

if ($validSem === false || $validSem < 1 || $validSem > 14) {
  $errors[] = "Semester harus dalam range 1-14.";
}

function safe_print($value) {
  return htmlspecialchars($value, ENT_QUOTES, 'UTF-8');
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@6.0.0-alpha.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-B/GM4XqrwHnWXNOWMbloTmrYXZg10cakYGmpfsR/bbzQ6JAJI4ihuyADKLnBgrCe" crossorigin="anonymous">
  <title>Daftar Mahasiswa</title>
</head>
<?php if (!empty($errors)): ?>
	<h2 class="h2 text-center p-4 m-8">Data Tidak Valid</h2>
	<ul>
			<?php foreach($errors as $error): ?>
			<li><?= safe_print($error) ?></li>
		<?php endforeach ?>
	</ul>
    <a href="form.php">Kembali ke form</a>

<?php else: ?>
	<h2 class="h2 text-center p-4 m-8">Data Valid</h2>
	<div class="mx-auto" style="width:80%;">
		<table class="table p-10">
			<thead>
				<th>NAMA</th>
				<th>NIM</th>
				<th>EMAIL</th>
				<th>PROGRAM STUDI</th>
				<th>SEMESTER</th>
			</thead>
			<tbody>
				<td><?= safe_print($nama) ?></td>
				<td><?= safe_print($nim) ?></td>
				<td><?= safe_print($email) ?></td>
				<td><?= safe_print($prodi) ?></td>
				<td><?= safe_print($semester) ?></td>
			</tbody>
		</table>
	</div>
	<button class="d-block btn mx-auto" type="submit" formaction="form.php">Kembali ke form</button>
<?php endif; ?>
</body>
</html>
