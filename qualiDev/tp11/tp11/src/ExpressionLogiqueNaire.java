import java.util.List;

public class ExpressionLogiqueNaire implements ExpressionLogique {
    
    private char operateur;

    
    private List<ExpressionLogique> operandes ;

    public ExpressionLogiqueNaire(char operateur, List<ExpressionLogique> operandes)
            throws ExpressionMalFormeeException{
        // A COMPLETER
    }

    /**
     * Evalue les opérandes puis applique l'opérateur aux valeurs des opérandes et renvoie
     * le résultat. 
     * Lève OperateurException si opérateur non autorisé.
     */ 
    
    public Boolean evaluer() throws OperateurException {
        // A COMPLETER    
        return true; // Bouchon
    }

}
