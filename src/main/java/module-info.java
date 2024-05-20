module com.bartek.messenger {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.zaxxer.hikari;
    requires java.sql;

    opens com.bartek.messenger to javafx.fxml;
    exports com.bartek.messenger;
    exports com.bartek.messenger.controllers.mainPage;
    opens com.bartek.messenger.controllers.mainPage to javafx.fxml;
    exports com.bartek.messenger.controllers.login;
    opens com.bartek.messenger.controllers.login to javafx.fxml;

    exports com.bartek.messenger.controllers.mainPage.subPages;
    opens com.bartek.messenger.controllers.mainPage.subPages to javafx.fxml;
    exports com.bartek.messenger.dataRepresentation;
    opens com.bartek.messenger.dataRepresentation to javafx.fxml;
    exports com.bartek.messenger.utils;
    opens com.bartek.messenger.utils to javafx.fxml;
}