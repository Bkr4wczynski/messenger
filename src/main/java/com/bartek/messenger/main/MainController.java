package com.bartek.messenger.main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private LeftPanelController leftPanelController;
    @FXML
    MainPageController mainPageController;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        leftPanelController.setParentController(this);
    }
    public void changeMainPageToFriendsPage(){
        mainPageController.changePageToFriendsPage();
    }
    public void changeMainPageToProfilePage(){
        mainPageController.changePageToProfilePage();
    }
}
