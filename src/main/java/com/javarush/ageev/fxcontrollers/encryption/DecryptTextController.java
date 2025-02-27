package com.javarush.ageev.fxcontrollers.encryption;


import com.javarush.ageev.cryptocore.CaesarCipher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;

public class DecryptTextController {
    @FXML
    private TextArea clearText;
    @FXML
    private TextArea encryptedText;
    @FXML
    private Spinner<Integer> shift;
    private final CaesarCipher cipher = new CaesarCipher();

    @FXML
    public void initialize() {
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, cipher.getMaxOffset(), cipher.getOffset());
        shift.setValueFactory(valueFactory);
        shift.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            cipher.setOffset(newValue);
            clearText.setText(cipher.textDecrypt(encryptedText.getText()));
        });
    }



    public void decryptAction(ActionEvent actionEvent) {
        clearText.setText(cipher.textDecrypt(encryptedText.getText()));
    }
}
