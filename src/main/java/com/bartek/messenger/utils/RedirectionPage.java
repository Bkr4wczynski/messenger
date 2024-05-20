package com.bartek.messenger.utils;

import com.bartek.messenger.MessengerApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class RedirectionPage {
    public Object redirect(ActionEvent event, String filepath) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MessengerApp.class.getResource(filepath));
        Parent parent = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
        return fxmlLoader.getController();
    }
}
