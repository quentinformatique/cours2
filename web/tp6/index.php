<?php
// On démarre la session AVANT d'écrire du code HTML
session_start();
// on ecris les variables de session
$_SESSION['connected'] = false;
if (isset($_POST['id'])) {
    $_SESSION['id'] = $_POST['id'];
} else {
    $_SESSION['id'] = "";
}
if (isset($_POST['mdp'])) {
    $_SESSION['mdp'] = $_POST['mdp'];
} else {
    $_SESSION['mdp'] = "";
}
include('./functions/connexion.php');

if (isset($_POST['id']) && isset($_POST['mdp'])) {
    try {
        if (verfierConnection($_POST['id'], $_POST['mdp'])) {
            $_SESSION['connected'] = true;
            header('Location: ./Pages/comptes.php');
        }
    } catch (Exception $e) {
    }
}
?>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Les feuilles de styles -->
    <link rel="stylesheet" href="CSS/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="./CSS/fa/css/all.min.css">
    <link rel="stylesheet" href="./CSS/main.css">
    <!-- Le favicon -->
    <link rel="icon" type="image/png" href="./images/bankIcon.png"/>
    <title>Accueil</title>
</head>
<body class="gradientBackground">
<div class="container">
    <!-- Premier bloc -->
    <div class="row bgBlue frame">
        <div class="col-12 col-md-3">
            <img src="./images/Logo.jpg" class="logo img-fluid">
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
    <!-- Deuxième bloc -->
    <div class="row gradientBackground frame">
        <div class="col-12">
            <h1>-- Bienvenue sur le site de IUT BANK --</h1>
            <h2>Vous pourrez grâce à cette interface voir le détail de vos comptes et faire toutes vos opérations à distance.</h2>
        </div>
    </div>
    <!-- Troisième bloc -->
    <form action="index.php" method="post">
        <div class="row gradientBackground frame">
            <!-- si on est a deja tenté de se connecter et que l'identifiant est faux -->
            <?php
                try {
                    if (isset($_POST['id']) && !verfierConnection($_POST['id'], $_POST['mdp'])) {
                        echo '<div class="col-12">';
                        echo '<h3 class="text-danger">Identifiant ou mot de passe incorrect</h3>';
                        echo '</div>';
                    }
                } catch (Exception $e) {
                    echo '<div class="col-12">';
                    echo '<h3 class="text-danger">Erreur lors de la vérification de l\'identifiant, veuillez réessayer plus tard</h3>';
                    echo '</div>';
                }

            ?>

                <div class="col-12 col-md-6">
                    <h4>Identifiant :</h4>
                    <div class="input-group">
                        <input name="id" class="form-control" type="text" placeholder="Tapez votre numéro de compte">
                    </div>
                </div>
                <div class="col-12 col-md-6">
                    <h4>Mot de passe :</h4>
                    <div class="input-group">
                        <input name="mdp" class="form-control" type="password" placeholder="Tapez votre mot de passe">
                    </div>
                </div>
                <div class="col-12">
                    <button type="submit" class="btn btn-primary btn-md btn-block">
                        Me connecter <i class="fa-solid fa-right-to-bracket" style="color: #ffffff;"></i>
                    </button>
                </div>

        </div>
    </form>

    <!-- Quatrième bloc -->
    <div class="row gradientBackground frame">
        <div class="col-3 contactus">
            <button onclick="window.location.href='./Pages/contact.php';" type="button" class="btn btn-primary btn-md btn-block">
                Nous contacter <i class="fa-solid fa-envelope" style="color: #ffffff;"></i>
            </button>
        </div>
        <!-- div vide pour séparer le boutton et le logo -->
        <div class="col-6">
        </div>
        <!---->
        <div class="col-3">
            <h3 class="text-dark">Réalisé par</h3>
            <img src="./images/LogoIut.png" class="logoiut img-fluid">
        </div>
    </div>
</div>
</body>
</html>