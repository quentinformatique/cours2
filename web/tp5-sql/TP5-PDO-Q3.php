<?php
include 'functions.php';


// on verifie que le formulaire a été envoyé en verifiant que les inputs ne sont pas vides
$formSend = formSend();

// on verifie que le formulaire a été envoyé en verifiant que les inputs ne sont pas vides
// si c'est le on ajoute le client dans la base de données
if (formSend() && formValid()) {
    // on se connecte à la base de données
    $pdo = connectBD();
    writeQuery();
}
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <title>TP 5 SQL dans un langage de programmation PDO</title>

    <!-- Bootstrap CSS -->
    <link href="src/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Lien vers mon CSS -->
    <link href="src/css/TP5-PDO.css" rel="stylesheet">
</head>

<body>
<?php
try{
// Connexion à la BD
$pdo = connectBD();
?>
<div class="container">

    <div class="col-12  cadre">
        <h1>Formulaire d'inscription</h1><br>
        <form method="post" action="TP5-PDO-Q3.php">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <?php
                    // si le code est mal renseigné, on affiche le label en rouge
                    if ($formSend && empty($_POST['codeClient'])) {
                        echo '<label for="codeClient" class="text-danger">Code Client : </label>';
                    } else {
                        echo '<label for="codeClient">Code Client : </label>';
                    }
                    // on affiche le champ avec la valeur précédemment renseignée
                    if ($formSend) {
                        echo '<input type="text" name="codeClient" placeholder="Code client (maximum 15 caractères)" class="form-control" value="' . $_POST['codeClient'] . '">';
                    } else {
                        echo '<input type="text" name="codeClient" placeholder="Code client (maximum 15 caractères)" class="form-control" value="">';
                    }
                    ?>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <?php
                    // si le nom est mal renseigné, on affiche le label en rouge
                    if ($formSend && empty($_POST['nomMagasin'])) {
                        echo '<label for="nomMagasin" class="text-danger">Nom du magasin : </label>';
                    } else {
                        echo '<label for="nomMagasin">Nom du magasin : </label>';
                    }
                    // on affiche le champ avec la valeur précédemment renseignée
                    if ($formSend) {
                        echo '<input type="text" name="nomMagasin" placeholder="Nom du magasin (maximum 35 caractères)" class="form-control" value="' . $_POST['nomMagasin'] . '">';
                    } else {
                        echo '<input type="text" name="nomMagasin" placeholder="Nom du magasin (maximum 35 caractères)" class="form-control" value="">';
                    }
                    ?>
                </div>
                <div class="form-group col-md-12">
                    <?php
                    // si le responsable est mal renseigné, on affiche le label en rouge
                    if ($formSend && empty($_POST['responsable'])) {
                        echo '<label for="responsable" class="text-danger">Responsable : </label>';
                    } else {
                        echo '<label for="responsable">Responsable : </label>';
                    }
                    // on affiche le champ avec la valeur précédemment renseignée
                    if ($formSend) {
                        echo '<input type="text" name="responsable" placeholder="Nom du responsable (maximum 35 caractères)" class="form-control" value="' . $_POST['responsable'] . '">';
                    } else {
                        echo '<input type="text" name="responsable" placeholder="Nom du responsable (maximum 35 caractères)" class="form-control" value="">';
                    }
                    ?>
                </div>
                <div class="form-group col-md-12">
                    <?php
                    // si l'adresse est mal renseignée, on affiche le label en rouge
                    if ($formSend && empty($_POST['adresse1'])) {
                        echo '<label for="adresse1" class="text-danger">Adresse ligne 1 : </label>';
                    } else {
                        echo '<label for="adresse1">Adresse ligne 1 : </label>';
                    }
                    // on affiche le champ avec la valeur précédemment renseignée
                    if ($formSend) {
                        echo '<input type="text" name="adresse1" placeholder="Ligne d\'adresse 1 (maximum 35 caractères)" class="form-control" value="' . $_POST['adresse1'] . '">';
                    } else {
                        echo '<input type="text" name="adresse1" placeholder="Ligne d\'adresse 1 (maximum 35 caractères)" class="form-control" value="">';
                    }
                    ?>
                </div>
                <div class="form-group col-md-12">
                    <?php
                    // si l'adresse est mal renseignée, on affiche le label en rouge
                    if ($formSend && empty($_POST['adresse2'])) {
                        echo '<label for="adresse2" class="text-danger">Adresse ligne 2 : </label>';
                    } else {
                        echo '<label for="adresse2">Adresse ligne 2 : </label>';
                    }
                    // on affiche le champ avec la valeur précédemment renseignée
                    if ($formSend) {
                        echo '<input type="text" name="adresse2" placeholder="Ligne d\'adresse 2 (maximum 35 caractères)" class="form-control" value="' . $_POST['adresse2'] . '">';
                    } else {
                        echo '<input type="text" name="adresse2" placeholder="Ligne d\'adresse 2 (maximum 35 caractères)" class="form-control" value="">';
                    }
                    ?>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-2">
                    <?php
                    // si le code postal est mal renseigné, on affiche le label en rouge
                    if ($formSend && empty($_POST['cdp'])) {
                        echo '<label for="cdp" class="text-danger">Code Postal : </label>';
                    } else {
                        echo '<label for="cdp">Code Postal : </label>';
                    }
                    // on affiche le champ avec la valeur précédemment renseignée
                    if ($formSend) {
                        echo '<input type="text" name="cdp" placeholder="Code postal (maximum 5 caractères)" class="form-control" value="' . $_POST['cdp'] . '">';
                    } else {
                        echo '<input type="text" name="cdp" placeholder="Code postal (maximum 5 caractères)" class="form-control" value="">';
                    }
                    ?>
                </div>
                <div class="form-group col-md-10">
                    <?php
                    // si la ville est mal renseignée, on affiche le label en rouge
                    if ($formSend && empty($_POST['ville'])) {
                        echo '<label for="ville" class="text-danger">Ville : </label>';
                    } else {
                        echo '<label for="ville">Ville : </label>';
                    }
                    // on affiche le champ avec la valeur précédemment renseignée
                    if ($formSend) {
                        echo '<input type="text" name="ville" placeholder="Ville (maximum 35 caractères)" class="form-control" value="' . $_POST['ville'] . '">';
                    } else {
                        echo '<input type="text" name="ville" placeholder="Ville (maximum 35 caractères)" class="form-control" value="">';
                    }
                    ?>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <?php
                    if ($formSend && $_POST['categorie'] == "none") {
                        echo '<label for="categorie" class="text-danger">Catégorie : </label>';
                    } else {
                        echo '<label for="categorie">Catégorie : </label>';
                    }
                    ?>
                    <select name="categorie" class="form-control">
                        <?php
                        $stmt = $pdo->query('SELECT * FROM c_types ORDER BY DESIGNATION');

                        // si l'envoie a etait fais mais que la categorie n'est pas renseignée, on affiche le label en rouge
                        echo '<option value="none" selected>Choisir une catégorie</option>';

                        while ($element = $stmt->fetch()) {
                            // Affichage des catégories
                            if ($formSend && $_POST['categorie'] == $element['CODE_TYPE']) {
                                echo '<option value="' . $element['CODE_TYPE'] . '" selected>' . $element['DESIGNATION'] . '</option>';
                            } else {
                                echo '<option value="' . $element['CODE_TYPE'] . '">' . $element['DESIGNATION'] . '</option>';
                            }
                        }
                        ?>
                    </select>
                </div>
                <div class="form-group col-md-3">
                    <?php
                    // si le numéro de téléphone est mal renseigné, on affiche le label en rouge
                    if ($formSend && empty($_POST['noTel'])) {
                        echo '<label for="noTel" class="text-danger">Numéro de téléphone : </label>';
                    } else {
                        echo '<label for="noTel">Numéro de téléphone : </label>';
                    }
                    // on affiche le champ avec la valeur précédemment renseignée
                    if ($formSend) {
                        echo '<input type="text" name="noTel" placeholder="Numéro de téléphone (maximum 10 caractères)" class="form-control" value="' . $_POST['noTel'] . '">';
                    } else {
                        echo '<input type="text" name="noTel" placeholder="Numéro de téléphone (maximum 10 caractères)" class="form-control" value="">';
                    }
                    ?>
                </div>
                <div class="form-group col-md-3">
                    <?php
                    // si le mail est mal renseigné, on affiche le label en rouge
                    if ($formSend && empty($_POST['mail'])) {
                        echo '<label for="mail" class="text-danger">Adresse mail : </label>';
                    } else {
                        echo '<label for="mail">Adresse mail : </label>';
                    }
                    // on affiche le champ avec la valeur précédemment renseignée
                    if ($formSend) {
                        echo '<input type="text" name="mail" placeholder="Adresse mail (maximum 35 caractères)" class="form-control" value="' . $_POST['mail'] . '">';
                    } else {
                        echo '<input type="text" name="mail" placeholder="Adresse mail (maximum 35 caractères)" class="form-control" value="">';
                    }
                    ?>
                </div>
            </div>
            <button name="go" type="submit" class="btn btn-primary btn-block">Valider le formulaire</button>
            <br>
        </form>
        <?php
        } catch (PDOException $e) {
            //Il y a eu une erreur
            echo "<h3>Erreur de connexion a la base de donées, veuillez réessayer plus tard </h3>";
        }
        ?>
    </div>
</div>
</body>
</html>