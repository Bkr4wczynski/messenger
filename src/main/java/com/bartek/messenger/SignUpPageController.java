package com.bartek.messenger;

import com.bartek.messenger.utils.Validator;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SignUpPageController extends RedirectionPage{
    public Label warningsLabel;
    public TextField usernameField;
    public PasswordField passwordField;
    public PasswordField passwordConfirmationField;

    public void redirectToLoginPage(ActionEvent event) {
        try {
            redirect(event, "FXML-files/loginPage.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean signUp(ActionEvent event){
        if (validate()){
            // perform sign up logic
            try {
                redirect(event, "FXML-files/mainPage.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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
