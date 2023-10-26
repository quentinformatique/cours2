public class ConstanteEntiere implements Expression {
    
    private int valeur;
    
    public ConstanteEntiere(int valeur) {
        this.valeur = valeur;
    }

    /**
     * Renvoie la valeur de l'attribut valeur.
     */
    
    public int evaluer() {
        return valeur;
    }

}
