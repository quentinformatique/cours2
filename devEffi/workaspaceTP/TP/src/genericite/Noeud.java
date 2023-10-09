/*
 * Suites de classes pour creer des arbres binaires
 * Noeud.java                              Fait le 02/10/23
 */
package genericite;

/**
 * Classe noeud générique 
 * @author Tom Douaud
 * @version 1.0
 */
public class Noeud<T extends Comparable<T>> {

	/**
	 * Constante égale au nombre d'espaces d'indentation à laisser lors de
	 * l'affichage des différents niveaux de l'arbre
	 */
	private static final int DECALAGE = 5;

    private T valeurNoeud;
    
    private Noeud<T> filsGauche;
    
    private Noeud<T> filsDroit;

    public Noeud(T valeurNoeud) {
        this.valeurNoeud = valeurNoeud;
        this.filsGauche = null;
        this.filsDroit = null;
    }
    
    public boolean inserer(T valeurAInserer) {
		// Vérification que le noeud n'est pas déjà présent
		if (!this.estPresente(valeurAInserer)) {
			// insertion à gauche
			if (valeurAInserer.compareTo(valeurNoeud) < 0) {
				// si le noeud n'a pas de fils gauche, on l'insère
				if (filsGauche == null) {
					filsGauche = new Noeud<T>(valeurAInserer);
					return true;
				// sinon on descend dans l'arbre a gauche
				} else {
					return filsGauche.inserer(valeurAInserer);
				}
			// insertion à droite
			} else if (valeurAInserer.compareTo(valeurNoeud) > 0) {
				// si le noeud n'a pas de fils droit, on l'insère
				if (filsDroit == null) {
					filsDroit = new Noeud<T>(valeurAInserer);
					return true;
				// sinon on descend dans l'arbre a droite
				} else {
					return filsDroit.inserer(valeurAInserer);
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
    }
    
    public boolean estPresente(T valeurTest) {
		// test du noeud courant
		if (valeurNoeud.compareTo(valeurTest) == 0) {
			return true;
		// test du fils gauche
		} else if(valeurNoeud.compareTo(valeurTest) > 0) {
			if (filsGauche == null) {
				return false;
			} else {
				return filsGauche.estPresente(valeurTest);
			}
		// test du fils droit
		} else if(valeurNoeud.compareTo(valeurTest) < 0) {
			if (filsDroit == null) {
				return false;
			} else {
				return filsDroit.estPresente(valeurTest);
			}
		// le noeud n'est pas present
		} else {
			return false;
		}
    }

	// Les asseseurs
	public T getValeurNoeud() {
		return valeurNoeud;
	}

	public Noeud<T> getFilsGauche() {
		return filsGauche;
	}

	public Noeud<T> getFilsDroit() {
		return filsDroit;
	}

	// Les accesseurs en écriture
	public void setValeurNoeud(T valeurNoeud) {
		this.valeurNoeud = valeurNoeud;
	}

	public void setFilsGauche(Noeud<T> filsGauche) {
		this.filsGauche = filsGauche;
	}

	public void setFilsDroit(Noeud<T> filsDroit) {
		this.filsDroit = filsDroit;
	}

	/**
	 * Affiche les valeurs contenues dans l'arbre débutant au noeud argument
	 * Chaque fois que l'on descend d'un niveau dans l'arbre, les valeurs des
	 * noeuds sont affichées (en colonne) à droite des précédentes.
	 * @param niveau niveau de profondeur du noeud courant. Cette valeur sert à calculer
	 * sur quelle colonne il faut effectuer l'affichage
	 */
	public void afficheArbreNiveau(int niveau) {

		/*
		* on affiche d'abord le sous-arbre gauche, avec un niveau de
		* profondeur égal à niveau+1
		*/
		if (filsGauche != null) {
			System.out.print(filsGauche.getValeurNoeud());
			filsGauche.afficheArbreNiveau(niveau + 1);
		}
	
	
		// on laisse des espaces avant d'afficher le noeud courant
		for (int i = 0; i < niveau * DECALAGE; i++) {
			System.out.print(" ");
		}
	
		/*
		* on affiche ensuite le sous-arbre droit, avec un niveau de
		* profondeur égal à niveau+1
		*/
		if (filsDroit != null) {
			filsDroit.afficheArbreNiveau(niveau + 1);
		}

	}
	
	public String parcourPrefixe() {
		return new StringBuilder(valeurNoeud.toString()).append("  ")
				.append(filsGauche == null ? "" : filsGauche.parcourPrefixe())
				.append(filsDroit == null ? "" : filsDroit.parcourPrefixe()).toString();
	}
	
	public String parcourInfixe() {
		return ""; // STUB
	}
	
	public String parcourPostfixe() {
		return ""; // STUB
	}
   
}