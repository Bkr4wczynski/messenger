package com.bartek.messenger.controllers.mainPage;

import com.bartek.messenger.MessengerApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class MainPageController {
    public AnchorPane anchorPane;
    private void changePage(String pageName){
        try {
            anchorPane.getChildren().clear();
            anchorPane.getChildren().add(
                    FXMLLoader.load(Objects.requireNonNull(MessengerApp.class.getResource(
                            "FXML-files/main/subPages/" + pageName + ".fxml"
                            ))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void changePageToFriendsPage(){
        changePage("friendsPage");

    }
    public void changePageToConversationPage(){
        changePage("conversationPage");

    }

    public void changePageToProfilePage(){
        changePage("profilePage");
    }
}
