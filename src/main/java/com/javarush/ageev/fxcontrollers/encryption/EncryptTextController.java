package com.javarush.ageev.fxcontrollers.encryption;

import com.javarush.ageev.cryptocore.Caesar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;


public class EncryptTextController {
    @FXML
    private TextArea decryptedText;
    @FXML
    private TextArea encryptedText;
    @FXML
    private Spinner<Integer> shift;
    private final Caesar cipher = new Caesar();

    @FXML
    public void initialize() {
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, cipher.getMaxShift(), cipher.getShift());
        shift.setValueFactory(valueFactory);
        shift.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            cipher.setShift(newValue);
            encryptedText.setText(cipher.encrypt(decryptedText.getText()));
        });
    }



    public void encryptAction(ActionEvent actionEvent) {
        encryptedText.setText(cipher.encrypt(decryptedText.getText()));
    }
}
