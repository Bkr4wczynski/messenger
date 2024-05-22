package com.bartek.messenger.controllers.mainPage.subPages;

import com.bartek.messenger.dataRepresentation.User;
import com.bartek.messenger.dataRepresentation.Gender;
import com.bartek.messenger.utils.UserGetter;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class ConversationPageController implements Initializable {
    public Label usernameLabel;
    public Label activityLabel;
    User user;
    User friend;
    private User getCurrentFriend(){
        // logic
        return new User(5, "Cwaniak", Gender.male, LocalDate.now());
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
