<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@6.0.0-alpha.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-B/GM4XqrwHnWXNOWMbloTmrYXZg10cakYGmpfsR/bbzQ6JAJI4ihuyADKLnBgrCe" crossorigin="anonymous">
  <title>Daftar Mahasiswa</title>
</head>
<body>
  <h1 class="h1 text-center p-4 m-4">Pendaftaran Mahasiswa</h1>
  <div class="d-block w-50 mx-auto">
    <form class="form-field" action="process.php" method="post">
    <label class="form-label" for="nama">Nama:</label>
    <input class="form-control" type="text" id="nama" name="nama" required><br/>

    <label class="form-label" for="nama">NIM:</label>
    <input class="form-control" type="text" id="nim" name="nim" required><br/>

    <label class="form-label" for="email">Email:</label>
    <input class="form-control" type="email" id="email" name="email" required><br/>

    <label class="form-label" for="nama">Program Studi:</label>
    <input class="form-control" type="text" id="prodi" name="prodi" required><br/>

    <label class="form-label" for="semester">Semester:</label>
    <input class="form-control" type="number" id="semester" name="semester" min="1" max="14" step="1" required><br/><br/>
    <button class="btn" type="submit">Daftarkan Mahasiswa</button>
  </form> 
  </div>
</body>
</html>
