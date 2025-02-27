package com.javarush.ageev.fxcontrollers.encryption;

import com.javarush.ageev.cryptocore.CaesarCipher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class EncryptFileController {

    private final int PREVIEW_BUFFER_SIZE = 400;
    @FXML
    public TextArea encryptedFileSample;
    @FXML
    public TextArea clearFileSample;
    @FXML
    public Spinner<Integer> shift;
    @FXML
    public TextField encryptedFilePath;
    @FXML
    public TextField clearFilePath;

    private final CaesarCipher cipher = new CaesarCipher();

    private File clearFile;
    private File encryptedFile;

    @FXML
    public void initialize() {
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, cipher.getMaxOffset(), cipher.getOffset());
        shift.setValueFactory(valueFactory);
        shift.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            cipher.setOffset(newValue);
            previewEncryptedFile();
        });
    }

    public void clearFileOpenAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выберите файл");

        Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();

        clearFile = fileChooser.showOpenDialog(stage);

        if (clearFile != null) {
            clearFilePath.setText(clearFile.getAbsolutePath());
            encryptedFile = new File(clearFile.getAbsolutePath().concat(".enc"));
            encryptedFilePath.setText(encryptedFile.getAbsolutePath());
            previewClearFile();
        }
    }

    public void encryptedOpenAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выберите файл");

        Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();

        encryptedFile = fileChooser.showSaveDialog(stage);

        if (encryptedFile != null) {
            encryptedFilePath.setText(encryptedFile.getAbsolutePath());
        }
    }

    public void encryptAction(ActionEvent actionEvent) {
        cipher.fileEncrypt(clearFile.toPath(), encryptedFile.toPath());
    }

    private void previewClearFile() {
        try (BufferedReader reader = Files.newBufferedReader(clearFile.toPath())) {
            char[] buffer = new char[PREVIEW_BUFFER_SIZE];
            int bytesRead = reader.read(buffer, 0, PREVIEW_BUFFER_SIZE);
            String previewString = new String(buffer, 0, bytesRead);

            clearFileSample.setText(previewString);
            previewEncryptedFile();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void previewEncryptedFile() {
        encryptedFileSample.setText(cipher.textEncrypt(clearFileSample.getText()));
    }
}
