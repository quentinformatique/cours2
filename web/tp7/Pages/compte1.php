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
            $nomfichierEcritures = "../FichiersDonnees/Ecritures.csv";
            $nomFichierTypeEcritures = "../FichiersDonnees/TypeEcritures.csv";
            if (!file_exists($nomfichierEcritures)) {
                throw new Exception('Fichier ' . $nomfichierEcritures . ' non trouvé.');
            }
            if (!file_exists($nomFichierTypeEcritures)) {
                throw new Exception('Fichier ' . $nomFichierTypeEcritures . ' non trouvé.');
            }
            $tabEcritures = file($nomfichierEcritures, FILE_IGNORE_NEW_LINES);
            $tabTypeEcritures = file($nomFichierTypeEcritures, FILE_IGNORE_NEW_LINES);
        ?>
        <table class="table details">
            <?php
            // on retire la premier ligne du tableau qui contient les noms des colonnes
            array_shift($tabEcritures);
            // on retire la premier ligne du tableau qui contient les noms des colonnes
            array_shift($tabTypeEcritures);
            // on affiche l'entête du tableau
            echo "<tr>";
            echo "<th>Date</th>";
            echo "<th>Type</th>";
            echo "<th>Libellé</th>";
            echo "<th>Débit</th>";
            echo "<th>Crédit</th>";
            // on n'affiche pas la colonne solde quand on filtre par type
            if (!isset($_POST['type']) || $_POST['type'] == "") {
                echo "<th>Solde</th>";
            }
            echo "</tr>";

            // afficage d'un select dans la premier ligne du tableau, colonne type
            // affin de pouvoir filtrer les lignes par type
            echo "<tr>";
            echo "<td></td>";
            echo "<td>";
            echo "<form action='compte1.php' method='post' class='d-flex'>";
            echo "<select class='form-control' id='type' name='type'>";
            echo "<option value=''>Tous</option>";
            foreach ($tabTypeEcritures as $ligneType) {
                $elementsLigneType = explode(";", $ligneType);
                // on raffiche le type sélectionné précédemment
                if (isset($_POST['type']) && $_POST['type'] == $elementsLigneType[0]) {
                    echo "<option value='" . $elementsLigneType[0] . "' selected>" . $elementsLigneType[1] . "</option>";
                    continue;
                }
                echo "<option value='" . $elementsLigneType[0] . "'>" . $elementsLigneType[1] . "</option>";
            }
            // bouton pour filtrer les lignes par type
            echo "</select>";
            echo "<button type='submit' class='btn btn-info mx-2'>Filtrer</button>";
            echo "</form>";
            echo "</td>";
            echo "</tr>";


            // solde initial du compte,
            $solde = 0;
            // on affiche la premiere ligne du tableau
            foreach ($tabEcritures as $ligne) {
                echo "<tr>";
                $elementsLigne = explode(";", $ligne);
                // si on est passé par le formulaire et que le type de la ligne ne correspond pas au type sélectionné, on passe à la ligne suivante
                if (isset($_POST['type']) && $_POST['type'] != "" && $_POST['type'] != $elementsLigne[1]) {
                    // on affiche pas la ligne
                    continue;
                }
                foreach ($elementsLigne as $key => $e) {
                    if ($key == 1) {
                        // si c'est la colonne type, on affiche le libellé du type
                        foreach ($tabTypeEcritures as $ligneType) {
                            $elementsLigneType = explode(";", $ligneType);
                            if ($elementsLigneType[0] == $e) {
                                echo "<td>" . $elementsLigneType[1] . "</td>";
                            }
                        }
                    } else if ($key == 3 && $e != 0) {
                        // si c'est la colonne débit, on affiche le débit en rouge
                        echo "<td class='text-danger'>" . number_format((int)$e, 2, ',', '.') . "</td>";
                        $solde -= $e;
                    } else if ($key == 4 && $e != 0) {
                        // si c'est la colonne crédit, on affiche le crédit en vert
                        echo "<td class='text-success'>" . number_format((int)$e, 2, ',', '.') . "</td>";
                        $solde += $e;
                    } else {
                        // sinon on affiche la colonne normalement
                        echo "<td>$e</td>";
                    }

                }
                // si c'est la colonne solde, on affiche le solde en vertcela correspond au solde initial - les débits + les crédits
                // si on filtre par type, on n'affiche pas la colonne solde
                if (!isset($_POST['type']) || $_POST['type'] == "") {
                    echo "<td class='text-success'>" . number_format($solde, 2, '.', ',') . "</td>";
                }
                echo "</tr>";
            }
            } catch (Exception $e) {
                echo "<h1>Erreur : L'affichage de votre compte est momentanément indisponible, veuillez réessayer plus tard</h1><br />";
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