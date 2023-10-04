<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8" />
		<title>TP3</title>
		<meta name="Description" content="Ma Page De Formulaire">
		<meta name="Keywords" content="IUT, Rodez">
		<link rel="stylesheet" href="./TP3.css"/>
		<link rel='stylesheet' href='./bootstrap-4.6.2-dist/css/bootstrap.css'>
	</head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h1>Formulaire</h1>
                </div>
                <div class="col-4">
                    <h1>Nom :</h1>
                    <input type="text" name="Nom" id="Nom"class="form-control">
                </div>
                <div class="col-4">
                    <h1>Prénom :</h1>
                    <input type="text" name="Prenom" id="Prenom" class="form-control">
                </div>
                <div class="col-4">
                    <h1> Diplôme préparé :</h1>
                    <input list="Diplome" class="form-control">

                    <datalist id="Diplome">
                        <option value="Sélectionner dans la liste"></option>
                        <option value="BUT GEA"></option>
                        <option value="BUT Informatique"></option>
                        <option value="BUT QLIO"></option>
                        <option value="BUT CJ"></option>
                        <option value="BUT InfoCom"></option>
                    </datalist>
                </div>
                <div class="col-12">
                    <h1>Votre question :</h1>
                    <textarea name="Question" id="Question" cols="130" rows="2"></textarea>
                </div>
            <div class="col-12">
                <button type="button" class="btn btn-light btn-block">Envoyer votre formulaire</button>
            </div>
        </div>
    </body>
</html>