import java.util.List;



public class Evaluateur {
    
    private static TexteExpression texteExpression;

    /**
     * - evaluer(String) : Mémorise dans texteExpression le texte décrivant une expression passé en paramètre puis appelle construireExpression() pour analyser ce texte et construire une réprésentation interne (arborescente) de l'expression . Si aucune erreur de syntaxe n'est détectée, elle évalue ensuite l'expression en se basant sur sa représentation interne (évaluation des noeuds de l'arborescence puis application des opérateurs) et renvoie le résultat. Lève ExpressionMalFormeeException sinon.
     */
    
    public static int evaluer(String expression) throws ExpressionMalFormeeException {
        return 0; // STUB
    }

    /**
     * - construireExpression() : Analyser le texte mémorisé dans l'attribut texteExpression à partir de la position courante de son index afin de construire soit une ConstanteEntiere, soit une ExpressionNaire, en appelant  construireConstanteEntiere() et constrruireExpEntiereNaire(). Lever ExpressionMalFormeeException si erreur de syntaxe.
     */
    
    private static Expression construireExpression() throws ExpressionMalFormeeException {
        return null; // STUB
    }

    /**
     * - construireConstanteEntiere() : Analyser le texte mémorisé dans l'attribut texteExpression à partir de la position courante de son index afin de construire une ConstanteEntiere avec la valeur entière correspondante. Lever NumberFormatException si erreur de syntaxe.
     */
    
    private static ConstanteEntiere construireConstanteEntiere() throws NumberFormatException {
        return null; // STUB
    }

    /**
     * - construireExpEntiereNaire() : Analyser le texte mémorisé dans l'attribut texteExpression à partir de la position courante de son index afin de construire une ExpressionEntiereNaire, en appelant construireExpression() pour construire les opérandes. Lever ExpressionMalFormeeException si erreur de syntaxe.
     */
    
    private static ExpressionEntiereNaire construireExpEntiereNaire() throws ExpressionMalFormeeException {
        return null; // STUB
    }

    /**
     * - main() : Boucle sans fin (arrêtée de l'extérieur) permettant de :
     * 1. Lire le texte d'une expression au clavier
     * 2. Utiliser l'Evaluateur pour l'analyser et l'évaluer
     * 3. Afficher le résultat ou un message d'erreur si l'expression est mal formée.
     */
    
    public static void main(List<String> args) {
    }

}
