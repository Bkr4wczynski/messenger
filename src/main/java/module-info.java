module com.bartek.messenger {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.bartek.messenger to javafx.fxml;
    exports com.bartek.messenger;
}