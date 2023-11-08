/*
 *  Premier programme de test de la s�rialisation
 *  TestLivreMotCle.java										11/20
 */
package fichier.serialisation.gestionlivre;


/**
 * Test des m�thodes serialiser et restaurer de la classe LivreMotCle
 * 
 * @author INFO2
 * @version 1.0
 */
public class TestLivreMotCle {
	
	
	/** Nom du fichier pour les tests des m�thodes s�rialiser et restaurer */
	private static final String NOM_FICHIER_LIVRE = "fichierlivre.bin";
	
	
	/**
	 * Test de la m�thode serialiser
	 */
	public static void testSerialiser() {
		// Livre que l'on souhaite �crire dans le fichier
        LivreMotCle livre = new LivreMotCle("Apprendre Java", "Expert", 2018);
        livre.ajouteMotCle("programmation");
        livre.ajouteMotCle("POO");
        livre.ajouteMotCle("algorithme");
        livre.ajouteMotCle("Java");
        livre.ajouteMotCle("poo");
        livre.afficher();
                
        // Ecriture de l'instance livre dans le fichier "fichierlivre.bin"
        try {
            livre.serialiser(NOM_FICHIER_LIVRE);
        } catch(LivreMotCle.EchecSerialisationRestauration erreur) {
            System.out.println(erreur.getMessage());
        }
	}
    

	/**
	 * Test de la m�thode restaurer
	 * @throws ClassNotFoundException 
	 */
	 public static void testRestaurer() throws ClassNotFoundException {
		 
	     /*
	      *  lecture du fichier "fichierlivre.bin" pour restaurer l'instance
	      *  pr�alablement �crite
	      */        
	     LivreMotCle livreLu = new LivreMotCle();
	     try {
	         livreLu.restaurer(NOM_FICHIER_LIVRE);
	         System.out.println("Livre lu = \n");
	         livreLu.afficher();
	      } catch(LivreMotCle.EchecSerialisationRestauration erreur) {
	         System.out.println(erreur.getMessage());
	      }
	 }
	
	
	/**
	 * Programme principal
	 * @param args   argument non utilis�
	 * @throws ClassNotFoundException 
	 */
    public static void main(String[] args) throws ClassNotFoundException {
    	testSerialiser();
    	testRestaurer();       
    }

}
