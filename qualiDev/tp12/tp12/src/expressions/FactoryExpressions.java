

package expressions;

import java.util.ArrayList;

public class FactoryExpressions {

    private ArrayList<Expression> typeExpressions; // instances de chaque type d'expression 
    
    private static FactoryExpressions instance = new FactoryExpressions();
       
    private FactoryExpressions() {
        typeExpressions = new ArrayList();        
        typeExpressions.add(new ConstanteEntiere());
        typeExpressions.add(new ExpressionEntiereNaire());
    }
    
    public static FactoryExpressions getInstance() {
        return instance;
    }
    
    /**
     * Tente de construire une expression fournie sous la forme d'une chaîne de caractères, par 
     * appel à construireExpression(TexteExpression) puis vérifie que la fin de l'expression 
     * coïncide avec la fin de la chaîne. Lève ExpressionMalFormeeException si l'expressiion est
     * incorrecte syntaxiquement ou si la fin de l'expression ne coïncide pas avec la fin de la
     * chaîne.
     */
    public Expression construireExpression(String expression) throws ExpressionMalFormeeException {
      TexteExpression te = new TexteExpression(expression);
      Expression result = construireExpression(te);
      // S'assurer que c'est la fin du texte avant de renvoyer l'expression construite.
      try { 
        te.caractereNonEspaceSuivant(); 
        throw new ExpressionMalFormeeException(); // Cas non fin du texte
      }
      catch(FinTexteException e) { // Cas fin du texte
        return result; 
      } 
    }
    
    /**
     * Tente de construire une expression d'un type parmi les types dont une instance 
     * a été enregsitrée.
     * @param te : Texte de l'expression à construire.
     * @return : Expression construite.
     * @throws ExpressionMalFormeeException : Si te ne décrit pas une expression conforme
     */
    Expression construireExpression(TexteExpression te) 
                throws ExpressionMalFormeeException {
      for (Expression typeExpression: typeExpressions) {
        try {
      // 1. Tenter de construire et renvoyer une expression conforme à l'un des types
      // enregistrés dans la factory
          return typeExpression.construireExpression(te); 
        }
      // 2. Si échec avec le type essayé, ne rien faire. Il faut essayer avec le type suivant.
        catch (ExpressionMalFormeeException e) {}
      }
      // 3. Sortie du for (donc return non exécuté) : cela signifie échec avec tous les types.
      throw new ExpressionMalFormeeException();
    }
}
     
            
