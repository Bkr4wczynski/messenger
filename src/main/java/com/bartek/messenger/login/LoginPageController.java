package com.bartek.messenger.login;

import com.bartek.messenger.RedirectionPage;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginPageController extends RedirectionPage {
    public TextField usernameField;
    public PasswordField passwordField;
    public Label warningsLabel;

    public void redirectToSignUpPage(ActionEvent event) {
        try {
            redirect(event, "FXML-files/login/signUpPage.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void login(ActionEvent event){
        // tries to login via database
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (true){
            // login succeed
            try {
                redirect(event, "FXML-files/main/main.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            // login not succeed
        }
    }

}
