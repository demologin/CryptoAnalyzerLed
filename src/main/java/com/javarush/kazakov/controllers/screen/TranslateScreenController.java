package com.javarush.kazakov.controllers.screen;

import com.javarush.kazakov.constants.Constants;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.nio.file.Path;

public class TranslateScreenController extends CommandScreenController {
    @FXML
    private VBox translate;
    @FXML
    private Spinner<Integer> keySpinner;

    @Override
    protected void init() {
        super.init();
        outputTextField.setText(inscriptions.getOutputPath());

        SpinnerValueFactory.IntegerSpinnerValueFactory intValueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Constants.ALPHABET.length);
        intValueFactory.setValue(1);
        keySpinner.setValueFactory(intValueFactory);
        keySpinner.setEditable(true);

        submitButton.setOnAction((e) -> onSubmit(
                Path.of(inputTextField.getText()),
                Path.of(outputTextField.getText()),
                Path.of(""),
                keySpinner.getValue()));
    }
}
