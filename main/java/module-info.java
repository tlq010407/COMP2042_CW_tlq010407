module Downloads {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;
    requires java.desktop;
    opens Game2048 to javafx.fxml;
    exports Game2048;
}