import java.util.ArrayList;
import java.util.List;



public class Commande {
    
    private static int compteurNumeros;

    
    private String numéro;

    
    private String[] produits;

    
    private int[] quantites;

    
    private float[] prixUnitaires;

    
    private Client client;

    
    Commande(Client c, List<String> prods, List<Integer> qts, List<Float> prix) throws CommandException {
        this.numéro = "" +compteurNumeros;
        compteurNumeros ++;
        
        if (prods.size() != qts.size() || prods.size() != prix.size()) {
            throw new CommandException();
        }
        
        
        for (int i = 0; i < prods.size(); i++) {
            this.produits[i]  = prods.get(i);
        }
        for (int i = 0; i < qts.size(); i++) {
            this.quantites[i]  = qts.get(i);
        }
        for (int i = 0; i < prix.size(); i++) {
            this.prixUnitaires[i]  = prix.get(i);
        }
        
       this.client = c;
    }

    
    public String toString() {
        String retour = "numéro: " + this.numéro + "\n Client: "+ this.client + "\nproduits: ";
        for (int i = 0; i < produits.length; i++) {
            retour += produits[i] + ", ";         
        }
        retour += "\n prix unitaires: ";
        
        for (int i = 0; i < prixUnitaires.length; i++) {
            retour += prixUnitaires[i] + ", "; 
        }
        
        retour += "\n quantitées: ";
        for (int i = 0; i < quantites.length; i++) {
            retour += quantites[i] + ", ";            
        }
        
        return retour;
        
    }

}
