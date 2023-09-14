import java.util.ArrayList;
import java.util.List;



public class Matiere {
    
     String intitule;

    
     List<Etudiant> etudiantsInscrits = new ArrayList<Etudiant> ();

    
    Matiere(String intitule) {
        this.intitule = intitule;
    }

    /**
     * modifierNotes(): Afficher en boucle un menu indiquant l'ensemble des notes pour les étudiants inscrits dans cette matière avec la possibilité de les modifier.
     */
    
    void modifierNotes() {
    }

    /**
     * setEtudiantsInscrits() : Affecter les étudiants inscrits et intialiser leurs notes à -1.
     */
    
    void setEtudiantsInscrits(List<Etudiant> etudiants) {
    }

}
