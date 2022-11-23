module Downloads {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;
    requires java.desktop;
    opens Game2048 to javafx.fxml;
    opens Game2048.Pane to javafx.fxml;
    exports Game2048;
    exports Game2048.Component;
    opens Game2048.Component to javafx.fxml;
    exports Game2048.Moving;
    opens Game2048.Moving to javafx.fxml;
    exports Game2048.Highest;
    opens Game2048.Highest to javafx.fxml;
}