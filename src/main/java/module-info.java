module com.example.game2048 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires junit;

    opens com.example.game2048 to javafx.fxml;
    exports com.example.game2048;
    exports com.example.game2048.Component;
    opens com.example.game2048.Component to javafx.fxml;
}