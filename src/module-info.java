module StickersHeros {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.swing;
    requires com.google.gson;

    exports views;
    opens models to com.google.gson;
}