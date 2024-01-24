<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8" />
		<title>TP3</title>
		<meta name="Description" content="Ma Page De Formulaire">
		<meta name="Keywords" content="IUT, Rodez">
		<link rel="stylesheet" href="src/bootstrap/css/bootstrap.css"/>
		<link rel='stylesheet' href='src/css/TP3.css'>
	</head>
    <body>
    <div class="container">
        <form action="./TP3-3.php" method="get">
            <div class="row">
                <div class="col-12">
                    <!-- Premier cadre qui contient le titre -->
                    <h1>Formulaire</h1>
                </div>
                <div class="col-4">
                    <!-- Second cadre contenant l'entrée de nom -->
                    <?php
                    // si le formulaire est envoyé, donc on teste si le bouton go est pressé
                    if(isset($_GET['go']) and isset($_GET['Nom']) and $_GET['Nom'] != ""){
                        $nom = htmlentities($_GET['Nom']);
                        // de base l'input est en rouge, si il est rempli il devient vert mais l'input n'est pas enlevé
                        // si tous les champs ne sont pas remplis alors l'input reste
                        if ($_GET["Prenom"] == "" or $_GET["Diplome"] == "default"or $_GET["Question"] == "") {
                            echo '<h1 class="ok">nom : </h1>';
                            echo '<input type="text" name="Nom" id="Nom" class="form-control" value="'.$nom.'">';
                        } else {
                            echo '<h1 class="ok">nom :'.$nom.'</h1>';
                        }
                    } else {
                        echo '<h1 class="erreur">nom : </h1>';
                        echo '<input type="text" name="Nom" id="Nom" class="form-control">';
                    }
                    ?>
                </div>
                <div class="col-4">
                    <!-- Troisième cadre contenant l'entrée de prénom -->
                    <?php
                    // si le formulaire est envoyé, donc on teste si le bouton go est pressé
                    if(isset($_GET['go'])and isset($_GET['Prenom']) and $_GET['Prenom'] != ""){
                        $prenom = htmlentities($_GET['Prenom']);
                        // de base l'input est en rouge, si il est rempli il devient vert mais l'input n'est pas enlevé
                        // si tous les champs ne sont pas remplis alors l'input reste
                        if ($_GET["Nom"] == "" or $_GET["Diplome"] == "default"or $_GET["Question"] == "") {
                            echo '<h1 class="ok">prénom : </h1>';
                            echo '<input type="text" name="Prenom" id="Prenom" class="form-control" value="'.$prenom.'">';
                        } else {
                            echo '<h1 class="ok">prénom :'.$prenom.'</h1>';
                        }
                    } else {
                        echo '<h1 class="erreur">prénom : </h1>';
                        echo '<input type="text" name="Prenom" id="Prenom" class="form-control">';
                    }
                    ?>
                </div>
                <div class="col-4">
                    <!-- Quatrième et derniere cadre de cette ligne , contenant Une liste de choix de diplome en cours -->

                    <?php

                    // si le formulaire est envoyé, donc on teste si le bouton go est pressé
                    if (isset($_GET['go']) and isset($_GET['Diplome']) and $_GET['Diplome'] != "default") {
                        $diplome = htmlentities($_GET['Diplome']);
                        // de base l'input est en rouge, si il est rempli il devient vert mais l'input n'est pas enlevé
                        // si tous les champs ne sont pas remplis alors l'input reste
                        if ($_GET["Nom"] == "" or $_GET["Prenom"] == "" or $_GET["Question"] == "") {
                            echo '<h1 class="ok">diplome préparé : </h1>';
                            echo '<select name="Diplome" id="Diplome" class="form-control">';
                            // le choix fait est selectionné
                            echo '<option value="default">Sélectionner dans la liste</option>';
                            echo '<option value="BUT GEA" '.(($diplome == "BUT GEA") ? "selected" : "").'>BUT GEA</option>';
                            echo '<option value="BUT Informatique" '.(($diplome == "BUT Informatique") ? "selected" : "").'>BUT Informatique</option>';
                            echo '<option value="BUT QLIO" '.(($diplome == "BUT QLIO") ? "selected" : "").'>BUT QLIO</option>';
                            echo '<option value="BUT CJ" '.(($diplome == "BUT CJ") ? "selected" : "").'>BUT CJ</option>';
                            echo '<option value="BUT InfoCom" '.(($diplome == "BUT InfoCom") ? "selected" : "").'>BUT InfoCom</option>';
                            echo '</select>';
                        } else {
                            echo '<h1 class="ok">diplome préparé :'.$diplome.'</h1>';
                        }
                    } else {
                        echo '<h1 class="erreur">diplome préparé :</h1>';
                        echo '<h1 class="erreur">question : </h1>';
                        echo '<select name="Diplome" id="Diplome" class="form-control">';
                        echo '<option value="default">Sélectionner dans la liste</option>';
                        echo '<option value="BUT GEA">BUT GEA</option>';
                        echo '<option value="BUT Informatique">BUT Informatique</option>';
                        echo '<option value="BUT QLIO">BUT QLIO</option>';
                        echo '<option value="BUT CJ">BUT CJ</option>';
                        echo '<option value="BUT InfoCom">BUT InfoCom</option>';
                        echo '</select>';
                    }

                    ?>
                </div>
                <div class="col-12">
                    <!-- Cinquième cadre contenant une zone de texte -->
                    <?php
                    $question = "";
                    // si le formulaire est envoyé, donc on teste si le bouton go est pressé
                    if(isset($_GET['go']) and isset($_GET['Question']) and $_GET['Question'] != ""){
                        $question = htmlentities($_GET['Question']);
                        // de base l'input est en rouge, si il est rempli il devient vert mais l'input n'est pas enlevé
                        // si tous les champs ne sont pas remplis alors l'input reste
                        if ($_GET["Nom"] == "" or $_GET["Prenom"] == "" or $_GET["Diplome"] == "default") {
                            echo '<h1 class="ok">question : </h1>';
                            echo '<textarea name="Question" id="Question" class="form-control">'.$question.'</textarea>';
                        } else {
                            echo '<h1 class="ok">question :'.$question.'</h1>';
                        }
                    } else {
                        echo '<h1 class="erreur">question : </h1>';
                        echo '<textarea name="Question" id="Question" class="form-control"></textarea>';
                    }
                    ?>
                </div>
                <div class="col-12">
                    <!--Boutton qui envoie nos information vers notre page TP3-2 -->
                    <input type="submit" value="Envoyer votre formulaire" name="go" class="btn btn-light btn-block">
                </div>
        </form>
    </div>
    </body>
</html>