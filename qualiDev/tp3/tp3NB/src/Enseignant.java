package qd_tp3;


public class Enseignant extends Utilisateur {
    
  Matiere[] matieresEnseignees;

  Enseignant(String nom, String prenom, String identifiant, String motDePasse) {
    super(nom, prenom, identifiant, motDePasse);
  }

  void setMatieresEnseignees(Matiere... matieres) {
    this.matieresEnseignees = matieres;
  }

}
