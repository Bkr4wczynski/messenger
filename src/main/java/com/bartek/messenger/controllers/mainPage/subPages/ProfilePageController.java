package com.bartek.messenger.controllers.mainPage.subPages;

import com.bartek.messenger.dataRepresentation.User;
import com.bartek.messenger.utils.UserGetter;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfilePageController implements Initializable {
    private final User user = UserGetter.GET_CURRENT_USER();
    public Label usernameLabel;
    public Label createdAtLabel;
    public Label aboutLabel;

    private void setUsernameLabels(){
        usernameLabel.setText(user.username);
        createdAtLabel.setText("Has account since "+ user.createdAt);
        aboutLabel.setText("About "+ user.username);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUsernameLabels();
    }
}
