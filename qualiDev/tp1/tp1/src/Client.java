import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("3a12cc32-a351-4f5b-834c-d7c1a098ddb1")
public class Client {
    @objid ("e2430460-65ba-41b7-8962-5e9eb7562be1")
    private static String compteurNumeros;

    @objid ("9295ef32-22e4-4761-a3c9-04975f92f479")
    protected String numero;

    @objid ("fbde131c-a65f-4d16-b4b9-f15177237f5b")
    private List<Commande> commandes = new ArrayList<Commande> ();

    @objid ("3c835d19-a70e-45b5-9494-4d73127955d8")
    Client() {
    }

    @objid ("3357c5d8-52d8-403d-b8a3-a3ffab474385")
    void ajouterCommande(List<String> prods, List<String> qts, List<String> prix) throws CommandException {
    }

}
