module src.tp1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens src.tp1 to javafx.fxml;
    exports src.tp1;
}