package com.bartek.messenger.main;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FriendsListPageController {
    public Label displayLabel;
    int numberOfOnline = 0;
    int numberOfFriends = 0;
    int numberOfWaiting = 0;
    int numberOfBlocked = 0;

    public void changeDisplayLabelText(ActionEvent event){
        String buttonText = ((Button) event.getSource()).getText();
        String newText = switch (buttonText) {
            case "Available" -> "Available online - " + numberOfOnline;
            case "All" -> "All friends - " + numberOfFriends;
            case "Waiting" -> "Waiting - " + numberOfWaiting;
            case "Blocked" -> "Blocked - " + numberOfBlocked;
            default -> "";
        };
        displayLabel.setText(newText);
    }
}
