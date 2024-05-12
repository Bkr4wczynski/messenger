package com.bartek.messenger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpPageController {
    @FXML
    private Label warningsLabel;
    @FXML
    private TextField usernameField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public PasswordField passwordConfirmationField;

    public void redirectToLoginPage(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(MessengerApp.class.getResource("FXML-files/LoginPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
    public void signUp(){
        if (validate()){
            // perform sign up logic
        }
    }
    private boolean validate(){
        if (!checkIfPasswordsAreIdentical()){
            warningsLabel.setText("Password are not identical!");
            return false;
        }
        if (!checkIfUsernameIsValid()){
            warningsLabel.setText("Username is not valid!");
            return false;
        }
        if (!checkIfPasswordIsLongEnough()){
            warningsLabel.setText("Password is too short");
            return false;
        }
        warningsLabel.setText("");
        return true;
    }
    private boolean checkIfUsernameIsValid(){
        String username = usernameField.getText();
        if (username.isBlank())
            return false;
        if (username.length() < 3)
            return false;
        return username.matches("^[a-zA-Z0-9_-]+$");
    }
    private boolean checkIfPasswordIsLongEnough(){
        String password = passwordField.getText();
        return password.length() >= 8;
    }
    private boolean checkIfPasswordsAreIdentical(){
        return passwordField.getText().equals(passwordConfirmationField.getText());
    }
}
