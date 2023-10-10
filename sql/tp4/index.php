<!DOCTYPE html>
<html lang="fr">
  <head>
		<meta charset="utf-8">
		<title>DEMO PDO 1</title>
		
		<!-- Lien vers mon CSS -->
		<link href="src/css/monStyle.css" rel="stylesheet">
		
		<!-- Bootstrap CSS -->
		<link href="src/bootstrap/css/bootstrap.css" rel="stylesheet">
							
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

		try{	// Bloc try bd injoignable ou si erreur SQL
			$pdo=new PDO($dsn,$user,$pass,$options);// Connexion PDO
			$stmt = $pdo->query('SELECT * FROM clients');
			echo "<table>";		
			while ($element = $stmt->fetch()) {
				echo "<tr>";
				echo "<td>".$element["ID_CLIENT"]."</td>";
				echo "<td>".$element["CODE_CLIENT"]."</td>";
				echo "<td>".$element["ID_CLIENT"]."</td>";
				echo "<td>".$element["NOM_MAGASIN"]."</td>";
				echo "<td>".$element["ADRESSE_1"]."</td>";
				echo "<td>".$element["ADRESSE_2"]."</td>";
				echo "<td>".$element["CODE_POSTAL"]."</td>";
				echo "<td>".$element["VILLE"]."</td>";
				echo "<td>".$element["RESPONSABLE"]."</td>";
				echo "<td>".$element["TELEPHONE"]."</td>";
				echo "<td>".$element["EMAIL"]."</td>";
				echo "<td>".$element["TYPE_CLIENT"]."</td>";
				echo "<tr>";
			}		
			echo "</table>";		
		} catch (PDOException $e) {
			//Il y a eu une erreur 
			echo "<h1>Erreur BD ".$e->getMessage();
		}	
        
		
		
	?>
	
  </body>
</html>