package ihms;

import javafx.scene.control.Alert;

public class Message {
  public static void afficher(String message) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setHeaderText("");
    alert.setContentText(message);
    alert.showAndWait();
  }
}
