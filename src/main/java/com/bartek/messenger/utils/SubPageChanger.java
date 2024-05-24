package com.bartek.messenger.utils;

import com.bartek.messenger.MessengerApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class SubPageChanger {
    public static void changePage(AnchorPane anchorPane, String pageName){
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
}
