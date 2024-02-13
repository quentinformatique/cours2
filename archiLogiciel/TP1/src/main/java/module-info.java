module src.tp1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;


    opens src.tp1 to javafx.fxml;
    exports src.tp1;
}