import java.util.ArrayList;
import java.util.List;



public class ExpressionEntiereNaire implements Expression {
    
    private char operateur;

    
    private List<Expression> operandes = new ArrayList<Expression> ();

    /**
     * ExpressionEntiereNaire(): Lève ExpressionMalFormeeException si opérateur autre que + ou *, ou nombre d'opérandes < 2.
     */
    
    public ExpressionEntiereNaire(char operateur, List<Expression> operandes) throws ExpressionMalFormeeException {
        if (operateur != '+' || operateur != '*' || operandes.size() < 2) {
            this.operateur = operateur;
            this.operandes = operandes;
        } else {
            throw new ExpressionMalFormeeException();
        }
    }

    /**
     * - evaluer() : Evalue les opérandes puis applique l'opérateur aux valeurs des opérandes et renvoie le résultat.
     */
    @Override
    public int evaluer() throws OperateurException {
        return 0; // STUB
    }

}
