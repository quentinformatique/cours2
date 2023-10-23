<!DOCTYPE html>
<html lang="fr">
  <head>
		<meta charset="utf-8">
		<title>DEMO PDO 1</title>
		
		
		<!-- Bootstrap CSS -->
		<link href="src/bootstrap/css/bootstrap.css" rel="stylesheet">
		<!-- Lien vers mon CSS -->
		<link href="src/css/monStyle.css" rel="stylesheet">
							
   </head>

  <body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<h1>Etape 1</h1>
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
	
					try{
						$pdo=new PDO($dsn,$user,$pass,$options);// Connexion PDO
						$stmt = $pdo->query('SELECT * FROM clients');
						echo "<table class='table table-striped'>";		
						// affichage de l'entête du tableau
						echo "<tr>";
						echo "<th>ID</th>"."<th>Code client</th>"."<th>Nom du magasin</th>"."<th>Adresse 1</th>"."<th>Adresse 2</th>"."<th>Code postal  / ville</th>"."<th>Telephone</th>"."<th>adresse mail</th>";
						echo "</tr>";
						$i = 0;
						while ($element = $stmt->fetch()) {
							echo "<tr>";
							echo "<td>".$element["ID_CLIENT"]."</td>";
							echo "<td>".$element["CODE_CLIENT"]."</td>";
							echo "<td>".$element["NOM_MAGASIN"]."</td>";
							echo "<td>".$element["ADRESSE_1"]."</td>";
							echo "<td>".$element["ADRESSE_2"]."</td>";
							echo "<td>".$element["CODE_POSTAL"];
							echo " ".$element["VILLE"]."</td>";
							echo "<td>".$element["TELEPHONE"]."</td>";
							echo "<td>".$element["EMAIL"]."</td>";
							echo "</tr>";
							$i++;
						}		
						echo "</table>";		
					} catch (PDOException $e) {
						//Il y a eu une erreur 
						echo "<h3>Erreur de connexion a la base de donées, veuillez réessayer plus tard </h3>";
					}	
						?>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<h1>Etape 2</h1>
			</div>
			<?php
			try{	
				$pdo=new PDO($dsn,$user,$pass,$options);// Connexion PDO
				$stmt = $pdo->query('SELECT * FROM clients');
				while ($element = $stmt->fetch()) {
					echo "<div class='col-12 col-md-4 col-sm-6'>";
					echo "<div class='cadre'>";
					echo "<span class='enGras'>Id: </span>".$element["ID_CLIENT"]."<br>";
					echo "<span class='enGras'>Code client: </span>".$element["CODE_CLIENT"]."<br>";
					echo "<span class='enGras'>Nom du magasin: </span>".$element["NOM_MAGASIN"]."<br>";
					echo "<span class='enGras'>Adresse 1: </span>".$element["ADRESSE_1"]."<br>";
					echo "<span class='enGras'>Adresse 2: </span>".$element["ADRESSE_2"]."<br>";
					echo "<span class='enGras'>Code posta / ville : </span>".$element["CODE_POSTAL"]." ".$element["VILLE"]."<br>";
					echo "<span class='enGras'>Telephone: </span>".$element["TELEPHONE"]."<br>";
					echo "<span class='enGras'>Email: </span>".$element["EMAIL"]."<br>";
					echo "</div>";
					echo "</div>";
					
				}				
			} catch (PDOException $e) {
				//Il y a eu une erreur 
				echo "<h3>Erreur de connexion a la base de donées, veuillez réessayer plus tard </h3>";
			}
			?>
		</div>
	</div>
	
	
  </body>
</html>