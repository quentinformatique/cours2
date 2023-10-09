<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8" />
    <title>TP3</title>
    <meta name="Description" content="Ma Page De Formulaire">
    <meta name="Keywords" content="IUT, Rodez">
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.css"/>
    <link rel='stylesheet' href='../css/TP3.css'>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-4">
            <?php
                # On récupère la valeur de la variable Nom si elle existe sinon on met une chaîne vide
                $nom = isset($_GET['Nom']) ? htmlentities($_GET['Nom']) : "";
                # On vérifie que la variable n'est pas vide et qu'elle existe
                if ($nom == "" || !isset($nom)){
                    echo '<span class="erreur">Merci de rentrer votre nom !</span>';
                } else {
                    echo '<span class="ok">Votre nom est : '.$nom.'</span>';
                }
            ?>
        </div>
        <div class="col-4">
            <?php
            # On récupère la valeur de la variable Prenom si elle existe sinon on met une chaîne vide
            $prenom = isset($_GET['Prenom']) ? htmlentities($_GET['Prenom']) : "";
            # On vérifie que la variable n'est pas vide et qu'elle existe
            if ($prenom == "" || !isset($prenom)){
                    echo '<span class="erreur">Merci de rentrer votre prénom !</span>';
                } else {
                    echo '<span class="ok">Votre prénom est : '.$prenom.'</span>';
                }
            ?>
        </div>
        <div class="col-4">
            <?php
                # On récupère la valeur de la variable Diplome si elle existe sinon on met "default"
                $diplome = isset($_GET['Diplome']) ? htmlentities($_GET['Diplome']) : "default";
            # On vérifie que la variable n'est pas vide et qu'elle existe
            # on verifie que le diplome est bien dans la liste
                if (!isset($diplome) || $diplome == "default" ||
                    !in_array($diplome, array("BUT GEA", "BUT Informatique", "BUT QLIO", "BUT CJ", "BUT InfoCom")) ){
                    echo '<span class="erreur">Merci de rentrer votre diplôme !</span>';
                } else {
                    echo '<span class="ok">Votre diplôme est : '.$diplome.'</span>';
                }
            ?>
        </div>
        <div class="col-12">
            <?php
                # On récupère la valeur de la variable Question si elle existe sinon on met une chaîne vide
                $question = (isset($_GET['Question']) ? htmlentities($_GET['Question']) : "");
                # On vérifie que la variable n'est pas vide et qu'elle existe
                if ($question == "" || !isset($question)){
                    echo '<span class="erreur">Merci de rentrer votre question !</span>';
                } else {
                    echo '<span class="ok">Votre question : '.$question.'</span>';
                }
            ?>
        </div>
    </div>
</div>
</body>
</html>