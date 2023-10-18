<!doctype html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <title>Les excuses du lundi matin</title>

    <link href="src/css/monStyle.css" rel="stylesheet">

    <!-- Bootstrap CSS -->
    <link href="src/bootstrap/css/bootstrap.css" rel="stylesheet">

</head>
<body>
<div class="container-fluid">
    <div class="row cadre ">
        <div class="col-12">

            <?php
            // si on a submit le formulaire, on recupere les valeurs et on les affiche
            if (isset($_GET['submit'])) {
                echo '<h2>Mon excuse :</h2>';
                echo '<h3>';
                echo $_GET['1'] . ' ' . $_GET['2'] . ' ' . $_GET['3'] . ' ' . $_GET['4'] . ' ' . $_GET['5'] . ' ' . $_GET['6'] . ' ' . $_GET['7'] . ' ' . $_GET['8'];
                echo '</h3>';
                echo "(vous pouvez modifier votre excuse en changeant les champs)";
            } else {
                echo '<h2>Les excuses du lundi matin</h2>';
                echo "Générez votre excuse du lundi matin en selectionnant les différents champs";
            }
            ?>
        </div>
    </div>

    <div class="row cadre ">
        <div class="col-12">
            <form action="index.php">
                <?php
                // on balaie le tableau a deux dimensions contenant les phrases
                // et on affiche les phrases dans un select
                // si on est deja passé par le formulaire, on raffifche les valeurs dans le select
                include('tableauPhrases.php');
                for ($i = 1; $i <= 8; $i++) {
                    echo '<select name="' . $i . '">';
                    for ($j = 1; $j <= count($tabExGen[$i]); $j++) {
                        if (isset($_GET[$i]) && $_GET[$i] == $tabExGen[$i][$j]) {
                            echo '<option value="' . $tabExGen[$i][$j] . '" selected>' . $tabExGen[$i][$j] . '</option>';
                        } else {
                            echo '<option value="' . $tabExGen[$i][$j] . '">' . $tabExGen[$i][$j] . '</option>';
                        }
                    }
                    echo '</select><br>';
                }
                ?>
                <input type="submit" name="submit" value="Générer une excuse" class="btn btn-info m-2">
            </form>
        </div>
    </div>
</div>
</body>
</html>