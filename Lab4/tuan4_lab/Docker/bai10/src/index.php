<?php
$host = 'db';
$user = 'root';
$pass = 'password';
$dbname = 'test';

$conn = new mysqli($host, $user, $pass, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

echo "<h1>Connected to MySQL Database!</h1>";

// Create table if not exists
$conn->query("CREATE TABLE IF NOT EXISTS visits (id INT AUTO_INCREMENT PRIMARY KEY, timestamp DATETIME)");

// Insert visit
$conn->query("INSERT INTO visits (timestamp) VALUES (NOW())");

// Count visits
$result = $conn->query("SELECT COUNT(*) as count FROM visits");
$row = $result->fetch_assoc();
echo "<p>Total visits: " . $row['count'] . "</p>";

$conn->close();
?>
