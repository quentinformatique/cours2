public interface Expression {
    /**
     * Evalue l'expression et renvoie sa valeur.
     * Lève OperateurException si opérateur non autorisé.
     */
    public Object evaluer() throws OperateurException;

}
