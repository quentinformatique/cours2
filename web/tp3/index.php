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
            <form action="src/php/TP3-2.php" method="get">
                <div class="row">
                    <div class="col-12">
                        <h1>Formulaire</h1>
                    </div>
                    <div class="col-4 p-5">
                        <h4>Nom :</h4>
                        <input type="text" name="Nom" id="Nom" class="form-control">
                    </div>
                    <div class="col-4 p-5">
                        <h4>Prénom :</h4>
                        <input type="text" name="Prenom" id="Prenom" class="form-control">
                    </div>
                    <div class="col-4 p-5">
                        <h4> Diplôme préparé :</h4>
                        <select name="Diplome" id="Diplome" class="form-control">
                            <option value="default">Selctionner dans la liste</option>
                            <option value="BUT GEA">BUT GEA</option>
                            <option value="BUT Informatique">BUT Informatique</option>
                            <option value="BUT QLIO">BUT QLIO</option>
                            <option value="BUT CJ">BUT CJ</option>
                            <option value="BUT InfoCom">BUT InfoCom</option>
                        </select>
                    </div>
                    <div class="col-12">
                        <h3>Votre question :</h3>
                        <textarea name="Question" id="Question" cols="130" rows="2" class="m-3"></textarea>
                    </div>
                <div class="col-12">
                    <input type="submit" value="Envoyer le Formulaire" class="btn btn-light btn-block">
                </div>
            </form>
        </div>
    </body>
</html>