package com.bartek.messenger.controllers.mainPage;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class LeftPanelController implements Initializable {
    private MainController parentController;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    public void setParentController(MainController parentController){
        this.parentController = parentController;
    }

    public void loadFriendsPage(){
        parentController.changeMainPageToFriendsPage();
    }
    public void displayProfile(){
        parentController.changeMainPageToProfilePage();
    }
}
