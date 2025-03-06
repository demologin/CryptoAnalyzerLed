package com.javarush.kazakov.controllers;

import com.javarush.kazakov.controllers.screen.Screens;
import com.javarush.kazakov.util.SwitchButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;


public class MenuBarController implements Initializable {
    @FXML
    private HBox root;
    @FXML
    private VBox menuBar;
    @FXML
    private Label menuLabel;
    @FXML
    private Button encryptButton;
    @FXML
    private Button decryptButton;
    @FXML
    private Button bruteForceButton;
    @FXML
    private Button analysisButton;

    RootController rootController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rootController = RootController.getInstance();
        menuLabel.setText("CryptoAnalyzer");
        menuBar.getChildren().add(0, new SwitchButton(50,25));
        encryptButton.setOnAction((event) -> rootController.setCurrentScreen(Screens.ENCRYPT));
        decryptButton.setOnAction((event) -> rootController.setCurrentScreen(Screens.DECRYPT));
        bruteForceButton.setOnAction((event) -> rootController.setCurrentScreen(Screens.BRUTE_FORCE));
        analysisButton.setOnAction((event) -> rootController.setCurrentScreen(Screens.ANALYSIS));
    }
}
