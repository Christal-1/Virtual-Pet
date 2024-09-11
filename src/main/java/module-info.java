module org.mobile.virtual {
    requires javafx.controls;
    requires javafx.fxml;

//    requires org.controlsfx.controls;

    opens org.mobile.virtual to javafx.fxml;
    exports org.mobile.virtual;
}