module com.bartek.messenger {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.bartek.messenger to javafx.fxml;
    exports com.bartek.messenger;
    exports com.bartek.messenger.main;
    opens com.bartek.messenger.main to javafx.fxml;
    exports com.bartek.messenger.login;
    opens com.bartek.messenger.login to javafx.fxml;
}