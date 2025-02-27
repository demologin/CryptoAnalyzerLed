package com.javarush.kazakov.controllers.screen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ResultScreenController extends AbstractScreenController {
    @FXML
    private VBox resultScreen;
    @FXML
    private Text resultText;
    @FXML
    private Label resultLabel;
    @FXML
    private Text example;

    @Override
    protected void init() {
    }

    public void setResultText(String resultText) {
        this.resultText.setText(resultText);
    }

    public void setExample(String example) {
        this.example.setText(example);
    }

    public Label getResultLabel() {
        return resultLabel;
    }
}
