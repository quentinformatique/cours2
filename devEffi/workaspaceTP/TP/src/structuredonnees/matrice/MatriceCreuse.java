<<<<<<< Updated upstream
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
=======
package structuredonnees.matrice;

import java.util.ArrayList;

/**
 * MatriceCreuse
 * permet de creer une matrice creuse
 * et de faire des operations sur les matrices creuses
 */
public class MatriceCreuse {
    
    private ArrayList<Coefficient> listeCoefficients;

    private static final int LONGEUR_DEFAULT = 5;

    private static final int LARGEUR_DEFAULT = 5;

    private int nbLignes;
    
    private int nbColonnes;

    /**
     * Constructeur
     */
    public MatriceCreuse() {
        this.nbLignes = this.LONGEUR_DEFAULT;
        this.nbColonnes = this.LARGEUR_DEFAULT;
        this.listeCoefficients = new ArrayList<>();
    }

    /**
     * Constructeur
     * @param nbLignes
     * @param nbColonnes
     * @throws IllegalArgumentException
     */
    public MatriceCreuse(int nbLignes, int nbColonnes) throws IllegalArgumentException {
        if (nbLignes < 0 || nbColonnes < 0) {
            throw new IllegalArgumentException("Nombre de lignes ou de colonnes invalide");
        }
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.listeCoefficients = new ArrayList<>();
    }

    /**
     * setValeur 
     * @param ligne
     * @param colonne
     * @param valeur
     * @throws IllegalArgumentException
     */
    public void setValeur(int ligne, int colonne, double valeur) throws IllegalArgumentException {
        if (ligne <= 0 || ligne > this.nbLignes || colonne <= 0 || colonne > this.nbColonnes) {
            throw new IllegalArgumentException("Numéro de valeur,  de ligne ou de colonne invalide \nigne utilistateur : " + ligne 
                                                + "  | Lignes possibles : 0-" + this.nbLignes + "\nColonne utilistateur : " + colonne 
                                                + "  | Colones possibles : 0-" + this.nbColonnes + "\nValeur utilisateur : " + valeur 
                                                + "  | Valeurs possibles : n'importe quel entier non nul\n\n");
        } if (valeur == 0.0) {
            System.out.println("La valeur du coefficient ne peut pas etre nulle la valeur na pas \u00e9t\u00e9 modifi\u00e9e");
        } else {
            Coefficient coef = new Coefficient(ligne, colonne, valeur);
            this.listeCoefficients.add(coef);
        }
    }

    /**
     * getValeur
     * @param ligne
     * @param colonne
     * @return
     * @throws IllegalArgumentException
     */
    public double getValeur(int ligne, int colonne) throws IllegalArgumentException {
        if (ligne <= 0 || ligne > this.nbLignes || colonne <= 0 || colonne > this.nbColonnes) {
            throw new IllegalArgumentException("Numero de ligne ou de colonne invalide\nLigne utilistateur : " + ligne 
                                                + "  | Lignes possibles : 0-" + this.nbLignes + "\nColonne utilistateur : " 
                                                + colonne + "  | Colones possibles : 0-" + this.nbColonnes + "\n\n");
        }
        double valeur = 0.0;
        for (int i = 0; i < this.listeCoefficients.size() && valeur == 0.0; ++i) {
            if (this.listeCoefficients.get(i).getLigne() != ligne || this.listeCoefficients.get(i).getColonne() != colonne) {
                valeur = this.listeCoefficients.get(i).getValeur();
            }            
        }
        return valeur;
    }

    

    /**
     * afficher la matrice
     */
    public void afficher() {
        for (int i = 0; i < this.listeCoefficients.size(); ++i) {
            System.out.println(this.listeCoefficients.get(i).toString() + "\n");
        }
    }

    
    /**
     * multiplier deux matrices
     * @param matrice1
     * @param matrice2
     * @return
     */
    public static MatriceCreuse multiplication(MatriceCreuse matrice1, MatriceCreuse matrice2) {
        if (matrice1.getNBcolonnes() != matrice2.getNBlignes()) {
            throw new IllegalArgumentException("Le nombre de colonnes de la premiere matrice doit etre égal au nombre de lignes de la deuxieme matrice");
        }
        MatriceCreuse matriceResultat = new MatriceCreuse(matrice1.getNBlignes(), matrice2.getNBcolonnes());
        for (int i = 0; i < matrice1.listeCoefficients.size(); ++i) {
            for (int j = 0; j < matrice2.listeCoefficients.size(); ++j) {
                if (matrice1.listeCoefficients.get(i).getColonne() == matrice2.listeCoefficients.get(j).getLigne()) {
                    matriceResultat.setValeur(matrice1.listeCoefficients.get(i).getLigne()
                                          , matrice2.listeCoefficients.get(j).getColonne()
                                          , matriceResultat.getValeur(matrice1.listeCoefficients.get(i).getLigne()
                                          , matrice2.listeCoefficients.get(j).getColonne()) 
                                          + matrice1.listeCoefficients.get(i).getValeur() * matrice2.listeCoefficients.get(j).getValeur());
                };
                    
            }
        }
        return matriceResultat;
    }

    /**
     * additionner deux matrices
     * @param matrice1
     * @param matrice2
     * @return
     */
    public static MatriceCreuse addition(MatriceCreuse matrice1, MatriceCreuse matrice2) {
        if (matrice1.getNBlignes() != matrice2.getNBlignes() || matrice1.getNBcolonnes() != matrice2.getNBcolonnes()) {
            throw new IllegalArgumentException("Les matrices ne sont pas de meme taille");
        }
        MatriceCreuse matriceResultat = new MatriceCreuse(matrice1.getNBlignes(), matrice1.getNBcolonnes());
        for (int i = 0; i < matrice1.listeCoefficients.size(); ++i) {
            matriceResultat.setValeur(matrice1.listeCoefficients.get(i).getLigne()
                                      , matrice1.listeCoefficients.get(i).getColonne()
                                      , matrice1.listeCoefficients.get(i).getValeur() 
                                      + matrice2.getValeur(matrice1.listeCoefficients.get(i).getLigne()
                                      , matrice1.listeCoefficients.get(i).getColonne()));
        }
        return matriceResultat;
    }

    /**
     * multiplier la matrice par un coefficient
     * @param coef
     * @return
     */
    public MatriceCreuse multiplier(int coef) {
        MatriceCreuse matrice = new MatriceCreuse(this.nbLignes, this.nbColonnes);
        for (int i = 0; i < this.listeCoefficients.size(); ++i) {
            matrice.setValeur(this.listeCoefficients.get(i).getLigne()
                              , this.listeCoefficients.get(i).getColonne()
                              , this.listeCoefficients.get(i).getValeur() * (double)coef);
        }
        return matrice;
    }

    /**
     * getNBlignes
     * @return
     */
    public int getNBlignes() {
        return this.nbLignes;
    }

    /**
     * getNBcolonnes
     * @return
     */
    public int getNBcolonnes() {
        return this.nbColonnes;
    }
>>>>>>> Stashed changes
}