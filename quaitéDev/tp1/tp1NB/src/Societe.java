


public class Societe extends Client{
    
    private String raisonSociale;

    
    Societe(String raisonSociale) {
        super();
        this.raisonSociale = raisonSociale;
    }

    
    public String toString() {      
        return "raison sociale: " + this.raisonSociale + "numéro client" 
               + this.numero;
    }

}
