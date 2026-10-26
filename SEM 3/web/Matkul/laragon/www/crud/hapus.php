<?php
require_once __DIR__ . "/koneksi.php";

if ($_SERVER["REQUEST_METHOD"] !== "POST") {
    http_response_code(405);
    exit("error hapus.php: Invalid request method.");
}

$id = filter_input(INPUT_POST, "id", FILTER_VALIDATE_INT);

if (!$id || $id < 1) {
    exit("ID tidak valid.");
}

$stmt = $conn->prepare(
    "DELETE FROM mahasiswa WHERE id = ?"
);

$stmt->bind_param("i", $id);

if ($stmt->execute()) {
    header("Location: index.php");
    exit;
}

http_response_code(500);
echo "Data gagal dihapus.";

$stmt->close();
$conn->close();
?>