<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>tp3</title>
    <link rel="stylesheet" href="src/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="src/css/TP3.css">
</head>
<body>
    <div class="container">
        <form action="src/php/P1.php"></form>
        <div class="row">
            <div class="col-12">
                <h1>Formulaire</h1>
            </div>
            <div class="col-4">
                <div class="title">Nom :</div>
                <input type="text" name="nom">
            </div>
            <div class="col-4">
                <div class="title">Prenom :</div>
                <input type="text" name="nom">
            </div>
            <div class="col-4">
                <div class="title">Diplome préparé :</div>
                <select name="diplome">
                    <option value="">--Sélectionnez dans la liste--</option>
                    <option value="GEA">BUT GEA</option>
                    <option value="Informatique">BUT Informatique</option>
                    <option value="QLIO">BUT QLIO</option>
                    <option value="CJ">BUT CJ</option>
                    <option value="InfoCom">BU InfoCom</option>
                </select>

            </div>
            <div class="col-12">
                <div class="title">Votre question :</div>
                <textarea name="question" cols="120" rows="1"></textarea>
            </div>
            <div class="col-12">
                <input type="submit" value="Envoyer le formulaire">
            </div>
        </div>
    </div>
</body>
</html>