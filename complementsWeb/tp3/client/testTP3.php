<?php

// Appel de l'API

if (isset($_GET['code_barre'])) {
    // on verfie que dans l'url il y a un prix et un stock
    if (isset($_GET['prix']) && isset($_GET['stock']) && is_numeric($_GET['prix']) && is_numeric($_GET['stock']) && $_GET['prix'] >= 0 && $_GET['stock'] >= 0) {
        $http_status = 0;
        $donnees = json_encode(array("prix" => $_GET['prix'], "stock" => $_GET['stock']));  
        $appel = appelAPI("http://localhost/tp3/api/modifPrixStock/" . $_GET['code_barre'], "", $http_status, "PUT", $donnees);
    } else {
        $http_status = 400;
        $appel = "Prix ou stock non valide";
    }
}


function appelAPI($apiUrl, $apiKey, &$http_status, $typeRequete = "GET", $donnees = null)
{
    // Interrogation de l'API
    // $apiUrl Url d'appel de l'API
    // $http_status Retourne le statut HTTP de la requete
    // $typeRequete = GET / POST / DELETE / PUT, GET par défaut si non précisé
    // $donnees = données envoyées au format JSON en PUT ET POST, rien si GET ou DELETE
    // La fonction retourne le résultat en format JSON

    $curl = curl_init();                  // Initialisation

    curl_setopt($curl, CURLOPT_URL, $apiUrl);        // Url de l'API à appeler
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);      // Retour dans une chaine au lieu de l'afficher
    curl_setopt($curl, CURLOPT_SSL_VERIFYPEER, false);    // Désactive test certificat
    curl_setopt($curl, CURLOPT_FAILONERROR, false);

    // Parametre pour le type de requete
    curl_setopt($curl, CURLOPT_CUSTOMREQUEST, $typeRequete);

    // Si des données doivent être envoyées
    if (!empty($donnees)) {
        curl_setopt($curl, CURLOPT_POSTFIELDS, $donnees);
        curl_setopt($curl, CURLOPT_POST, true);
    }

    $httpheader [] = "Content-Type:application/json";

    if (!empty($apiKey)) {
        // Ajout de la clé API dans l'entete si elle existe (pour tous les appels sauf login)
        $httpheader = ['APIKEYDEMONAPPLI: ' . $apiKey];
    }
    curl_setopt($curl, CURLOPT_HTTPHEADER, $httpheader);

    // A utiliser sur le réseau des PC IUT, pas en WIFI, pas sur une autre connexion
    // $proxy="http://cache.iut-rodez.fr:8080";
    // curl_setopt($curl, CURLOPT_HTTPPROXYTUNNEL, true);
    // curl_setopt($curl, CURLOPT_PROXY,$proxy ) ;
    ///////////////////////////////////////////////////////////////////////////////

    $result = curl_exec($curl);                // Exécution
    $http_status = curl_getinfo($curl, CURLINFO_HTTP_CODE);  // Récupération statut

    curl_close($curl);                    // Cloture curl
    return json_decode($result, true);          // Retourne la collection
}

?>


<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8"/>
  <title>TP3 API STOCK</title>

  <!-- Bootstrap CSS -->
  <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <?php
    if (isset($_GET['code_barre'])) {
        if (isset($_GET['prix']) && isset($_GET['stock'])) {
            echo '<h1> CODE BARRE : ' . $_GET['code_barre'] . '</h1>';
            echo '<h1> PRIX : ' . $_GET['prix'] . '</h1>';
            echo '<h1> STOCK : ' . $_GET['stock'] . '</h1>';
            // si les données sont bien envoyées on affiche un message de confirmation
            if ($http_status == 200) {
                echo "<div class='alert alert-success'>Les données ont bien été envoyées</div>";
            } else {
                echo "<div class='alert alert-danger'>$appel</div>";
            }
        }   
    }
    ?>
  <div class="row">
    <div class="col-xs-12">
      <h1>Modification des stocks et prix des articles</h1>

        <?php

        $http_status = 0;

        // Appel de l'API
        $appel = appelAPI("http://localhost/tp3/api/articlesStockPrix", "", $http_status)['articles'];

        // on fais autan de form qu'il y a d'article l'id des form est form1, form2, form3 etc

		if ($http_status == 200) {
			for ($i = 1; $i < count($appel); $i++) {
				echo "<form id='form" . $i . "' method='GET' action='testTP3.php'></form>";
			}
        }


        echo "<table class='table table-striped table-bordered'>";

        echo "<tr><th>Categorie</th><th>Code Article</th><th>Désignation</th><th>Taille</th><th>Couleur</th><th>Code Barre</th><th>Prix</th><th>Stock</th><th>Validation</th></tr>";

        if ($http_status != 200) {
            echo "<tr><td colspan='8'>Erreur lors de l'appel de l'API</td></tr>";
        } else {
            for ($i = 1; $i < count($appel); $i++) {
                echo "<tr>";
                echo "<td>" . $appel[$i]['CATEGORIE'] . "</td>";
                echo "<td>" . $appel[$i]['CODE_ARTICLE'] . "</td>";
                echo "<td>" . $appel[$i]['DESIGNATION'] . "</td>";
                echo "<td>" . $appel[$i]['TAILLE'] . "</td>";
                echo "<td>" . $appel[$i]['COULEUR'] . "</td>";
                echo "<td>" . $appel[$i]['CODE_BARRE'] . "</td>";
                // input caché pour envoyer le code barre
                echo "<input form='form$i' type='hidden' name='code_barre' value='" . $appel[$i]['CODE_BARRE'] . "'>";
                echo "<td><input form='form$i' type='text' name='prix' value='" . $appel[$i]['PRIX'] . "'></td>";
                echo "<td><input form='form$i' type='text' name='stock' value='" . $appel[$i]['STOCK'] . "'></td>";
                echo "<td><input form='form$i' type='submit' value='Valider'></td>";
                echo "</tr>";
            }
        }

        echo "</table>";
        ?>
    </div>
  </div>
</div>
<br><br>
</body>
</html>