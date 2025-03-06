package com.javarush.ageev.fxcontrollers.encryption;

import com.javarush.ageev.cryptocore.Caesar;
import com.javarush.ageev.fxcontrollers.ExceptionHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;

import java.io.IOException;


public class EncryptTextController {
    @FXML
    private TextArea decryptedText;
    @FXML
    private TextArea encryptedText;
    @FXML
    private Spinner<Integer> shift;
    private Caesar cipher;

    public void initialize() {
        try {
            cipher = new Caesar();
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }

        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, cipher.getMaxShift(), cipher.getShift());
        shift.setValueFactory(valueFactory);
        shift.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            cipher.setShift(newValue);
            encryptedText.setText(cipher.encrypt(decryptedText.getText()));
        });
    }



    public void encryptAction() {
        encryptedText.setText(cipher.encrypt(decryptedText.getText()));
    }
}
