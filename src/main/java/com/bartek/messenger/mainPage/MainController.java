package com.bartek.messenger.mainPage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private LeftPanelController leftPanelController;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        leftPanelController.setParentController(this);
    }
    public void test(){
        System.out.println("SEKS");
    }
}
