package qd_tp3;


import java.io.Serializable;




public class Note implements Serializable {
    
    float valeur; 

    
    Matiere matiere;

    
    Note(Matiere matiere) {
      this.matiere = matiere;
      valeur = -1; // -1 signifie l'absence de note
    }

}
