/*
 * Classe qui repr�sente un libre auquel des mots-cl�s sont associ�s
 * LivreMotCle.java                                                 11/20
 */

package fichier.serialisation.gestionlivre;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.* ;

/**
 * Cette classe repr�sente un livre d�crit par un titre, un auteur, une ann�e
 * de parution et une liste de mots-cl�s
 * @author INFO2
 * @version 1.0
 */
public class LivreMotCle extends Livre  {
 

    
    /**
     * Exception lev�e si probl�me d'acc�s au fichier lors de la 
     * s�rialisation ou restauration d'une instance de type LivreMotCle
     */
    public static class EchecSerialisationRestauration extends Exception {
        
        /**
         * Constructeur avec en argument un message d�crivant l'erreur
         * @param message  un texte expliquant la cause pr�cise de l'erreur
         */
        public EchecSerialisationRestauration(String message) {
            super(message);
        }
    }
    
    /**
     * Liste des mots-cl�s associ�s au livre
     */
    private ArrayList<String>	lesMotsCles ;     


    /**
     * Constructeur par d�faut : la liste des mots-cl�s est vide
     */
    public LivreMotCle() {
        lesMotsCles = new ArrayList<>() ;  
    }

    /**
     * Constructeur avec argument pour initialiser le titre, l'auteur et
     * l'ann�e de parution du livre. La liste des mots-cl�s sera vide
     * @param leTitre   le titre du livre
     * @param lAuteur	l'auteur du livre
     * @param anneeParution l'ann�e de parution du livre
     */
     public LivreMotCle(String leTitre, String lAuteur, int anneeParution) {
         super(leTitre, lAuteur, anneeParution);
         lesMotsCles = new ArrayList<>() ;
     }

     /**
      * Renvoie les mots-cl�s
      * @return une cha�ne de caract�res contenant les mot-cl�s
      */

    public String getMotsCles ( ) {
        // cha�ne qui contiendra les mots-cl�s
        StringBuilder resultat = new StringBuilder() ;
        
        for(String mot : lesMotsCles) {
            resultat.append(mot).append("  | ");
        }
        
        // on renvoie la cha�ne contenant les mots-cl�s
        return resultat.toString() ;
    }

    /**
     * Affiche toutes les informations connues sur le livre
     */
    public void afficher ( ) {
        System.out.println(super.toString() + "\n" + getMotsCles()) ;
    }

    /**
     * D�termine si le mot-cl� argument fait partie de ceux du livre
     * (pas de distinction entre minuscule et majuscule)
     * @param mot  mot � rechercher dans la liste des mots-cl�s
     * @return un bool�en �gal � vrai ssi le mot-cl� figure dans la liste
     */
    public boolean aLeMotCle(String mot) {
        int i;          // indice de parcours de la liste des mots-cl�s
        for(i = 0; i < lesMotsCles.size() 
                   && ! mot.equalsIgnoreCase(lesMotsCles.get(i)); i++);
        return i < lesMotsCles.size()  ;
    }

    /**
     * Ajoute le mot-cl� argument s'il n'est pas d�j� pr�sent
     * @param mot	le mot-cl� � ajouter
     * @return un bool�en �gal � vrai ssi le mot-cl� a pu �tre ajout�
     */
     public boolean ajouteMotCle(String mot) {
        if (aLeMotCle(mot)) { // le mot-cl� est d�jà pr�sent
            return false ;
        }
        
        // sinon on ajoute le mot-cl� en fin de liste
        lesMotsCles.add(mot) ;
        return true ;	// ajout possible
     }
     
     
}
