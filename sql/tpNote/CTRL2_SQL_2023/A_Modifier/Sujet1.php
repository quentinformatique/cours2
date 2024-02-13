<?php 
	
	$laBD_POST="";
	if (isset($_POST['laBD'])) $laBD_POST=$_POST['laBD'];
	
	$laTable_POST="";
	if (isset($_POST['laTable'])) $laTable_POST=$_POST['laTable'];
	
	if (isset($_POST['RAZ'])) {
		$laBD_POST="";
		$laTable_POST="";
	}
	
	function ConnecteBD() {
		// Fonction permettant de se connecter à la base de données
		$serveur = 'localhost'; // Adresse du serveur de base de données
		$login = 'root'; // Nom d'utilisateur de la base de données
		$pwd = 'root'; // Mot de passe de la base de données
		$nomBD = 'mezabi3'; // Nom de la base de données
		
		// connexion à la BD
		try{ // Bloc try bd injoignable			
			$connexion = new PDO('mysql:host='.$serveur.';dbname='.$nomBD, $login, $pwd);
			$connexion->exec('SET NAMES utf8'); // Réglage de la connexion en utf8
			return $connexion ;
		}catch ( Exception $e ) {
			throw new Exception('Pbme ConnecteBD.<br>'.$e->getMessage());
		} 	
	}
	
	function listeBD($pdo){
		// Fonction  : 
		// Retourne la liste des BD du serveur dans un tableau
		/////////////////////////////////////////////////////////////////////////////
		// Paramètres : 
		// $pdo -> Connexion à la base de données
		/////////////////////////////////////////////////////////////////////////////
		// Utiliser la table INFORMATION_SCHEMA.TABLES pour récuperer la liste des bases de données du serveur
		// Colonne "TABLE_SCHEMA"

		
		
		// Début Code à écrire
		// Requête pour récupérer les bases de données
		$requete = "SELECT DISTINCT(TABLE_SCHEMA) FROM INFORMATION_SCHEMA.TABLES";
		$statement = $pdo->query($requete);
		$lesBD = [];
		// Boucle pour récupérer les bases de données
		while ($ligne = $statement->fetch(PDO::FETCH_ASSOC)) {
			$lesBD[] = $ligne['TABLE_SCHEMA'];
		}
		return $lesBD;

										
		
		// Fin Code à écrire
	}
	
	function listeTables($pdo, $laBD_POST){
		// Fonction  : 
		// Retourne la liste des tables de la BD dans un tableau 
		/////////////////////////////////////////////////////////////////////////////
		// Paramètres : 
		// $pdo -> Connexion à la base de données
		// $$laBD_POST -> Nom de la base de données dont on veut lister les tables
		/////////////////////////////////////////////////////////////////////////////
		// Utiliser la table INFORMATION_SCHEMA.TABLES pour récuperer la liste des tables de la base de données envoyée en paramètre
		// Colonne "TABLE_NAME"
		// *************************************************************************
		// Ne pas utiliser de requête préparée pour le nom de la base de données
		// passé en paramètre, cela ne marchera pas. Cela fonctionne uniquement dans le where
		// *******************************************************************************
		
		// Début Code à écrire

		// Requête pour récupérer les tables de la base de données
		$requete = "SELECT DISTINCT(TABLE_NAME) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = '$laBD_POST'";
		$statement = $pdo->query($requete);
		$lesTables = [];
		// Boucle pour récupérer les tables de la base de données
		while ($ligne = $statement->fetch(PDO::FETCH_ASSOC)) {
			$lesTables[] = $ligne['TABLE_NAME'];
		}
		return $lesTables;
		
		
		// Fin Code à écrire
	}
	
	function afficheContenuTableXML($pdo, $laBD, $laTable) {
		// Fonction  : 
		// 	 - 	Retourne une chaine de caracères contenant 
		// 		la représentation des données de la table sous forme XML
		//		Cette chaine de caractère sera affichée par le programme principal
		//	 - 	Ecrit le contenu généré dans le répertoire "fichiersGeneres"
		//		Nom de fichier : NomBD-NomTable.xml
		//		file_put_contents("CheminEtNomDuFichier", $monContenuEnTexte);
		//		$maVariable=mb_convert_encoding($maVariable, 'UTF-8') converti en UTF8 une chaine de caractères
		/////////////////////////////////////////////////////////////////////////////
		// Paramètres : 
		// $pdo -> Connexion à la base de données
		// $laBD -> La base de données dans laquelle se trouve la table
		// $laTable -> La table pour laquelle on veut générer du XML 
		/////////////////////////////////////////////////////////////////////////////
		// Utiliser la table INFORMATION_SCHEMA.COLUMNS pour récuperer la liste des colonnes 
		// de la BD et de la table envoyée en paramètre (TABLE_SCHEMA et TABLE_NAME)
		// Colonne "COLUMN_NAME" pour avoir le nom des colonnes
		/////////////////////////////////////////////////////////////////////////////
		// Rappel : <br> pour avoir un saut de ligne en HTML, 
		//			\n pour avoir un saut de ligne dans un fichier texte
		/////////////////////////////////////////////////////////////////////////////
		// Il est possible d'interroger une table située dans une autre base de données
		// que celle sur laquelle nous somme connecté en préfixant la table par la base de données
		// exemple : select * from MonAutreBD.LaTableAInterroger
		/////////////////////////////////////////////////////////////////////////////
		// *************************************************************************
		// Ne pas utiliser de requête préparée pour le nom de la table
		// passé en paramètre, cela ne marchera pas. Cela fonctionne uniquement dans le where
		// *******************************************************************************
		/////////////////////////////////////////////////////////////////////////////
		
		$variableRetour="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
		// Début Code à écrire
		
		$colonnes = [];
		$donnees = [];
		// Requête pour récupérer les colonnes de la table
		$requete = "SELECT DISTINCT(COLUMN_NAME) FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = '$laBD' AND TABLE_NAME = '$laTable'";
		$statement = $pdo->query($requete);
		// Boucle pour récupérer les colonnes de la table
		while ($ligne = $statement->fetch(PDO::FETCH_ASSOC)) {
			$colonnes[] = $ligne['COLUMN_NAME'];
		}

		// Requête pour récupérer les données de la table
		$requete = "SELECT * FROM $laBD.$laTable";
		$statement = $pdo->query($requete);
		// Boucle pour récupérer les données de la table
		while ($ligne = $statement->fetch(PDO::FETCH_ASSOC)) {
			$donnees[] = $ligne;
		}

		// Ecriture du fichier XML et de la variable de retour
		$variableRetour .= "<items>";
		$a_afficher = "&lt;?xml version=\"1.0\" encoding=\"UTF-8\"?&gt;</br>\n";
		$a_afficher .= "&lt;items&gt;<br>\n";
		foreach ($donnees as $donnee) {
			$variableRetour .= "<item>";
			$a_afficher .= "&nbsp;&nbsp;&nbsp;&nbsp;&lt;item&gt;";
			foreach ($colonnes as $colonne) {
				$variableRetour .= "<$colonne>$donnee[$colonne]</$colonne>";
				$a_afficher .= "&lt;$colonne&gt;$donnee[$colonne]&lt;/$colonne&gt;";
			}
			$variableRetour .= "</item>\n";
			$a_afficher .= "&nbsp;&nbsp;&nbsp;&nbsp;&lt;/item&gt;<br>";
		}
		$variableRetour .= "</items>";
		$a_afficher .= "&lt;/items&gt;";
		
		// Ecriture du fichier XML
		$nomFichier = "../fichiersGeneres/$laBD-$laTable.xml";
		file_put_contents($nomFichier, $variableRetour);
		
		// affichage du lien de téléchargement
		$a_afficher .= "</br><a href='$nomFichier' download>Télécharger le fichier XML</a>";

		return $a_afficher;

		// Fin Code à écrire
	}
	
	
?>

<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8">
		<title>Epreuve SQL dans un langage de programmation - CTRL 2-Machine</title>
		
		<!-- Lien vers mon CSS -->
		<link href="../css/monStyle.css" rel="stylesheet">
		
		<!-- Bootstrap CSS -->
		<link href="../bootstrap-4.6.2-dist/css/bootstrap.css" rel="stylesheet">
		
	</head>

  <body>
  
	<?php 
		try{	
			$pdo=ConnecteBD();
			?>
			<div class='container'>
				<div class='row'>
					<div class='col-12'>
						<h1>Consultation de tables</h1>
					</div>
				</div>
				<div class='row'>
					<div class='col-6'>
						<form method="post" id="FormBD">
							<label for="laBD">Base de données : </label>
							<select name='laBD' id='laBD' class="form-control">
								<option value="">Sélectionner une base de données</option>
								<?php 
								$laListeBD=listeBD($pdo);
								foreach($laListeBD as $laBD) {
									echo "<option value='".$laBD."'";
									if ($laBD==$laBD_POST) echo " selected";
									echo ">".$laBD."</option>";
								}
								?>
							</select>
						</form>
					</div>
					<div class='col-6'>
						<?php 
						if ($laBD_POST!="") {
							?>
							<form method="post" id="FormTable">
								<label for="laTable">Table : </label>
								<select name='laTable' id='laTable' class="form-control">
									<option value="">Sélectionner une table</option>
									<?php 
									$laListeDesTables=listeTables($pdo,$laBD_POST);
									foreach($laListeDesTables as $laTable) {
										echo "<option value='".$laTable."'";
										if ($laTable==$laTable_POST) echo " selected";
										echo ">".$laTable."</option>";
									}
									?>
								</select>
								<input type="hidden" name="laBD" value="<?=$laBD_POST?>">
							</form>
						<?php } ?>
					</div>
				</div>

				<?php 
					if ($laBD_POST!="" and $laTable_POST!="") {
						// Gestion XML //
						echo '<div class="row"><div class="col-12">';
						echo "<h1>Résultat XML (à réaliser)</h1>";
						$maVariable=afficheContenuTableXML($pdo, $laBD_POST, $laTable_POST);
						echo $maVariable;
						echo "</div></div>";
					}
				?>
			</div>
			<?php 
						
		} catch (Exception $e) {
			echo "<div class='container'><div class='row'><div class='col-12'>";
			echo "<h1>Erreur : " . $e->getMessage()."</h1>";
			echo "</div></div></div>";
		}
	
	?>
	<script src="../js/jquery-3.4.1.js"></script>
    <script src="../js/javascript.js"></script>
  </body>
</html>