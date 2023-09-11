import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("fcdc5da4-877b-4d74-bcf7-d8b319a957d8")
public class Enseignants {
    @objid ("4cc691a5-5eb5-450f-91c0-0f53bb7fc7da")
    public List<Utilisateur>  = new ArrayList<Utilisateur> ();

    @objid ("d32469f5-72e1-49b6-8ce4-1ef65eec6fe2")
     List<Matiere> matieresEnseignees = new ArrayList<Matiere> ();

    @objid ("9caf7fd0-262d-4a2f-b07d-e23a65523811")
    void saisirNote(float valeur, Matiere matiere, Etudiant etudiant) {
    }

    @objid ("e87f2878-f45b-46d0-a7aa-979111a258df")
    void modifierNote(Note note, float valeur) {
    }

}
