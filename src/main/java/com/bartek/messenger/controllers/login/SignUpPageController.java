package com.bartek.messenger.controllers.login;

import com.bartek.messenger.MessengerApp;
import com.bartek.messenger.client.Client;
import com.bartek.messenger.utils.RedirectionPage;
import com.bartek.messenger.utils.Validator;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SignUpPageController extends RedirectionPage {
    public Label warningsLabel;
    public TextField usernameField;
    public PasswordField passwordField;
    public PasswordField passwordConfirmationField;
    private Client client = MessengerApp.client;

    public void redirectToLoginPage(ActionEvent event) {
        try {
            redirect(event, "FXML-files/login/loginPage.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void signUp(ActionEvent event){
        if (validate()){
            boolean result = client.loginUser(usernameField.getText(), passwordField.getText(), "signup");
            if (!result){
                warningsLabel.setText("Failed to sign up!");
                return;
            }
            try {
                redirect(event, "FXML-files/main/main.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private boolean validate(){
        if (!Validator.CHECK_IF_PASSWORDS_ARE_IDENTICAL(passwordField.getText(), passwordConfirmationField.getText())){
            warningsLabel.setText("Password are not identical!");
            return false;
        }
        if (!Validator.CHECK_IF_USERNAME_IS_VALID(usernameField.getText())){
            warningsLabel.setText("Username is not valid!");
            return false;
        }
        if (!Validator.CHECK_IF_PASSWORD_IS_LONG_ENOUGH(passwordField.getText())){
            warningsLabel.setText("Password is too short");
            return false;
        }
        if (!Validator.CHECK_IF_PASSWORD_IS_STRONG_ENOUGH(passwordField.getText())){
            warningsLabel.setText("Password is too weak");
            return false;
        }
        warningsLabel.setText("");
        return true;
    }

}
