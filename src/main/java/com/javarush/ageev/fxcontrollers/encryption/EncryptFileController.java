package com.javarush.ageev.fxcontrollers.encryption;

import com.javarush.ageev.cryptocore.Caesar;
import com.javarush.ageev.fxcontrollers.ExceptionHandler;
import com.javarush.ageev.fxcontrollers.FileSelector;
import com.javarush.ageev.fxcontrollers.FileSelectorEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;


public class EncryptFileController {

    private static final int PREVIEW_BUFFER_SIZE = 400;
    @FXML
    public TextArea encryptedFileSample;
    @FXML
    public TextArea decryptedFileSample;
    @FXML
    public Spinner<Integer> shift;
    @FXML
    public TextField encryptedFilePath;
    @FXML
    public TextField decryptedFilePath;

    private Caesar cipher;

    private File decryptedFile;
    private File encryptedFile;

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
            preview();
        });
    }

    public void decryptedFileOpenAction(ActionEvent actionEvent) {


        decryptedFile = FileSelector.fileDialog(actionEvent, FileSelectorEnum.OPEN_DIALOG);

        if (decryptedFile != null) {
            decryptedFilePath.setText(decryptedFile.getAbsolutePath());
            encryptedFile = new File(decryptedFile.getAbsolutePath().concat(".enc"));
            encryptedFilePath.setText(encryptedFile.getAbsolutePath());
            preview();
        }
    }

    public void encryptedOpenAction(ActionEvent actionEvent) {


        encryptedFile = decryptedFile = FileSelector.fileDialog(actionEvent, FileSelectorEnum.SAVE_DIALOG);

        if (encryptedFile != null) {
            encryptedFilePath.setText(encryptedFile.getAbsolutePath());
        }
    }

    public void encryptAction() {
        try {
            cipher.encrypt(decryptedFile.toPath(), encryptedFile.toPath());
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    private void preview() {


        try {
            decryptedFileSample.setText(cipher.getSample(decryptedFile.toPath(), PREVIEW_BUFFER_SIZE));
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
        encryptedFileSample.setText(cipher.encrypt(decryptedFileSample.getText()));


    }

}
