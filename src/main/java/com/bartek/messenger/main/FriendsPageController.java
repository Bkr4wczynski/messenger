package com.bartek.messenger.main;

import javafx.event.ActionEvent;

public class FriendsPageController {
    public FriendsListPageController friendsListPageController;

    public void showAvailable(ActionEvent event){
        friendsListPageController.changeDisplayLabelText(event);
    }
    public void showAll(ActionEvent event){
        friendsListPageController.changeDisplayLabelText(event);
    }
    public void showWaiting(ActionEvent event){
        friendsListPageController.changeDisplayLabelText(event);
    }
    public void showBlocked(ActionEvent event){
        friendsListPageController.changeDisplayLabelText(event);
    }
}
