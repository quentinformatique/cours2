import java.util.ArrayList;
import java.util.List;



public class Enseignant extends Utilisateur {
    
     List<Matiere> matieresEnseignees = new ArrayList<Matiere> ();

    
    void setMatieresEnseignees(List<Matiere> matieres) {
        this.matieresEnseignees = matieres;
    }

    
    Enseignant(String nom, String prenom, String id, String pass) {
        super(nom, prenom, id, pass);
    }

}
