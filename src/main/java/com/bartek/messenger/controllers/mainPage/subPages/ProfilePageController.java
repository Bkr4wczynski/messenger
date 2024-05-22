package com.bartek.messenger.controllers.mainPage.subPages;

import com.bartek.messenger.utils.UserGetter;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfilePageController implements Initializable {
    public Label usernameLabel;

    private void setUsernameLabelText(){
        usernameLabel.setText(UserGetter.GET_CURRENT_USER().username);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUsernameLabelText();
    }
}
