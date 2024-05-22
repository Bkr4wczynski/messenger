package com.bartek.messenger.controllers.login;

import com.bartek.messenger.MessengerApp;
import com.bartek.messenger.client.Client;
import com.bartek.messenger.utils.RedirectionPage;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LoginPageController extends RedirectionPage {
    public TextField usernameField;
    public PasswordField passwordField;
    public Label warningsLabel;
    private Client client = MessengerApp.client;

    public void redirectToSignUpPage(ActionEvent event) {
        try {
            redirect(event, "FXML-files/login/signUpPage.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void login(ActionEvent event){
        // tries to login via database
        boolean result = client.loginUser(usernameField.getText(), passwordField.getText(), "signin");
        if (result){
            try {
                redirect(event, "FXML-files/main/main.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            warningsLabel.setText("Failed to login");
        }
    }
}
