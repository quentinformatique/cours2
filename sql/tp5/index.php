<!DOCTYPE html>
<html lang="fr">
	  <head>
		<meta charset="utf-8">
		<title>TP 5 SQL dans un langage de programmation PDO</title>
		
		<!-- Bootstrap CSS -->
		<link href="src/bootstrap/css/bootstrap.css" rel="stylesheet">
		
		<!-- Lien vers mon CSS -->
		<link href="src/css/TP5-PDO.css" rel="stylesheet">					
   </head>

	<body>
		<?php
			$host='localhost';	// Serveur de BD
			$db='mezabi3';		// Nom de la BD
			$user='root';		// User 
			$pass='root';		// Mot de passe
			$charset='utf8mb4';	// charset utilisé
			
			// Constitution variable DSN
			$dsn="mysql:host=$host;dbname=$db;charset=$charset";

			$options=[																				 
				PDO::ATTR_ERRMODE=>PDO::ERRMODE_EXCEPTION,
				PDO::ATTR_DEFAULT_FETCH_MODE=>PDO::FETCH_ASSOC,
				PDO::ATTR_EMULATE_PREPARES=>false];	 
		?>
		<div class="container">
			<div class="col-12  cadre">		
			<h1>Formulaire d'inscription</h1><br>				
				<form method="post" action="index.php">
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="codeClient">Code Client : </label>
							<input type="text" name="codeClient" placeholder="Code client (maximum 15 caractères)" class="form-control" value=""> 
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-12">
							<label for="nomMagasin">Nom magasin : </label>
							<input type="text" name="nomMagasin" placeholder="Nom du magasin (maximum 35 caractères)" class="form-control" value=""> 
						</div>
						<div class="form-group col-md-12">
							<label for="responsable">Nom du Responsable : </label>
							<input type="text" name="responsable" placeholder="Nom du responsable (maximum 35 caractères)" class="form-control" value="">
						</div>
						<div class="form-group col-md-12">
							<label for="adresse1">Adresse ligne 1 : </label>
							<input type="text" name="adresse1" placeholder="Ligne d'adresse 1 (maximum 35 caractères)" class="form-control" value=""> 
						</div>
						<div class="form-group col-md-12">
							<label for="adresse2">Adresse ligne 2 : </label>
							<input type="text" name="adresse2" placeholder="Ligne d'adresse 2 (maximum 35 caractères)" class="form-control" value=""> 
						</div>
					</div>
					
					<div class="form-row">
						<div class="form-group col-md-2">
						  <label for="cdp">Code postal :</label>
						  <input type="text" name="cdp" placeholder="5 chiffres (Obligatoire)" class="form-control" value="">
						</div>
						<div class="form-group col-md-10">
							<label for="ville">Ville : </label>
							<input type="text" name="ville" placeholder="Taper votre bureau distributeur (maximum 35 caractères)" class="form-control" value="">
						</div>
					</div>
					
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="categorie">Catégorie : </label>
							<select name="categorie"  class="form-control">
								<option value="0">Choisir dans la liste</option>
								<?php
									try{
										// Connexion à la BD
										$pdo=new PDO($dsn,$user,$pass,$options);// Connexion PDO
										$stmt = $pdo->query('SELECT * FROM c_types');
										while ($element = $stmt->fetch()) {
											// Affichage des catégories
											echo '<option value="'.$element['CODE_TYPE'].'">'.$element['DESIGNATION'].'</option>';
										}
											
									} catch (PDOException $e) {
										//Il y a eu une erreur 
										echo "<h3>Erreur de connexion a la base de donées, veuillez réessayer plus tard </h3>";
									}								
								?>
							</select>
						</div>
						<div class="form-group col-md-3">
						  <label for="noTel">Numéro de téléphone :</label>
						  <input type="text" name="noTel" placeholder="Format 0565656565" class="form-control" value="">
						</div>
						<div class="form-group col-md-3">
							<label for="mail">Adresse Mail : </label>
							<input type="text" name="mail" placeholder="Taper votre adresse E-mail" class="form-control" value="">
						</div>
					</div>
					<button type="submit" class="btn btn-primary btn-block">Valider le formulaire</button>
					<br>
				</form>
			</div>
		</div>
	</body>
</html>