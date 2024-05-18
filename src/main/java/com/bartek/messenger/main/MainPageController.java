package com.bartek.messenger.main;

import com.bartek.messenger.MessengerApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class MainPageController {
    public AnchorPane anchorPane;

    public void changePageToFriendsPage(){
        try {
            anchorPane.getChildren().clear();
            anchorPane.getChildren().add(
                    FXMLLoader.load(Objects.requireNonNull(MessengerApp.class.getResource("FXML-files/main/friendsPage.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void changePageToConversationPage(){
        try {
            anchorPane.getChildren().clear();
            anchorPane.getChildren().add(
                    FXMLLoader.load(Objects.requireNonNull(MessengerApp.class.getResource("FXML-files/main/conversationPage.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
