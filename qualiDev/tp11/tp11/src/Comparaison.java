


public class Comparaison implements ExpressionLogique {
    
    private char operateur;
    private ExpressionEntiere droite;
    private ExpressionEntiere gauche;

    public Comparaison(char operateur, ExpressionEntiere gauche, ExpressionEntiere droite) 
            throws ExpressionMalFormeeException {
        // A COMPLETER
    }

    /**
     * Evalue les opérandes puis applique l'opérateur de comparaison aux valeurs des opérandes
     * et renvoie le résultat. 
     * Lève OperateurException si opérateur non autorisé.
     */ 
    public Boolean evaluer() throws OperateurException {
        // A COMPLETER
        return true; // Bouchon
    }

}
