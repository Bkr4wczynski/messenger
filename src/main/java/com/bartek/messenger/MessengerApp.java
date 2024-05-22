package com.bartek.messenger;

import com.bartek.messenger.client.Client;
import com.bartek.messenger.controllers.login.SignUpPageController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.InetAddress;

public class MessengerApp extends Application {
    public static Client client;
    SignUpPageController signUpPageController;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MessengerApp.class.getResource("FXML-files/login/signUpPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Messenger");
        stage.setScene(scene);
        signUpPageController = fxmlLoader.getController();
        stage.show();
        stage.setOnCloseRequest(windowEvent -> {
            windowEvent.consume();
            if (logout()){
                closeApp();
                stage.close();
            }
        });
    }

    public static void main(String[] args) {
        client = null;
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
    public boolean logout(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to logout!");
        alert.setContentText("Are you sure?");
        return alert.showAndWait().get() == ButtonType.OK;
    }
    public void closeApp(){
        client.closeStreams();
    }
}