package com.javarush.ageev.fxcontrollers;


import javafx.scene.control.Alert;

import java.io.IOException;

public class ExceptionHandler {
    public static void handleException(IOException e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Input/Output Error");
        alert.setContentText(e.getMessage());

        alert.showAndWait();
    }

    private ExceptionHandler(){}
}
