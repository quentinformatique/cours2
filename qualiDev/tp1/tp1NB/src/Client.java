import java.util.ArrayList;
import java.util.List;



public class Client {
    
    private static int compteurNumeros = 0;

    
    protected String numero;

    
    private List<Commande> commandes = new ArrayList<Commande> ();

    
    public Client() {
        this.numero = "CL" + compteurNumeros++;
    }

    
    void ajouterCommande(List<String> prods, List<Integer> qts, List<Float> prix) throws CommandException {
        this.commandes.add(new Commande(this, prods, qts, prix));
    }
    
    void afficherCommandes() {
        System.out.println("-------------------------------------------------");
        for (Commande c : commandes) {
            System.out.println(c);
            System.out.println("-------------------------------------------------");
        }
        
    }

}
