package com.bartek.messenger.controllers.mainPage.subPages;

import com.bartek.messenger.MessengerApp;
import com.bartek.messenger.client.Client;
import com.bartek.messenger.dataRepresentation.User;
import com.bartek.messenger.database.MessengerDatabaseDAO;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddFriendPageController {
    public Label responseLabel;
    public TextField searchBar;
    private Client client = MessengerApp.client;
    public void sendFriendRequest(){
        try {
            User user = client.getUserByUsername(searchBar.getText());
            System.out.println(user.username);
        } catch (ClassNotFoundException e) {
            responseLabel.setText("User not found!");
        }
    }

}
