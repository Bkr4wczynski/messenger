package com.bartek.messenger.main;

import com.bartek.messenger.User;
import com.bartek.messenger.Gender;
import com.bartek.messenger.database.UserGetter;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class ConversationPageController implements Initializable {
    public Label usernameLabel;
    public Label activityLabel;
    User user;
    User friend;
    private User getCurrentFriend(){
        // logic
        return new User("Cwaniak", 5, Gender.Male, LocalDateTime.now());
    }
    private User getCurrentUser(){
        return UserGetter.GET_CURRENT_USER();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        friend = getCurrentFriend();
        user = getCurrentUser();
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
