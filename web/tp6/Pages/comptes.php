<?php
// On démarre la session AVANT d'écrire du code HTML
session_start();
if (!isset($_SESSION['connected']) || !$_SESSION['connected']) {
    header('Location: ../index.php');
}
?>

<html lang="fr">
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../CSS/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../CSS/fa/css/all.min.css">
    <link rel="stylesheet" href="../CSS/main.css">
    <link rel="icon" type="image/png" href="../images/bankIcon.png"/>
    <title>Liste des comptes</title>
</head>
<body class="gradientBackground">
<div class="container">
    <div class="row bgBlue frame">
        <div class="col-12 col-md-3">
            <img src="../images/Logo.jpg" class="logo img-fluid">
        </div>
        <!-- div vide pour séparer le boutton et le logo -->
        <div class="col-md-2">
        </div>
        <!---->
        <div class="col-12 col-md-6">
            <h1 class="title">
                Ma Banque en ligne
            </h1>
            <h1>
                IUT BANK ONLINE
            </h1>
        </div>
    </div>
    <div class="row gradientBackground frame">
        <div class="col-12">
            <h1>-- Bienvenue M. Hubert Delaclasse --</h1>
            <h2 class="notbold">
                Vous pourrez grâce à cette interface voir
                le détail de vos comptes
                et faires toutes vos opérations à distance.
            </h2>
        </div>
    </div>
    <div class="row gradientBackground frame">
        <div class="col-md-6 col-xl-2">
            <img src="../images/CompteCourant.jpg" class="logo img-fluid account">
        </div>
        <div class="col-md-6 col-xl-6">
            <h4 class="Comptetxt">Compte No 123456789ABC - Type : <br>Compte courant.</h4>
            <button class="btn btn-primary" onclick="window.location.href='./compte1.php';">
                Détail du compte
                <i class="fa-sharp fa-solid fa-list" style="color: #ffffff;"></i>
            </button>
        </div>
        <div class="col-md-12 col-xl-4">
            <h4 class="money negative">-50,00 €</h4>
        </div>
    </div>
    <div class="row gradientBackground frame">
        <div class="col-md-6 col-xl-2">
            <img src="../images/LivretA.jpg" class="logo img-fluid account">
        </div>
        <div class="col-md-6 col-xl-6">
            <h4 class="Comptetxt">Compte No 48657894RR - Type : Livret A</h4>
        </div>
        <div class="col-md-12 col-xl-4">
            <h4 class="money">1350,67 €</h4>
        </div>
    </div>
    <div class="row gradientBackground frame">
        <div class="col-md-6 col-xl-2">
            <img src="../images/LDD.jpg" class="logo img-fluid account">
        </div>
        <div class="col-md-6 col-xl-6">
            <h4 class="Comptetxt">Compte No 67345673TRV - Type : LDD</h4>
        </div>
        <div class="col-md-12 col-xl-4">
            <h4 class="money">350,25 €</h4>
        </div>
    </div>
    <div class="row gradientBackground frame">
        <div class="col-3 contactus">
            <button onclick="window.location.href='./contact.php';" type="button" class="btn btn-primary btn-md btn-block">
                Nous contacter <i class="fa-sharp fa-solid fa-envelope" style="color: #ffffff;"></i>
            </button>
        </div>
        <!-- div vide pour décaler le bouton et le logo -->
        <div class="col-3">
        </div>
        <!---->
        <div class="col-3 contactus">
            <a href="../functions/deconnexion.php" class="btn btn-danger btn-md btn-block">
                Déconnexion <i class="fa-sharp fa-solid fa-circle-xmark" style="color: #ffffff;"></i>
            </a>
        </div>
        <div class="col-3">
            <h3 class="text-dark">Réalisé par</h3>
            <img src="../images/LogoIut.png" class="logoiut img-fluid">
        </div>
    </div>
</div>
</body>
</html>