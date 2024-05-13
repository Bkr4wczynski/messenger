package com.bartek.messenger;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginPageController extends RedirectionPage{
    public TextField usernameField;
    public PasswordField passwordField;
    public Label warningsLabel;

    public void redirectToSignUpPage(ActionEvent event) {
        try {
            redirect(event, "FXML-files/signUpPage.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void login(ActionEvent event){
        // tries to login via database
        if (true){
            // login succeed
            try {
                redirect(event, "FXML-files/mainPage.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            // login not succeed
        }
    }

}
