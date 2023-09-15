package structuredonnees.matrice;
import java.util.ArrayList;
import java.util.Iterator;

public class MatriceCreuse {
	
	private final int NB_COLONNES_DEFAULT = 5;
	
	private final int NB_LIGNES_DEFAULT = 5;
	
	private int ligne;
	
	private int colonne;
	
	private ArrayList<Coefficient> matrice;
	
	/**
	 * Constructeur initialisant par default la matrice 5 lignes par 5 colonnes
	 */
	public MatriceCreuse() throws IllegalArgumentException {
		this.ligne = NB_LIGNES_DEFAULT;
		this.colonne = NB_COLONNES_DEFAULT;
		matrice = new ArrayList<Coefficient>();
	}

	/**
	 * Constructeur de la matrice
	 * @param ligne 
	 * @param colonne
	 */
	public MatriceCreuse(int ligne, int colonne) throws IllegalArgumentException {
		if (ligne < 0 || colonne < 0) {
			throw new IllegalArgumentException("lignes ou colonne invalide");
		}
		this.ligne = ligne;
		this.colonne = colonne;
		matrice = new ArrayList<Coefficient>();
	}
	
	
	/**
	 * renvoie la valeur du coeficient situé a la position (ligne;colonne)
	 * @param ligne
	 * @param colonne
	 * @return
	 */
	public double getValeur(int ligne, int colonne) throws IllegalArgumentException {
		if (ligne > this.ligne || colonne > this.colonne ||
					 ligne < 0 || colonne < 0) {
			throw new IllegalArgumentException("lignes ou colonne invalide");
		}

		for (Coefficient coefficient : matrice) {
			if (coefficient.getLigne() == ligne && coefficient.getColonne() == colonne) {
				return coefficient.getValeur();
			}
		}
		
		return 0;
	}
	
	/**
     * Modifie la valeur d'un coefficent
     * @param numLigne numéro de la ligne du coefficient à modifier
     * @param numColonne numéro de la colonne
     * @param valeur  nouvelle valeur du coefficient
     * @throws IllegalArgumentException  levée si un argument est incohérent
     */
    public void setValeur(int numLigne, int numColonne, double valeur)
                                                    throws IllegalArgumentException {
        
    	if (ligne > this.ligne || colonne > this.colonne ||
    			     ligne < 0 || colonne < 0) {
			throw new IllegalArgumentException("lignes ou colonne invalide");
		}
        
        // TODO : gérer le cas des coordonnées correctes
    	
    	this.matrice.add(new Coefficient(numLigne, numColonne, valeur));
        
       
    }
	
	/**
     * Supprime un coefficient de la liste des coefficients.
     * Si dans la liste des coefficients, il n'y a pas de coefficient situé à la ligne
     * et colonne argument, la méthode est sans effet.
     * De même si les coordonnées argument sont invalides : méthode sans effet
     *  (pas d'exception levée dans ce cas, car méthode privée : ce sont les méthodes 
     *   appelantes qui vérifieront la validité de la ligne et de la colonne)
     * @param numLigne numéro de la ligne du coefficient
     * @param numColonne numéro de la colonne du coefficient
     * @return un booléen égal à vrai ssi la suppression a été effectuée
     */
    private boolean supprimer(int numLigne, int numColonne) {
        int i;      // indice de parcours de la liste des coefficients
        
        // parcours de la liste à la recherche d'un coefficient situé à la position argument
        for (i = 0; i < matrice.size() 
                    && ! matrice.get(i).estSitue(numLigne, numColonne); i++);
        
        if (i < matrice.size()) {
            
            // coefficient trouvé en position i : il faut le supprimer 
            /* TODO : écrire l'instruction pour supprimer le coefficient en position i*/
            
            
            return true;
        } else {
            
            // pas de suppression possible
            return false;
        }
    }

	public static MatriceCreuse multiplication(MatriceCreuse a, MatriceCreuse b) {
		// TODO Auto-generated method stub
		return null;
	}

	

	/**
     * Affiche les coefficients de la liste
     */
    public void afficher() {
    
         
        if (true /* TODO : remplacer true par la condition qui dit que la liste des coefficients est vide */) {
            
            // cas particulier de la matrice nulle
            System.out.println("La matrice est nulle.");
        } else {                           
            
            // parcours de la liste dans le but d'afficher tous les coefficients
            /* TODO : écrire la boucle de parcours de la liste des coefficients
                      bien remarquer que dans la classe Coefficient, il y a une méthode toString */
            
          
        }
    }

	public static MatriceCreuse addition(MatriceCreuse mat1, MatriceCreuse mat2) {
		// TODO Auto-generated method stub
		return null;
	}

	public MatriceCreuse multiplier(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}