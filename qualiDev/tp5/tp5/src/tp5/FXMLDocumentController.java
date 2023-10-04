/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/** 
 *
 * @author quentin.costes
 */
public class FXMLDocumentController implements Initializable {
    
    
    
    @FXML
    private Label devise;
    
    @FXML
    private RadioButton radioDollar;
    
    @FXML
    private RadioButton radioEuro;
    
    @FXML
    private Button button;
    
    @FXML
    private TextField inputConverti;
    
    @FXML
    private TextField inputAConverti;
    
    @FXML
    private void convertir(ActionEvent event) {
        inputConverti.setText(inputAConverti.getText());
    }
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
