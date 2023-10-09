/*
 * Suites de classes pour creer des arbres binaires
 * ArbreBinaire.java                              Fait le 02/10/23
 */
package genericite;

/**
 * Classe ArbreBinaire composant générique 
 * @author Tom Douaud
 * @version 1.0
 */
public class ArbreBinaire<T extends Comparable<T>> {

    public Noeud<T> racine;

    public Noeud<T>[] listNoeuds;

    public ArbreBinaire() {
        racine = null;
    }


    /**
     * Détermine si la valeur argument est présente dans l'arbre binaire
     * @param aChercher valeur à rechercher dans l'arbre
     * @return un booléen égal à vrai ssi la valeur est présente dans l'arbre
     */
    public boolean estPresente(T aChercher) {
        if (racine == null) {
            // l'arbre est vide : la valeur n'est pas présente
            return false;
        }

        // sinon : recherche à partir du noeud racine
        return racine.estPresente(aChercher);
    }

    public boolean inserer(T valeurAInserer) {
        if (racine == null) {
            // l'arbre est vide : on insère la valeur à la racine
            racine = new Noeud<T>(valeurAInserer);
            return true;
        } else {
            // sinon : insertion à partir du noeud racine
            return racine.inserer(valeurAInserer);
        }
    }

    public void afficheArbreNiveau() {
        if (racine == null) {
            System.out.println("Arbre vide");
        } else {
            racine.afficheArbreNiveau(0);
        }
    }


	public String parcoursPrefixe() {
		// TODO Auto-generated method stub
		return racine.parcourPrefixe();
	}


	public String parcoursPostfixe() {
		// TODO Auto-generated method stub
		return null;
	}


	public String parcoursInfixe() {
		// TODO Auto-generated method stub
		return null;
	}

}