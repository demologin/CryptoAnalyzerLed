package com.javarush.kazakov.controllers.screen;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.nio.file.Path;

public class AnalysisScreenController extends CommandScreenController {
    @FXML
    private VBox analyze;
    @FXML
    private Group representGroup;
    @FXML
    private Label representLabel;
    @FXML
    private TextField representTextField;
    @FXML
    private Hyperlink representBrowse;

    @Override
    protected void init() {
        super.init();
        switch (screen) {
            case BRUTE_FORCE -> analyze.getChildren().remove(representGroup);
            case ANALYSIS -> {
                representLabel.setText(inscriptions.getRepresent());
                representTextField.setText(inscriptions.getRepresentPath());
            }
        }

        representBrowse.setOnAction((e) -> openInputFileBrowse(inscriptions.getRepresentOpen(),
                Path.of(inscriptions.getRepresentPath()).getFileName().toString(),
                representTextField));

        submitButton.setOnAction((e) -> onSubmit(
                Path.of(inputTextField.getText()),
                Path.of(outputTextField.getText()),
                Path.of(representTextField.getText()),
                0));
    }
}
