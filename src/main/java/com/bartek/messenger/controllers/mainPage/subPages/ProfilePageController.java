package com.bartek.messenger.controllers.mainPage.subPages;

import com.bartek.messenger.dataRepresentation.User;
import com.bartek.messenger.utils.UserGetter;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfilePageController implements Initializable {
    private User currentUser = UserGetter.GET_CURRENT_USER();
    public Label usernameLabel;
    public Label createdAtLabel;
    public Label aboutLabel;

    private void setUsernameLabels(){
        usernameLabel.setText(currentUser.username);
        createdAtLabel.setText("Has account since "+currentUser.createdAt);
        aboutLabel.setText("About "+currentUser.username);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUsernameLabels();
    }
}
