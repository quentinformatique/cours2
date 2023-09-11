import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("0e66e66f-aa27-4d28-99af-aaafbf5f1ce6")
public class Commande {
    @objid ("273ce400-3fe8-4d9e-a8f0-f351778a3831")
    private static String compteurNumeros;

    @objid ("dc8cad37-737b-4746-af94-4e25ebf6afc7")
    private String numéo;

    @objid ("fa8e742c-0c9c-40bb-a32f-1eeb663bf4d2")
    private String[] produits;

    @objid ("fcf0353d-4f88-4e2f-84a3-8ff5a0714809")
    private int[] quantites;

    @objid ("4fce8998-8fe3-419e-b5d0-af9c0f60faa9")
    private float[] prixUnitaires;

    @objid ("101e1c82-9228-4558-9185-486eb60ea844")
    private List<Client> client = new ArrayList<Client> ();

    @objid ("424e3adf-e27f-4264-bc0e-14525e3b707d")
    Commande(int c, List<String> prods, List<String> qts, List<String> prix) throws CommandException {
    }

    @objid ("99caa532-e69e-447b-8ca1-52479df07fe1")
    public String toString() {
    }

}
