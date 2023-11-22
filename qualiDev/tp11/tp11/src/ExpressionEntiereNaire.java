import java.util.ArrayList;
import java.util.List;

public class ExpressionEntiereNaire implements ExpressionEntiere {
    
    private char operateur;

    
    private List<ExpressionEntiere> operandes = new ArrayList<ExpressionEntiere> ();

    /**
     * Lève ExpressionMalFormeeException si opérateur autre que + ou *, 
     * ou nombre d'opérandes < 2.
     */
    
    public ExpressionEntiereNaire(char operateur, List<ExpressionEntiere> operandes) 
            throws ExpressionMalFormeeException {
        if((operateur != '+' && operateur !='*') || operandes.size() < 2)
            throw new ExpressionMalFormeeException();
        else {
            this.operateur = operateur;
            this.operandes = operandes;
        }
    }


    /**
     * Evalue les opérandes puis applique l'opérateur aux valeurs des opérandes et renvoie
     * le résultat. 
     * Lève OperateurException si opérateur non autorisé.
     */   
    public Integer evaluer() throws OperateurException {
      int result = (int)operandes.get(0).evaluer();
      if(operateur == '+') {
        for(int i=1; i<operandes.size(); i++) {
          result += (int)operandes.get(i).evaluer();
        }
        return result;
      }   
      else if(operateur == '*') {
        for(int i=1; i<operandes.size(); i++) {
          result *= (int)operandes.get(i).evaluer();
        }
        return result;
      }
      else throw new OperateurException();
    }
}
