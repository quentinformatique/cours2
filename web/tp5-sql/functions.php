<?php

function connectBD()
{
    $host = 'localhost';    // Serveur de BD
    $db = 'mezabi3';        // Nom de la BD
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

function formSend() {
    return isset($_POST['codeClient'])  && isset($_POST['nomMagasin'])
        && isset($_POST['responsable']) && isset($_POST['adresse1'])
        && isset($_POST['adresse2'])    && isset($_POST['cdp']) && isset($_POST['ville'])
        &&  isset($_POST['categorie'])  && isset($_POST['noTel'])
        && isset($_POST['mail']) ;
}

function formValid() {
    $codeClient = $_POST['codeClient'];
    $nomMagasin = $_POST['nomMagasin'];
    $responsable = $_POST['responsable'];
    $adresse1 = $_POST['adresse1'];
    $adresse2 = $_POST['adresse2'];
    $cdp = $_POST['cdp'];
    $ville = $_POST['ville'];
    $categorie = $_POST['categorie'];
    $noTel = $_POST['noTel'];
    $mail = $_POST['mail'];

    $codeClientValid = strlen($codeClient) <= 15 && strlen($codeClient) > 0;
    $nomMagasinValid = strlen($nomMagasin) <= 35 && strlen($nomMagasin) > 0;
    $responsableValid = strlen($responsable) <= 35 && strlen($responsable) > 0;
    $adresse1Valid = strlen($adresse1) <= 35 && strlen($adresse1) > 0;
    $adresse2Valid = strlen($adresse2) <= 35 && strlen($adresse2) > 0;
    $cdpValid = preg_match("/^(?:0[1-9]|[1-8]\d|9[0-8])\d{3}$/", $cdp);
    $villeValid = strlen($ville) <= 35 && strlen($ville) > 0;
    $categorieValid = $categorie != "none";
    $noTelValid = preg_match("#^[0-9]{10}#", $noTel);
    $mailValid = filter_var($mail, FILTER_VALIDATE_EMAIL);

    return $codeClientValid && $nomMagasinValid && $responsableValid && $adresse1Valid && $adresse2Valid && $cdpValid && $villeValid && $categorieValid && $noTelValid && $mailValid;
}

function writeQuery() {
    $query = "INSERT INTO clients (CODE_CLIENT, NOM_MAGASIN, ADRESSE_1, ADRESSE_2, CODE_POSTAL, VILLE, RESPONSABLE, TELEPHONE, EMAIL, TYPE_CLIENT) VALUES (:codeClient, :nomMagasin, :adresse1, :adresse2, :cdp, :ville, :responsable, :noTel, :mail, :categorie)";
    $params = [
        'codeClient' => $_POST['codeClient'],
        'nomMagasin' => $_POST['nomMagasin'],
        'responsable' => $_POST['responsable'],
        'adresse1' => $_POST['adresse1'],
        'adresse2' => $_POST['adresse2'],
        'cdp' => $_POST['cdp'],
        'ville' => $_POST['ville'],
        'categorie' => $_POST['categorie'],
        'noTel' => $_POST['noTel'],
        'mail' => $_POST['mail']
    ];
    return sendQuery($query, $params);
}