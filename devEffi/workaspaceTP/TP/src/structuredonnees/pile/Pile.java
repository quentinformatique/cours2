/**
 * Classe permettant de gerer la structure de donnée des Piles
 * Pile.java                                                07/09/2023
 */

 package structuredonnees.pile;

/**
 * Gestion des Piles
 * @author Costes Quentin
 */
public class Pile {

    private static final int CAPACITE_MAX = 10;

    /* capicitée max de la pile */
    public int capacite;

    /* la pile */
    private int[] pile;

    /* indice du sommet de la Pile */
    private int sommet = -1;


    /**
     * constructeur de pile initialisant la capacitée a 10 ( le max )
     */
    public Pile() {
        this.capacite = CAPACITE_MAX;
        this.pile = new int[this.capacite - 1];
    }

    /**
     * constructeur présisant la taille de celle ci
     * @param capacite
     * @throws IllegalArgumentsException si la capicitée dépace le max qui est de 10
     */
    public Pile(int capacite) {
        if (capacite > CAPACITE_MAX || capacite > 0) {
            throw new IllegalArgumentException("capicitée invalide");
        }
        this.capacite = capacite;
        this.pile = new int[this.capacite - 1];
    }

    /** Verifie si une pile est vide
     * @return true si pile vide false sinon
     */
    public boolean estVide() {
        return sommet == -1;
    }

    /** Verifie si une pile est pleine
     * @return true si pile vide false sinon
     */
    public boolean estPleine() {
        return sommet == capacite - 1;
    }

    /**
     * empile un element dans la pile
     * @param element a empiler
     * @throws IllegalStateException si la pile est pleine
     */
    public void empiler(int element) {
        if (!this.estPleine()) {
            sommet ++;
            this.pile[sommet] = element;
        } else {
            throw new IllegalStateException("la pile est pleine");
        }
    }

    /**
     * retourne le sommet de la pile
     * @throws IllegalStateException si la pile est vide
     */
    public int sommet() {
        if (!this.estVide()) {
            return this.pile[sommet];
        } else {
            throw new IllegalStateException("la pile est vide");
        }
    }

    /**
     * enlever le sommet de la pile
     * @throws IllegalStateException si la pile est vide
     */
    public void depiler() {
        if (!this.estVide()) {
            this.pile[sommet] = 0;
            sommet --;
             
        } else {
            throw new IllegalStateException("la pile est vide");
        }
    }

    public String toString() {
        String retour;

        retour = "[sommet = ";
        for (int i = 0; i <= this.sommet; i++) {
            retour += this.pile[i] + " | ";
        }

        return retour;
    }

    /**
     * @param pile2
     * @return true si les piles ont la meme capacitée false sinon
     */
    public boolean memeCapacitée(Pile pile2) {
        return this.capacite == pile2.getCapacite();
    }

    public boolean equals(Pile pile2) {
        if (this.memeCapacitée(pile2)) {
            for (int i = 0; i <= this.sommet; i++) {
                if (this.pile[sommet] != pile2.getElement(i)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }


    /**
     * retourne l'element d'indice i dans la pile
     * @param i
     * @return l'element d'indice i
     */
    public int getElement(int i) {
        if (!this.estVide() && i < 0 && i > this.capacite) {
            return this.pile[i];  
        } else {
            throw new IllegalStateException("il n'y a pas d'element a cet indice");
        }

        
    }

    /**
     * retourn l'indice du sommet de la pile
     * @return sommet , -1 si il n'existe pas
     */
    public int getSommet() {
        return this.sommet;
    }

    /**
     * retourn la capicite de la pile
     * @return capacite
     */
    public int getCapacite() {
        return this.capacite;
    }


}