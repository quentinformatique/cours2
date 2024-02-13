module src.tp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;

    exports src.tp2.client to javafx.graphics;
}