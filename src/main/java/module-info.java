module com.bartek.messenger {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.bartek.messenger to javafx.fxml;
    exports com.bartek.messenger;
    exports com.bartek.messenger.mainPage;
    opens com.bartek.messenger.mainPage to javafx.fxml;
    exports com.bartek.messenger.login;
    opens com.bartek.messenger.login to javafx.fxml;
}