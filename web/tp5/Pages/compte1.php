<html lang="fr">
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../CSS/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../CSS/fa/css/all.min.css">
    <link rel="stylesheet" href="../CSS/main.css">
    <link rel="icon" type="image/png" href="../images/bankIcon.png"/>
    <title>Détail du comptes</title>
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
        <div class="col-md-4 col-xl-2">
            <img src="../images/CompteCourant.jpg" class="logo img-fluid account">
        </div>
        <div class="col-md-8 col-xl-10">
            <h4 class="Comptetxt">Compte No 123456789ABC - Type : Compte courant.</h4>
        </div>
    </div>
    <div class="row gradientBackground frame">
        <?php
        try {
            $nomfichier = "../FichiersDonnees/Ecritures.csv";
            if (!file_exists($nomfichier)) {
                throw new Exception('Fichier ' . $nomfichier . ' non trouvé.');
            }
            $tabEcritures = file($nomfichier, FILE_IGNORE_NEW_LINES);
        } catch (Exception $e) {
            echo "Erreur : " . $e->getMessage() . "<br />";
        }
        ?>
        <table class="table details">
            <?php
            foreach ($tabEcritures as $ligne) {
                echo "<tr>";
                $elementsLigne = explode(";", $ligne);
                foreach ($elementsLigne as $e) {
                    echo "<td>".$e."</td>";
                }
                echo "</tr>";
            }
            ?>

        </table>
    </div>
    <div class="row gradientBackground frame">
        <div class="col-3 contactus">
            <button onclick="window.location.href='./contact.php';" type="button"
                    class="btn btn-primary btn-md btn-block">
                Nous contacter <i class="fa-sharp fa-solid fa-envelope" style="color: #ffffff;"></i>
            </button>
        </div>
        <div class="col-3 contactus">
            <button onclick="window.location.href='./comptes.php';" type="button"
                    class="btn btn-primary btn-md btn-block">
                Retour à la liste des comptes
            </button>
        </div>
        <div class="col-3 contactus">
            <button onclick="window.location.href='../index.php';" type="button"
                    class="btn btn-danger btn-md btn-block">
                Déconnexion <i class="fa-sharp fa-solid fa-circle-xmark" style="color: #ffffff;"></i>
            </button>
        </div>
        <div class="col-3">
            <h3 class="text-dark">Réalisé par</h3>
            <img src="../images/LogoIut.png" class="logoiut img-fluid">
        </div>
    </div>
</div>
</body>
</html>