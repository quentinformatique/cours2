-- Etape 1
-- Création table histo_modifs_clients qui enregistrera les Création / Modification / Suppressions clients
DELIMITER //
DROP table IF EXISTS histo_modifs_clients//

CREATE TABLE if not exists histo_modifs_clients (
  ID int(11) NOT NULL AUTO_INCREMENT,
  MODE CHAR(1) NOT NULL, 
  ID_CLIENT int(11) NOT NULL ,
  NOM_COLONNE varchar(12) NOT NULL, 
  ANCIENNE_VALEUR varchar(35) ,
  NOUVELLE_VALEUR varchar(35) , 
  LADATE date NOT NULL, 
  LHEURE time NOT NULL,
  UTILISATEUR varchar(35),
  Primary key (ID)
) //

DELIMITER ;
INSERT INTO clients (CODE_CLIENT,NOM_MAGASIN,ADRESSE_1,ADRESSE_2,CODE_POSTAL,VILLE,RESPONSABLE,TELEPHONE,EMAIL,TYPE_CLIENT) VALUES
('PNY', 'La boutique de Jo', 'Rue des fleurs', 'Lieu Dit les Carcasses', '48200', 'MENDE', 'M. Jo Zéphine', '0000000000', 'zephine@orange.fr', 3);

-- Etape 2
DELIMITER //
DROP trigger IF EXISTS testnum//

CREATE TRIGGER testnum AFTER UPDATE ON clients
FOR EACH ROW
BEGIN
  IF OLD.TELEPHONE != NEW.TELEPHONE THEN
    INSERT INTO histo_modifs_clients (MODE, ID_CLIENT, NOM_COLONNE, ANCIENNE_VALEUR, NOUVELLE_VALEUR, LADATE, LHEURE, UTILISATEUR)
    VALUES ("M", OLD.ID_CLIENT, "telephone", OLD.TELEPHONE, NEW.TELEPHONE, CURDATE(), CURTIME(), CURRENT_USER());
  END IF;
 END //

 DELIMITER ;

-- Etape 3 Créer un trigger nommé 'histo_clients_S' qui se déclenchera lors de la suppression d'un
-- client et qui enregistrera dans la table d'historique, le numéro de téléphone avant la suppression.

DELIMITER //
DROP TRIGGER IF EXISTS histo_clients_S//

CREATE TRIGGER histo_clients_S
BEFORE DELETE ON clients
FOR EACH ROW
BEGIN
  INSERT INTO histo_modifs_clients (MODE, ID_CLIENT, NOM_COLONNE, ANCIENNE_VALEUR, NOUVELLE_VALEUR, LADATE, LHEURE, UTILISATEUR)
  VALUES ("S", OLD.ID_CLIENT, "telephone", OLD.TELEPHONE, NULL, CURDATE(), CURTIME(), CURRENT_USER());
END //

DELIMITER ;

-- Etape 4 Créer un trigger nommé 'histo_clients_C' qui se déclenchera lors de la création d'un client
-- et qui enregistrera dans la table d'historique, le numéro de téléphone du client créé.
