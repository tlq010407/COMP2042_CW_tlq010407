module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    opens Game2048 to javafx.fxml;
    exports Game2048;
}