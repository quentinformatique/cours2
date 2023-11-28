


public class TexteExpression {
    /**
     * Contient le texte décrivant une expression à évaluer
     */   
    private String texte;

    /**
     * Tête de lecture.
     */
    private int index = 0;

    /**
     * Construit une instance contenant un texte représentant une Expression et
     * positionne index au début du texte.
     */
    public TexteExpression(String texteExpression) {
        this.texte = texteExpression; 
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
     * Renvoie le caractère à la position courante de l'index.
     * @return Caractère courant.
     * @throws FinTexteException si fin du texte atteinte.
     */   
    public char caractereCourant() throws FinTexteException {
        if(index<texte.length()) return texte.charAt(index);
        else throw new FinTexteException();
    }

    /**
     * Incrémente index de 1 et renvoie le caractère se trouvant à cette position de l'index.
     * @throws FinTexteException si fin du texte atteinte.
    */   
    public char caractereSuivant() throws FinTexteException {
        if(index<texte.length()-1) return texte.charAt(++index);
        else throw new FinTexteException();
    }

    /**
     * Incrémente  l'index jusu'au 1er caractère non espace et renvoie ce caractère.
     * @throws FinTexteException si fin du texte atteinte.
     */
    
    public char caractereNonEspaceSuivant() throws FinTexteException {
        char c = caractereSuivant();
        while (c ==' ') c = caractereSuivant();
        return c;
    }

}
