package com.bartek.messenger.mainPage;

import com.bartek.messenger.User;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class conversationPageController implements Initializable {
    public Label usernameLabel;
    public Label activityLabel;
    User user;
    User friend;
    private User getCurrentFriend(){
        // logic
        return new User("Cwaniak");
    }
    private User getCurrentUser(){
        // logic
        return new User("Current user");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        friend = getCurrentFriend();
        usernameLabel.setText(friend.username);
        activityLabel.setText(friend.isOnline()+"");
    }
    public void muteFriend(ActionEvent event){
        CheckBox checkBox = (CheckBox) event.getSource();
        if (checkBox.isSelected()){
            user.mute(friend);
        }
        else {
            user.unMute(friend);
        }
    }
}
