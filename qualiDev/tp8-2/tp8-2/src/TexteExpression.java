public class TexteExpression {
    /**
     * - texte : Contient le texte décrivant une expression à évaluer
     */
    
    private String texte;

    /**
     * - index : Tête de lecture.
     */
    
    private int index = 0;

    /**
     * Construit une instance contenant un texte représentant une Expression et positionne index au début du texte.
     */
    
    public TexteExpression(String texteExpression) {
        this.text = texteExpression;
    }

    
    public int getIndex() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.index;
    }

    
    public void setIndex(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.index = value;
    }

    /**
     *  - caractereCourant : Renvoie le caractère à la position courante de l'index.
     */
    
    public char caractereCourant() throws FinTexteException {
        return this.texte.charAt(this.index);
    }

    /**
     * caractereSuivant() : incrémente index de 1 et renvoie le caractère se trouvant à cette position de l'index.
     */
    
    public char caractereSuivant() throws FinTexteException {
        return this.texte.charAt(this.index + 1);
    }

    /**
     *  - caractereNonEspaceSuivant() : Incrémente  l'index jusu'au 1er caractère non espace et renvoie ce caractère.
     */
    
    public char caractereNonEspaceSuivant() throws FinTexteException {
        return 'a'; // STUB
    }

}
