/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihms;

import gestion_notes.Etudiant;
import gestion_notes.GestionNotes;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class IhmEtudiantController implements Initializable {

  private Etudiant etudiant; // Etudiant connecté
  
  @FXML
  private Label labelNotes;
  @FXML
  private TextArea txtNotes;
  @FXML
  private Button btnQuitter;

  void setEtudiant(Etudiant etudiant) {
    this.etudiant = etudiant;
    // Préciser dans labelNotes les nom et prénoms de l'étudiant
    // et Remplir la zone txtNotesEtudiant avec ses notes
    labelNotes.setText("Notes de "+etudiant.getNom()+" "+etudiant.getPrenom());
    txtNotes.setText(etudiant.notesToString());
  }  
  
  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
  }  

  @FXML
  private void btnQuitterAction(ActionEvent event) {
    // Lever le verrou sur les données avant de quitter l'application
    try {
      GestionNotes.deVerrouillerDonnees();
      System.exit(0);
    }
    catch(IOException e) { 
      System.out.println("Erreur lors du déverrouillage des données !"); }
  }
  
}
