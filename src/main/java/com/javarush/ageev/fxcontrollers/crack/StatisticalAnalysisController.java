package com.javarush.ageev.fxcontrollers.crack;

import com.javarush.ageev.cryptocore.StatisticalAnalyzer;
import com.javarush.ageev.fxcontrollers.FileSelector;
import com.javarush.ageev.fxcontrollers.FileSelectorEnum;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.File;
import java.nio.file.Path;

public class StatisticalAnalysisController {
    public TextField exampleFilePath;
    private Path exampleFile;
    public TextField encryptedFilePath;

    StatisticalAnalyzer analyzer = new StatisticalAnalyzer(); //TODO Refactor

    public void exampleFileOpenAction(ActionEvent actionEvent) {
        File file = FileSelector.fileDialog(actionEvent, FileSelectorEnum.OPEN_DIALOG);
        if (file != null) {
            exampleFilePath.setText(file.getAbsolutePath());
            analyzer.setExampleFilePath(file.toPath());
        }
    }

    public void encryptedFileOpenAction(ActionEvent actionEvent) {
    }

    public void analyseAction(ActionEvent actionEvent) {
        System.out.println(analyzer.analyze());
    }

    public void decryptAction(ActionEvent actionEvent) {
    }
}
