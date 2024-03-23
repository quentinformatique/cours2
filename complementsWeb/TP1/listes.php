<?php
// Url API
$urlRecherche = "https://geo.api.gouv.fr";

// URLS exemples
//https://geo.api.gouv.fr/regions
//https://geo.api.gouv.fr/regions/76
//https://geo.api.gouv.fr/regions/76/departements
//https://geo.api.gouv.fr/departements/
//https://geo.api.gouv.fr/departements/12
//https://geo.api.gouv.fr/departements/12/communes"
//https://geo.api.gouv.fr/communes/12202
//https://geo.api.gouv.fr/epcis/
//https://geo.api.gouv.fr/epcis/241200187/communes

function appelAPI($apiUrl)
{
    // Interrogation de l'API
    // Retourne le résultat en format JSON
    $curl = curl_init();                                    // Initialisation

    curl_setopt($curl, CURLOPT_URL, $apiUrl);                // Url de l'API à appeler
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);            // Retour dans une chaine au lieu de l'afficher
    curl_setopt($curl, CURLOPT_SSL_VERIFYPEER, false);        // Désactive test certificat
    curl_setopt($curl, CURLOPT_FAILONERROR, true);

    // A utiliser sur le réseau des PC IUT, pas en WIFI, pas sur une autre connexion
    // $proxy = "http://cache.iut-rodez.fr:8080";
    // curl_setopt($curl, CURLOPT_HTTPPROXYTUNNEL, true);
    // curl_setopt($curl, CURLOPT_PROXY, $proxy);
    ///////////////////////////////////////////////////////////////////////////////
    $result = curl_exec($curl);                                // Exécution
    $http_status = curl_getinfo($curl, CURLINFO_HTTP_CODE);    // Récupération statut
    // Si 404  indique qu'un serveur ne peut pas trouver la ressource demandée
    // Si 200 c'est OK

    curl_close($curl);                                        // Cloture curl

    if ($http_status == "200") {                                // OK, l'appel s'est bien passé
        return json_decode($result, true);                    // Retourne la collection
    } else {
        $result = [];                                        // retourne une collection Vide
        return $result;
    }
}

?>


<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8"/>
  <title>WEB avancé TP1</title>

  <!-- Bootstrap CSS -->
  <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

</head>
<body>
<?php
// Variables à utiliser dans le script
$occitanie = "Occitanie";
$lozere = "Lozère";
$trelans = "Trélans";
$marseille = "Marseille";
$bordeaux = "Bordeaux";
$massegros = "Massegros Causses Gorges";
$saintGermainDuTeil = "Saint-Germain-du-Teil";

?>
<div class="container">
  <div class="row">
    <div class="col-xs-12">
      <h1>Liste des régions de France</h1>
        <?php
          $liste_region = appelAPI("https://geo.api.gouv.fr/regions");
          asort($liste_region);
          // on l'affiche sous forme ul li
          echo "<ul>";
          foreach ($liste_region as $region) {
              echo "<li>" . $region["code"] . " " . $region['nom'] . "</li>";
          }
          echo "</ul>";
        ?>
    </div>

    <div class="col-xs-12">
      <h1>Liste des départements de la région <?php echo $occitanie; ?></h1>
        <?php
          // on récupere le numéro de la région a partir de son nom
          $liste_region = appelAPI("https://geo.api.gouv.fr/regions");
          foreach ($liste_region as $region) {
              if ($region['nom'] == $occitanie) {
                  $num_region = $region['code'];
              }
          }
          $liste_departement = appelAPI("https://geo.api.gouv.fr/regions/" . $num_region . "/departements");
          asort($liste_departement);
          // on l'affiche sous forme ul li
          echo "<ul>";
          foreach ($liste_departement as $departement) {
              echo "<li>" . $departement["code"] . " " . $departement['nom'] . "</li>";
          }
          echo "</ul>";
        ?>

    </div>

    <div class="col-xs-12">
      <h1>Liste des Communes de la <?php echo $lozere; ?></h1>
        <?php
          // on récupere le numéro du département a partir de son nom
          $liste_departement = appelAPI("https://geo.api.gouv.fr/departements");
          foreach ($liste_departement as $departement) {
              if ($departement['nom'] == $lozere) {
                  $num_departement = $departement['code'];
              }
          }
          $liste_commune = appelAPI("https://geo.api.gouv.fr/departements/" . $num_departement . "/communes");
          asort($liste_commune);
          // on l'affiche sous forme ul li
          echo "<ul>";
          foreach ($liste_commune as $commune) {
              echo "<li>" . $commune["code"] . " " . $commune['nom'] . "</li>";
          }
          echo "</ul>";
        ?>

    </div>

    <div class="col-xs-12">
      <h1>Dans quelle communauté de communes est la commune de <?php echo $trelans; ?></h1>
        <?php
        $liste_commune = appelAPI("https://geo.api.gouv.fr/communes");
        foreach ($liste_commune as $commune) {
            if ($commune['nom'] == $trelans) {
                $num_commune = $commune['code'];
            }
        }

        $commune_info = appelAPI("https://geo.api.gouv.fr/communes/" . $num_commune);
        $epci = $commune_info['codeEpci'];

        $liste_commune = appelAPI("https://geo.api.gouv.fr/epcis/" . $epci);
        echo $liste_commune['nom'];
        ?>
    </div>

    <div class="col-xs-12">
      <h1>Liste des communes de la communauté de communes de <?php echo $trelans; ?></h1>
        <?php
          $liste_commune = appelAPI("https://geo.api.gouv.fr/communes");
          foreach ($liste_commune as $commune) {
              if ($commune['nom'] == $trelans) {
                  $num_commune = $commune['code'];
              }
          }

          $commune_info = appelAPI("https://geo.api.gouv.fr/communes/" . $num_commune);
          $epci = $commune_info['codeEpci'];

          $liste_commune = appelAPI("https://geo.api.gouv.fr/epcis/" . $epci . "/communes");
          asort($liste_commune);
          // on l'affiche sous forme ul li
          echo "<ul>";
          foreach ($liste_commune as $commune) {
              echo "<li>" . $commune["code"] . " " . $commune['nom'] . "</li>";
          }
          echo "</ul>";
        ?>

    </div>
    <div class="col-xs-12">
      <h1>Nombre d'habitants de la commune de '<?php echo $saintGermainDuTeil; ?>'</h1>
      <?php
        // on récupere le numéro de la commune a partir de son nom
        $liste_commune = appelAPI("https://geo.api.gouv.fr/communes");
        foreach ($liste_commune as $commune) {
            if ($commune['nom'] == $saintGermainDuTeil) {
                $num_commune = $commune['code'];
            }
        }
        // on récupere le nombre d'habitants de la commune
        $liste_commune = appelAPI("https://geo.api.gouv.fr/communes/" . $num_commune);
        echo $liste_commune['population'];

      ?>
    </div>
    <div class="col-xs-12">
      <h1>Liste des codes postaux de '<?php echo $massegros; ?>'</h1>
      <?php
        $liste_commune = appelAPI("https://geo.api.gouv.fr/communes");
        foreach ($liste_commune as $commune) {
            if ($commune['nom'] == $massegros) {
                $num_commune = $commune['code'];
            }
        }
        $liste_commune = appelAPI("https://geo.api.gouv.fr/communes/" . $num_commune);
        echo "<ul>";
        foreach ($liste_commune['codesPostaux'] as $codePostal) {
            echo "<li>" . $codePostal . "</li>";
        }
        echo "</ul>";
      ?>

    </div>
  </div>
</div>
<br><br>
</body>
</html>