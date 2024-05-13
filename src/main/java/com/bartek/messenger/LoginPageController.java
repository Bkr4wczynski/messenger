package com.bartek.messenger;

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

public class LoginPageController extends RedirectionPage{
    public TextField usernameField;
    public PasswordField passwordField;
    public Label warningsLabel;

    public void redirectToSignUpPage(ActionEvent event) throws IOException {
        redirect(event, "FXML-files/SignUpPage.fxml");
    }

    public void login(){
        // tries to login via database
    }

}
