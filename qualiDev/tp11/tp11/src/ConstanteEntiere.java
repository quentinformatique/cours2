


public class ConstanteEntiere implements ExpressionEntiere {
    
    private int valeur;

    
    public ConstanteEntiere(int valeur) {
        this.valeur = valeur;
    }

    /**
     * Renvoie la valeur de l'attribut valeur.
     */
    
    public Integer evaluer() {
        return valeur;
    }

}
