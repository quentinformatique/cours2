<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>tp2</title>
    <link rel="stylesheet" href="style.css">
    </head>
<body>
    <h1>Etape 1</h1>
    <hr>
    <?php
        echo "bonjour le monde";
    ?>

    <h1>Etape 2</h1>
    <hr>

    <?php
    $maChaine = "quentin";
    echo "la chaine de base: $maChaine"."<br/>";

    $maChaineReverse = "";

    for($i = strlen($maChaine) - 1; $i >= 0; $i--) {
        $maChaineReverse .= mb_substr($maChaine, $i, 1);
    }

    echo "la chaine inversée: $maChaineReverse";
    ?>

    <h1>Etape 3</h1>
    <hr>

    <?php
    $chaine = "une lettre sur deux en rouge";

    for($i = 0; $i <= strlen($chaine) - 1; $i++) {
        if ($i % 2 == 0) {
            echo "<span class='red'>".mb_substr($chaine, $i, 1)."</span>";
        } else {
            echo mb_substr($chaine, $i, 1);
        }
    }

    ?>

    <h1>Etape 4</h1>
    <hr>
    <?php
        $locations = array(
            "Rodez"=> "https://www.ville-rodez.fr/",
            "Montpellier"=> "https://www.montpellier.fr/",
            "Toulouse"=> "https://www.toulouse.fr/",
            "Limoges"=> "https://https://www.limoges.fr/",
            "Paris"=> "https://www.parisinfo.com/",
        );

        $randomKey = array_rand($locations);

        echo "mes prochaine vacances se dérouleront à "."<a href=".$locations[$randomKey]." target='_blank'>$randomKey</a>";
    ?>
    <h1>Etape 5</h1>
    <hr>


</body>
</html>