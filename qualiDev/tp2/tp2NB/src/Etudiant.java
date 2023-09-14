import java.util.ArrayList;
import java.util.List;



public class Etudiant extends Utilisateur {
    
     List<Note> notes = new ArrayList<Note> ();

    /**
     * note(matiere): Recherche et en renvoie la note de l'étudiant dans la matière passée en paramètre. Renvoie -1 si l'étudiant n'a pas de note dans cette matière ou n'est pas inscrit à cette matière.
     */
    
    float note(String matiere) {
        // STUB
        return 0;
    }

    /**
     * modifierNote(matiere, nouvelleNote) : Modifie la note de l'étudiant dans la matière indiquée en paramètre avec la valeur indiquée en paramètre. Ne fait rien si l'étudiant n'est pas inscrit à cette matière.
     */
    
    void modifierNote(String matiere, float nouvelleNote) {
    }

    @Override
    public String toString() {
        return "Etudiant{" + "notes=" + notes + '}';
    }

    

    
    Etudiant(String nom, String prenom, String id, String pass) {
        super(nom, prenom, id, pass);
    }

}
