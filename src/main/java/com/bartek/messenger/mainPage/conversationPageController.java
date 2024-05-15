package com.bartek.messenger.mainPage;

import com.bartek.messenger.User;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class conversationPageController implements Initializable {
    public Label usernameLabel;
    public Label activityLabel;
    User friend;
    private User getCurrentFriend(){
        // logic
        return new User("Cwaniak");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        friend = getCurrentFriend();
        usernameLabel.setText(friend.username);
        activityLabel.setText(friend.isOnline()+"");
    }
}
