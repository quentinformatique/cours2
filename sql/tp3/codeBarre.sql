DELIMITER //
DROP function IF EXISTS generate_barcode //
CREATE FUNCTION generate_barcode() RETURNS VARCHAR(13)
BEGIN
    DECLARE debut VARCHAR(7);
    DECLARE code_produit VARCHAR(5);
    DECLARE cle_controle INT;
    DECLARE barcode VARCHAR(13);

    -- récupération du code pays et du code fabricant dans la table paramètres
    SELECT CONTENU_A INTO debut
    FROM parametres
    WHERE ID = 'DEB_GENCODE';

    -- mise à jour du dernier code produit utilisé
    UPDATE parametres
    SET CONTENU_N = CONTENU_N + 1
    WHERE ID = 'LAST_GENCODE';

    -- récupération du dernier code produit utilise
    SELECT CONTENU_N INTO code_produit
    FROM parametres
    WHERE ID = 'LAST_GENCODE';

    -- si le code est null, on met 0
    IF code_produit IS NULL THEN
        SET code_produit = 0;
    END IF;

    SET code_produit = RIGHT(CONCAT('00000', code_produit), 5);

    SET barcode = CONCAT(debut, code_produit);

    -- calcul de la clé de contrôle
    -- on fais la somme de tous les chiffres impairs
    SET cle_controle = (SUBSTRING(barcode, 1, 1) + SUBSTRING(barcode, 3, 1) + SUBSTRING(barcode, 5, 1)
                      + SUBSTRING(barcode, 7, 1) + SUBSTRING(barcode, 9, 1) + SUBSTRING(barcode, 11, 1)) * 3;
    -- on additionne a cela la somme de tous les chiffres pairs
    SET cle_controle = cle_controle + (SUBSTRING(barcode, 2, 1) + SUBSTRING(barcode, 4, 1) + SUBSTRING(barcode, 6, 1)
                                    + SUBSTRING(barcode, 8, 1) + SUBSTRING(barcode, 10, 1) + SUBSTRING(barcode, 12, 1));
    -- soustraire le resultat au multiple de 10 immédiatement supérieur
    IF cle_controle % 10 = 0 THEN
        SET cle_controle = 0;
    ELSE
        SET cle_controle = 10 - (cle_controle % 10);
    END IF;

    -- contruction code barre
    SET barcode = CONCAT(barcode, cle_controle);

    RETURN barcode;
END; //
DELIMITER ;
SELECT generate_barcode();