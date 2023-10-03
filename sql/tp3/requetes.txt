DELIMITER //
DROP function IF EXISTS facture //
CREATE function facture(ID_CLIENT INT) RETURNS INT
BEGIN
    DECLARE dateActuelleAnneMois INT;
    DECLARE derniereFacture INT;
    DECLARE numFacture INT;
    
    SET dateActuelleAnneMois = (SELECT DATE_FORMAT(CURDATE(), "%Y%m"));
    SET derniereFacture = (SELECT MAX(NO_FCT)
			   FROM factures_entetes
			   WHERE DATE_FORMAT(DATE_FCT, "%Y%m") 
                                 = dateActuelleAnneMois); 
                                
    SET numFacture = IF (derniereFacture IS NULL,
        		 dateActuelleAnneMois * 1000 + 1,
        	         derniereFacture + 1);  
                         
    INSERT INTO factures_entetes (`NO_FCT`, `CLIENT`, `DATE_FCT`) VALUES
    (numFacture, ID_CLIENT, CURDATE());

    RETURN numFacture;
END; //

SELECT facture(1)//
