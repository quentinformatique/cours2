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
        <form method="post" action="TP5-PDO-Q2.php">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="code">Code Client</label>
                    <input type="text" name="code" placeholder="Code client (maximum 35 caractères)" class="form-control" value="">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="nomMagasin">Nom du magasin</label>
                    <input type="text" name="nomMagasin" placeholder="Nom du magasin (maximum 35 caractères)" class="form-control" value="">
                </div>
                <div class="form-group col-md-12">
                    <label for="Responsable">Responsable</label>
                    <input type="text" name="Responsable" placeholder="Responsable (maximum 35 caractères)" class="form-control" value="">
                </div>
                <div class="form-group col-md-12">
                    <label for="adresse1">Ligne d'adresse 1</label>
                    <input type="text" name="adresse1" placeholder="Ligne d'adresse 1 (maximum 35 caractères)" class="form-control" value="">
                </div>
                <div class="form-group col-md-12">
                    <label for="adresse2">Ligne d'adresse 2</label>
                    <input type="text" name="adresse2" placeholder="Ligne d'adresse 2 (maximum 35 caractères)" class="form-control" value="">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="codePostal">Code postal : </label>
                    <input type="text" name="codePostal" placeholder="Code postal (maximum 5 caractères)" class="form-control" value="">
                </div>
                <div class="form-group col-md-10">
                    <label for="ville">Ville : </label>
                    <input type="text" name="ville" placeholder="Ville (maximum 35 caractères)" class="form-control" value="">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="categorie">Catégorie : </label>
                    <select name="categorie" class="form-control">
                        <?php
                        // Requête SQL des types de cleints trié par ordre alpahabetique
                        $stmt = $pdo->query('SELECT * FROM c_types ORDER BY DESIGNATION');

                        echo '<option value="none" selected>Choisir une catégorie</option>';

                        while ($element = $stmt->fetch()) {
                            // Affichage des catégories
                            echo '<option value="' . $element['CODE_TYPE'] . '">' . $element['DESIGNATION'] . '</option>';
                        }
                        ?>
                    </select>
                </div>
                <div class="form-group col-md-3">
                    <label for="telephone">Téléphone : </label>
                    <input type="text" name="telephone" placeholder="Téléphone (maximum 10 caractères)" class="form-control" value="">
                </div>
                <div class="form-group col-md-3">
                    <label for="mail">Adressse email : </label>
                    <input type="text" name="mail" placeholder="adresse email (maximum 35 caractères)" class="form-control" value="">
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
</body>
</html>