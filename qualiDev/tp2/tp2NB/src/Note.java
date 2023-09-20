
public class Note {
    
  float valeur;   
  Matiere matiere;

  /**
   * valeur : initialisée à -1 signifiant l'absence de note.
   */  
  Note(Matiere matiere) {
    valeur = -1;
    this.matiere = matiere;
  }

}
