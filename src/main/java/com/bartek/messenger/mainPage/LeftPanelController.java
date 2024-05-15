package com.bartek.messenger.mainPage;

import javafx.fxml.Initializable;
import javafx.scene.Node;

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
        parentController.test();
    }
    public void displayProfile(){

    }
}
