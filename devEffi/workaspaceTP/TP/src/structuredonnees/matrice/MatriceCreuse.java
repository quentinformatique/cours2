/*
 * TP Pour apprendre l'utilisation des ArrayList
 * MatriceCreuse.java                                          15/09/2023
 */

import java.util.ArrayList;

package structuredonnees.matrice;

public class MatriceCreuse {

    public ArrayList<Coefficient> listeCoefficients;

    public static final int LONGEUR_DEFAULT = 5;
    public static final int LARGEUR_DEFAULT = 5;

    /** 
     * Constructeur de base pour la matrice creuse
     */
    public MatriceCreuse() {
        this.nbLignes = LONGEUR_DEFAULT;
        this.nbColonnes = LARGEUR_DEFAULT;
        this.listeCoefficients = new ArrayList<Coefficient>();
    }

    /**
     * Constructeur d'une matrice creuse
     * @param nbLignes nombre de lignes de la matrice
     * @param nbColonnes nombre de colonnes de la matrice
     * @throws IllegalArgumentException si le nombre de lignes ou de colonnes est invalide
     */ 
    public MatriceCreuse(int nbLignes, int nbColonnes) throws IllegalArgumentException {
        if (nbLignes <= 0 || nbColonnes <= 0) {
            throw new IllegalArgumentException("Nombre de lignes ou de colonnes invalide");
        } else {
            this.nbLignes = nbLignes;
            this.nbColonnes = nbColonnes;
            this.listeCoefficients = new ArrayList<Coefficient>();
            
        }
    }

    /**
     * Méthode pour récuperer la valeur d'un coefficient
     * @param ligne numéro de la ligne du coefficient
     * @param colonne numéro de la colonne du coefficient
     * @return int valeur la valeur du coefficient
     * @throws IllegalArgumentException si le numéro de ligne ou de colonne est invalide
     */
    public int getValeur(int ligne, int colonne) throws IllegalArgumentException {
        if (ligne < 0 || ligne >= nbLignes || colonne < 0 || colonne >= nbColonnes) {
            throw new IllegalArgumentException("Numéro de ligne ou de colonne invalide");
        } else {
            int valeur = 0;
            for (int i = 0; i < listeCoefficients.size(); i++) {
                if (listeCoefficients.get(i).getLigne() == ligne && listeCoefficients.get(i).getColonne() == colonne) {
                    valeur = listeCoefficients.get(i).getValeur();
                }
            }
            return valeur;
        }
    }

    /**
     * Méthode pour modifier la valeur d'un coefficient
     * @param ligne numéro de la ligne du coefficient
     * @param colonne numéro de la colonne du coefficient
     * @param valeur valeur du coefficient
     * @throws IllegalArgumentException si le numéro de ligne ou de colonne est invalide
     */
    public void setValeur(int ligne, int colonne, int valeur) throws IllegalArgumentException {
        if (ligne < 0 || ligne >= nbLignes || colonne < 0 || colonne >= nbColonnes || valeur == 0) {
            throw new IllegalArgumentException("Un des arguments est invalide");
        } else {
            matrice[ligne][colonne] = valeur;
        }
    }

    public int getLigne() {
        return ligne; // FIXME : c'est n'importe quoi je sais pas ce que je fais
    }

    public int getColonne() {
        return colonne;                      
    }

    public int getNBlignes() {
        return nbLignes;
    }

    public int getNBcolonnes() {
        return nbColonnes;
    }
}