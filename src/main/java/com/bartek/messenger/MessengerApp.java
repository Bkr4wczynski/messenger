package com.bartek.messenger;

import com.bartek.messenger.client.Client;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MessengerApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MessengerApp.class.getResource("FXML-files/login/signUpPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Messenger");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        try {
            Client.startClientService();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        launch();
    }
}