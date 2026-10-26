<?php
$host = "127.0.0.1";
$user = "root";
$password = "";
$database = "db_mhs";
$conn = new mysqli($host,$user,$password,$database);
if ($conn->connect_error) {
    die("error koneksi.php: Failed connection" . $conn->connect_error);
}
$conn->set_charset("utf8mb4");
?>