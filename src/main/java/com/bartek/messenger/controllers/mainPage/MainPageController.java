package com.bartek.messenger.controllers.mainPage;

import com.bartek.messenger.utils.SubPageChanger;
import javafx.scene.layout.AnchorPane;

public class MainPageController {
    public AnchorPane anchorPane;

    public void changePageToFriendsPage(){
        SubPageChanger.changePage(anchorPane, "friendsPage");

    }
    public void changePageToConversationPage(){
        SubPageChanger.changePage(anchorPane, "conversationPage");

    }

    public void changePageToProfilePage(){
        SubPageChanger.changePage(anchorPane, "profilePage");
    }
}
