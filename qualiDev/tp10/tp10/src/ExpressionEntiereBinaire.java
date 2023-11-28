public class ExpressionEntiereBinaire implements Expression {
    
    private char operateur;  
    private Expression droite;   
    private Expression gauche;

    /**
     * Lever ExpressionMalFormeeException si opérateur autre que - ou /.
     */
    
    public ExpressionEntiereBinaire(char operateur, 
            Expression gauche, Expression droite) 
            throws ExpressionMalFormeeException {
        if (operateur != '-' && operateur != '/' ) 
            throw new ExpressionMalFormeeException();
        else {
            this.operateur = operateur;
            this.droite = droite;
            this.gauche = gauche;
        }
    }

    /**
     * Si operateur = '-', calculer gauche-droite et envoyer le résultat.
     * Si operateur = '/', calculer division entière gauche/droite et envoyer le résultat. 
     * L'erreur division par 0 sera automatiquement levée si droite = 0.
     * Lève OperateurException si opérateur non autorisé.
     */
    public int evaluer() throws OperateurException {
        int g = gauche.evaluer();
        int d = droite.evaluer();
        if (operateur == '-') return g - d;
        else if (operateur == '/') return g / d;
        else throw new OperateurException();
    }
}
