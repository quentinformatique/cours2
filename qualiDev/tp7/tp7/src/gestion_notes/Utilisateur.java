package gestion_notes;

import java.io.Serializable;

public abstract class Utilisateur implements Serializable {
    
  String nom;
  String prenom;  
  String identifiant;   
  String motDePasse;

  public String getNom() {
    return nom;
  }

  public String getPrenom() {
    return prenom;
  }
   
  Utilisateur(String nom, String prenom, String identifiant, String motDePasse) {
    this.nom = nom;
    this.prenom = prenom;
    this.identifiant = identifiant;
    this.motDePasse = motDePasse;
  }

}
