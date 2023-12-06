<?php

function connectBD()
{
    $host = 'localhost';    // Serveur de BD
    $db = 'iut_bank';        // Nom de la BD
    $user = 'root';        // User
    $pass = 'root';        // Mot de passe
    $charset = 'utf8mb4';    // charset utilisé

    // Constitution variable DSN
    $dsn = "mysql:host=$host;dbname=$db;charset=$charset";

    $options = [
        PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
        PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
        PDO::ATTR_EMULATE_PREPARES => false];

    // Connexion PDO
    return new PDO($dsn, $user, $pass, $options);
}

function sendQuery($query, $params = [])
{
    $pdo = connectBD();
    $stmt = $pdo->prepare($query);
    $stmt->execute($params);
    return $stmt;
}