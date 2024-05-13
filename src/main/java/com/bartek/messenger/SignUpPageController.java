package com.bartek.messenger;

import com.bartek.messenger.utils.Validator;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpPageController extends RedirectionPage{
    public Label warningsLabel;
    public TextField usernameField;
    public PasswordField passwordField;
    public PasswordField passwordConfirmationField;

    public void redirectToLoginPage(ActionEvent event) throws IOException {
        redirect(event, "FXML-files/LoginPage.fxml");
    }
    public boolean signUp(){
        if (validate()){
            // perform sign up logic
            return true;
        }
        return false;
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
        warningsLabel.setText("");
        return true;
    }
}
