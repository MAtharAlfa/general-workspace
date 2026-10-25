<?php
// Wajib dipanggil di baris paling atas sebelum output HTML!
session_start();

$message = "Selamat Datang!";

// Mengatur Aksi Berdasarkan Tombol yang Diklik
if (isset($_GET['action'])) {
    $action = $_GET['action'];

    if ($action === 'create') {
        // 1. Membuat Data Session (Disimpan di Server)
        $_SESSION['username'] = 'Praktikan Pemweb';
        $_SESSION['role'] = 'Admin';

        // 2. Membuat Custom Cookie (Disimpan di Browser selama 1 Jam)
        setcookie('theme', 'light', [
            'expires' => time() + 3600,
            'path'    => '/'
        ]);
        setcookie('user_lang', 'indonesian', [
            'expires' => time() + 3600,
            'path'    => '/'
        ]);

        $message = "Session & Cookie BERHASIL dibuat! Silakan cek Inspect Element.";
    } 
    elseif ($action === 'clear_session') {
        // Menghapus/menghancurkan Session
        session_unset();
        session_destroy();
        $message = "Session berhasil DIHAPUS (Hanya data di server yang bersih).";
    } 
    elseif ($action === 'clear_cookie') {
        // Menghapus Cookie (Set waktu kadaluarsa ke masa lalu)
        setcookie('theme', '', [
            'expires' => time() - 3600,
            'path'    => '/'
        ]);
        setcookie('user_lang', '', [
            'expires' => time() - 3600,
            'path'    => '/'
        ]);
        $message = "Cookie 'theme' dan 'user_lang' berhasil DIHAPUS dari browser.";
    }
}
?>
<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <title>Demo Inspect Element - Session & Cookie</title>
    <style>
        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; margin: 30px; background-color: #f4f6f9; color: #333; }
        .card { background: white; padding: 20px; border-radius: 8px; box-shadow: 0 4px 6px rgba(0,0,0,0.05); margin-bottom: 20px; }
        .btn { padding: 10px 16px; margin-right: 8px; text-decoration: none; color: white; border-radius: 5px; font-weight: bold; display: inline-block; }
        .btn-green { background-color: #28a745; }
        .btn-red { background-color: #dc3545; }
        .btn-orange { background-color: #fd7e14; }
        .btn-gray { background-color: #6c757d; }
        .alert { padding: 12px 15px; background-color: #e2e3e5; border-left: 5px solid #0d6efd; margin-bottom: 20px; font-weight: 500; }
        pre { background: #272822; color: #a6e22e; padding: 15px; border-radius: 6px; overflow-x: auto; font-size: 14px; }
    </style>
</head>
<body>

    <h2>Live Demo: Cek Session & Cookie di Inspect Element</h2>

    <?php if ($message): ?>
        <div class="alert">📢 <?= $message; ?></div>
    <?php endif; ?>

    <!-- Tombol Aksi -->
    <div class="card">
        <h3>1. Tombol Kontrol</h3>
        <a href="?action=create" class="btn btn-green">1. Buat Session & Cookie</a>
        <a href="?action=clear_session" class="btn btn-red">2. Hapus Session</a>
        <a href="?action=clear_cookie" class="btn btn-orange">3. Hapus Cookie</a>
        <a href="tes_session_cookies.php" class="btn btn-gray">Refresh Halaman</a>
    </div>

    <!-- Tampilan Array PHP -->
    <div class="card">
        <h3>2. Data yang Dibaca oleh Server PHP Saat Ini</h3>
        
        <h4>Isi Array <code>$_SESSION</code> (Data di Server):</h4>
        <pre><?php print_r($_SESSION); ?></pre>

        <h4>Isi Array <code>$_COOKIE</code> (Data di Browser):</h4>
        <pre><?php print_r($_COOKIE); ?></pre>
    </div>

    <!-- Panduan Inspect Element -->
    <div class="card">
        <h3>Cara Cek Fisiknya di Inspect Element (DevTools Browser):</h3>
        <ol>
            <li>Tekan <strong>F12</strong> (atau Klik Kanan ➔ Inspect).</li>
            <li>Klik tab <strong>Application</strong> di bagian atas (atau tab <strong>Storage</strong> jika pakai Firefox).</li>
            <li>Di bilah menu sebelah kiri, cari menu <strong>Storage ➔ Cookies ➔ http://localhost</strong>.</li>
            <li><strong>Lihat perubahannya:</strong>
                <ul>
                    <li><strong><code>PHPSESSID</code></strong>: Cookie otomatis buatan PHP untuk menyimpan Kode Sesi</li>
                    <li><strong><code>theme</code> & <code>user_lang</code></strong>: Cookie manual yang dibuat via <code>setcookie()</code>.</li>
                </ul>
            </li>
        </ol>
    </div>

</body>
</html>

