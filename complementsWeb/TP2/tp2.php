<?php
// Url API
$urlRecherche = "https://geo.api.gouv.fr";

// URLS
//https://geo.api.gouv.fr/regions
//https://geo.api.gouv.fr/regions/76
//https://geo.api.gouv.fr/regions/76/departements
//https://geo.api.gouv.fr/departements/
//https://geo.api.gouv.fr/departements/12
//https://geo.api.gouv.fr/departements/12/communes"
//https://geo.api.gouv.fr/epcis/
//https://geo.api.gouv.fr/epcis/241200187/communes


function appelAPI($apiUrl)
{
    // Interrogation de l'API

    $curl = curl_init();                  // Initialisation

    curl_setopt($curl, CURLOPT_URL, $apiUrl);        // Url de l'API à appeler
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);      // Retour dans une chaine au lieu de l'afficher
    curl_setopt($curl, CURLOPT_SSL_VERIFYPEER, false);    // Désactive test certificat
    curl_setopt($curl, CURLOPT_FAILONERROR, true);

    $result = curl_exec($curl);                // Exécution
    $http_status = curl_getinfo($curl, CURLINFO_HTTP_CODE);  // Récupération statut
    // Si 404  indique qu'un serveur ne peut pas trouver la ressource demandée
    // Si 200 c'est OK
    curl_close($curl);                    // Cloture curl

    if ($http_status == "200") {                // OK, l'appel s'est bien passé
        return json_decode($result, true);          // Retourne la collection
    } else {
        $result = [];                    // retourne une collection Vide
        return $result;
    }
}

?>


<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8"/>
  <title>WEB avancé TP2</title>

  <!-- Bootstrap CSS -->
  <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

  <!-- Lien vers mon css -->
  <link href="css/monStyle.css" rel="stylesheet">

</head>
<body>
<div class="container">
  <div class="row">
    <div class="col-xs-12 cadresCom">
      <h1>-- Recherche des informations d'une commune --</h1>
    </div>
    <div class="col-xs-4 cadresCom hauteurMin">
      <form action="tp2.php" method="GET">
        <br/>
          <?php
          $regions = appelAPI($urlRecherche . "/regions");
          asort($regions);
          ?>
        <label for="region">Région (<?= count($regions); ?>) : </label>
        <select name="region" class="form-control">
          <option value="">Choisir une région</option>
            <?php
            foreach ($regions as $region) {
                if (isset($_GET['region']) && $region['code'] == $_GET['region']) {
                    echo "<option value='" . $region['code'] . "' selected>" . $region['nom'] . "</option>";
                } else {
                    echo "<option value='" . $region['code'] . "'>" . $region['nom'] . "</option>";
                }

            }
            ?>
        </select>
        <br>
        <button type="submit" class="btn btn-block btn-primary">Afficher les départements de la région</button>
      </form>
    </div>

    <div class="col-xs-4 cadresCom hauteurMin">
      <!-- on ne l'affiche que si on a choisi une région -->
        <?php
        // si il y a une région de sélectionnée
        if (isset($_GET['region'])) {
            $departements = appelAPI($urlRecherche . "/regions/" . $_GET['region'] . "/departements");
            asort($departements);

            // If there is only one department, automatically select it and fetch its communes
            if (count($departements) == 1) {
                $_GET['departement'] = $departements[0]['code'];
                $communes = appelAPI($urlRecherche . "/departements/" . $_GET['departement'] . "/communes");
                asort($communes);
            }
            ?>
          <!-- Région remplie, on cherche le département -->
          <form action="tp2.php" method="GET">
            <br/>
            <label for="departement">Département (<?= count($departements) ?>): </label>
            <input type="hidden" name="region" value="<?= $_GET['region'] ?>">
            <select name="departement" class="form-control">
              <option value="">Choisir un département</option>
                <?php
                foreach ($departements as $departement) {
                    if (isset($_GET['departement']) && $departement['code'] == $_GET['departement']) {
                        echo "<option value='" . $departement['code'] . "' selected>" . $departement['nom'] . "</option>";
                    } else {
                        echo "<option value='" . $departement['code'] . "'>" . $departement['nom'] . "</option>";
                    }
                }
                ?>
            </select>
            <br>
            <button type="submit" class="btn btn-block btn-primary">Afficher les communes du département</button>
          </form>
            <?php
        } ?>
    </div>

    <div class="col-xs-4 cadresCom hauteurMin">
        <?php
        // si il y a un département de sélectionné
        if (isset($_GET['departement'])) {
            $communes = appelAPI($urlRecherche . "/departements/" . $_GET['departement'] . "/communes");
            asort($communes);

            // If there is only one commune, automatically select it and display its information
            if (count($communes) == 1) {
                $_GET['commune'] = $communes[0]['code'];
                $commune = appelAPI($urlRecherche . "/communes/" . $_GET['commune']);
                asort($commune);
            }
            ?>
          <!-- département rempli, on cherche la commune -->
          <form action="tp2.php" method="GET">
            <br/>
            <label for="commune">Commune (<?= count($communes); ?>) : </label>
            <input type="hidden" name="region" value="<?= $_GET['region'] ?>">
            <input type="hidden" name="departement" value="<?= $_GET['departement'] ?>">
            <select name="commune" class="form-control">
              <option value="">Choisir une commune</option>
                <?php
                foreach ($communes as $commune) {
                    if (isset($_GET['commune']) && $commune['code'] == $_GET['commune']) {
                        echo "<option value='" . $commune['code'] . "' selected>" . $commune['nom'] . "</option>";
                    } else {
                        echo "<option value='" . $commune['code'] . "'>" . $commune['nom'] . "</option>";
                    }

                }
                ?>
            </select>
            <br>
            <button type="submit" value="Rechercher" class="btn btn-block btn-primary">Afficher les informations de la
              commune
            </button>
          </form>
            <?php
        } ?>
    </div>
  </div>
  <br><br>

  <!-- Commune remplie, on affiche les renseignements -->

  <div class="row">
      <?php
      if (isset($_GET['commune'])) {
      $commune = appelAPI($urlRecherche . "/communes/" . $_GET['commune']);
      asort($commune);
      ?>
    <div class="col-xs-12 cadresCom hauteurMinResultat">
      <div class='row '>
        <div class='col-xs-12 '>
          <h1><?= $commune['nom'] ?></h1>
        </div>
        <div class='col-xs-4 cadreAGauche'>
          Région : <a href='tp2.php?region=<?= $commune['codeRegion'] ?>'><?= $commune['codeRegion'] ?>
            - <?php $nomRegion = appelAPI($urlRecherche . "/regions/" . $commune['codeRegion']);
                echo $nomRegion['nom'] ?></a><br/><br/>
          Département : <a
                  href='tp2.php?region=<?= $commune['codeRegion'] ?>&departement=<?= $commune['codeDepartement'] ?>'><?= $commune['codeDepartement'] ?>
            - <?php $nomDepartement = appelAPI($urlRecherche . "/departements/" . $commune['codeDepartement']);
                echo $nomDepartement['nom'] ?></a><br/><br/>
          Commune : <?= $commune['code'] ?> - <?= $commune['nom'] ?><br/><br/>
          Code SIREN : <?= $commune['siren'] ?><br/>
        </div>
        <div class='col-xs-4 cadreAGauche'>
          Communauté de communes : <br>
            <?php
            //si la commune fait partie d'une communauté de communes
            if (isset($commune['codeEpci'])) {
                ?>
                <?= $commune['codeEpci'] ?> - <?php $nomEpci = appelAPI($urlRecherche . "/epcis/" . $commune['codeEpci']);
                echo $nomEpci['nom'] ?><br/>
                <?php
                // habitans de la communauté de communes
                $com = appelAPI($urlRecherche . "/epcis/" . $commune['codeEpci']);
                echo $com['population'] . " habitants";
                ?>
              <br><br>
              Communes :
              <ul>
                  <?php
                  // liste des communes de la communauté de communes
                  $com = appelAPI($urlRecherche . "/epcis/" . $commune['codeEpci'] . "/communes");
                  foreach ($com as $c) {
                      echo "<li><a href='tp2.php?region=" . $c['codeRegion'] . "&departement=" . $c['codeDepartement'] . "&commune=" . $c['code'] . "'>" . $c['nom'] . "</a></li>";
                  }
                  ?>
              </ul>
                <?php
            } else {
                echo "Pas de communauté de communes";
            }
            ?>
        </div>
        <div class='col-xs-4'><?= $commune['population'] ?> habitants<br/><br/>
          Codes postaux :
          <ul>
              <?php
              foreach ($commune['codesPostaux'] as $codePostal) {
                  echo "<li>" . $codePostal . "</li>";
              }
              ?>
          </ul>
        </div>
      </div>
    </div>
  </div>
    <?php
    }
    ?>
</div>
<br><br>
</body>
</html>