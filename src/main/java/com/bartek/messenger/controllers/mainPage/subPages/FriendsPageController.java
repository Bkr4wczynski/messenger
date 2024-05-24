package com.bartek.messenger.controllers.mainPage.subPages;

import com.bartek.messenger.utils.SubPageChanger;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

public class FriendsPageController {
    public FriendsListPageController friendsListPageController;
    public AnchorPane friendsListPage;

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

    private void displayFriendsListPage(){
        SubPageChanger.changePage(friendsListPage, "friendsListPage");
    }
    public void displayAddFriendPage(){
        SubPageChanger.changePage(friendsListPage, "addFriendPage");
    }
}
