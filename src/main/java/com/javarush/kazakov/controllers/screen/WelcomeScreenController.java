package com.javarush.kazakov.controllers.screen;

import com.javarush.kazakov.constants.inscriptions.ScreenText;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class WelcomeScreenController extends AbstractScreenController {
    @FXML
    public VBox welcomeScreen;
    @FXML
    private Text welcomeMessage;

    @Override
    public void init() {
        welcomeMessage.setText(ScreenText.valueOf(screen.name()).getInscriptions().getWelcome());
    }

}
