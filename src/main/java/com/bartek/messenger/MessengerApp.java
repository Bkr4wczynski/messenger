package com.bartek.messenger;

import com.bartek.messenger.client.Client;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetAddress;

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
        Client client = null;
        try {
            client = new Client(InetAddress.getByName("localhost"), 5056);
            client.startClientService();
        }
        catch (IOException e) {
            System.out.println("Server is shutdown!");
            System.exit(0);
        }
        launch();
    }
}