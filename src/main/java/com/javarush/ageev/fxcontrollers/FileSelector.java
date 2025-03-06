package com.javarush.ageev.fxcontrollers;

import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.Objects;

public class FileSelector {
    public static File fileDialog(ActionEvent actionEvent, FileSelectorEnum type) {
        Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выберите файл");

        if (Objects.requireNonNull(type) == FileSelectorEnum.OPEN_DIALOG) {
            return fileChooser.showOpenDialog(stage);
        } else if (type == FileSelectorEnum.SAVE_DIALOG) {
            return fileChooser.showSaveDialog(stage);
        }

        return null;
    }

    private FileSelector() {}
}
