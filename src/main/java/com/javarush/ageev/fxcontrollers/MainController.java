package com.javarush.ageev.fxcontrollers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainController {
    @FXML
    private BorderPane templateContainer;

    private void changeTemplate(String templateName) throws IOException {
        if (templateName != null) {
            AnchorPane newTemplate = FXMLLoader.load(getClass().getResource(templateName));
            templateContainer.setCenter(newTemplate);
        }
    }


    public void menuItemAction(ActionEvent actionEvent) throws IOException {

        MenuItem selectedMenuItem = (MenuItem) actionEvent.getSource();

        switch (selectedMenuItem.getId()) {
            case "menuItemClose": Platform.exit(); break;
            case "menuItemEncText": changeTemplate("/ageev/view/encryption/encryptText.fxml"); break;
            case "menuItemDecText": changeTemplate("/ageev/view/encryption/decryptText.fxml"); break;
            case "menuItemEncFile": changeTemplate("/ageev/view/encryption/encryptFile.fxml"); break;
            case "menuItemDecFile": changeTemplate("/ageev/view/encryption/decryptFile.fxml"); break;
            case "menuItemBruteForce": changeTemplate("/ageev/view/crack/bruteForce.fxml"); break;
            case "menuItemStatAnalysis": changeTemplate("/ageev/view/crack/statisticalAnalysis.fxml"); break;
            default: changeTemplate("/ageev/view/welcome.fxml"); break;
        }

    }


}
