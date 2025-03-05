package com.javarush.ageev.fxcontrollers.crack;

import com.javarush.ageev.cryptocore.BruteForce;
import com.javarush.ageev.cryptocore.BruteForceEntry;
import com.javarush.ageev.fxcontrollers.FileSelector;
import com.javarush.ageev.fxcontrollers.FileSelectorEnum;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;

public class BruteForceController {
    public TableColumn<BruteForceEntry, Integer> shiftColumn;
    public TableColumn<BruteForceEntry, Integer> spaceCountColumn;
    public TableColumn<BruteForceEntry, String> decryptedPreviewColumn;
    public TableView<BruteForceEntry> bruteForceTable;
    public TextField encryptedFilePath;

    private File encryptedFile;

    public void initialize() {
        shiftColumn.setCellValueFactory(new PropertyValueFactory<>("key"));
        spaceCountColumn.setCellValueFactory(new PropertyValueFactory<>("spaceCount"));
        decryptedPreviewColumn.setCellValueFactory(new PropertyValueFactory<>("decryptedPreview"));
    }

    public void encryptedFileOpenAction(ActionEvent actionEvent) {
        encryptedFile = FileSelector.fileDialog(actionEvent, FileSelectorEnum.OPEN_DIALOG);

        if (encryptedFile != null) {
            encryptedFilePath.setText(encryptedFile.getAbsolutePath());
        }
    }

    public void bruteForce(ActionEvent actionEvent) {
        BruteForce bruteForce = new BruteForce(encryptedFile.toPath());
        ObservableList<BruteForceEntry> data = FXCollections.observableArrayList();
        data.setAll(bruteForce.getBruteForceList());
        bruteForceTable.setItems(data);
    }
}
