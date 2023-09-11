


public class Particulier extends Client {
    
    private String nom;

    
    private String prenom;

    
    Particulier(String nom, String prenom) {
        super();
        this.prenom = prenom;
        this.nom = nom;
    }

    
    public String toString() {
        return "nom: " + this.nom + "\n prenom: " + this.prenom + "numéro client" 
               + this.numero;
    }

}
