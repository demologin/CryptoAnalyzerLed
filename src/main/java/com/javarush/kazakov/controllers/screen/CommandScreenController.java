package com.javarush.kazakov.controllers.screen;

import com.javarush.kazakov.commands.*;
import com.javarush.kazakov.constants.Constants;
import com.javarush.kazakov.constants.inscriptions.Inscriptions;
import com.javarush.kazakov.constants.inscriptions.ScreenText;
import com.javarush.kazakov.controllers.Result;
import com.javarush.kazakov.controllers.RootController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.nio.file.Path;

public class CommandScreenController extends AbstractScreenController {
    @FXML
    private Label modeLabel;
    @FXML
    private Label inputLabel;
    @FXML
    private Hyperlink inputBrowse;
    @FXML
    private Label outputLabel;
    @FXML
    private Hyperlink outputBrowse;
    @FXML
    private Text exceptionText;

    private FileChooser fileChooser;
    @FXML
    protected Button submitButton;
    @FXML
    protected TextField outputTextField;
    @FXML
    protected TextField inputTextField;

    protected Inscriptions inscriptions;

    @Override
    protected void init() {
        inscriptions = ScreenText.valueOf(screen.name()).getInscriptions();
        modeLabel.setText(inscriptions.getMode());
        inputLabel.setText(inscriptions.getInput());
        outputLabel.setText(inscriptions.getOutput());
        inputTextField.setText(inscriptions.getInputPath());

        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        exceptionText.setVisible(false);

        inputBrowse.setOnAction((e) -> openInputFileBrowse(inscriptions.getOpen(),
                Path.of(inscriptions.getInputPath()).getFileName().toString(),
                inputTextField));
        outputBrowse.setOnAction(this::onOutputFileBrowse);
    }

    protected void openInputFileBrowse(String title, String filename, TextField textField) {
        fileChooser.setTitle(title);
        fileChooser.setInitialDirectory(new File(Constants.DEFAULT_TEXT_FOLDER));
        fileChooser.setInitialFileName(filename);
        File file = fileChooser.showOpenDialog(inputBrowse.getScene().getWindow());
        if (file != null) {
            textField.setText(file.getAbsolutePath());
        }
    }

    protected void onSubmit(Path input, Path output, Path represent, int key) {
        exceptionText.setVisible(false);
        AbstractCommand command;
        switch (screen) {
            case ENCRYPT -> command = new Encrypt(input, output, key);
            case DECRYPT -> command = new Decrypt(input, output, key);
            case BRUTE_FORCE -> command = new BruteForce(input);
            case ANALYSIS -> command = new StatAnalysis(input, represent);
            default -> command = Commands.NOOP.getCommand();
        }
        try {
            String result = command.call();
            if (!output.toString().isEmpty()
                    && (screen == Screens.BRUTE_FORCE || screen == Screens.ANALYSIS)) {
                result += "\n" + new Decrypt(input, output, command.getKey()).call();
            }
            VBox resultScreen = new Result(result, output).generateResult();
            RootController.getInstance().setCurrentScreen(Screens.RESULT, resultScreen);
        } catch (Exception e) {
            exceptionText.setVisible(true);
            exceptionText.setText(e.getMessage());
        }
    }

    private void onOutputFileBrowse(ActionEvent ignore) {
        if (inscriptions.getOutputPath() != null) {
            fileChooser.setInitialFileName(Path.of(inscriptions.getOutputPath()).getFileName().toString());
        }
        fileChooser.setTitle(inscriptions.getSave());
        fileChooser.setInitialDirectory(new File(Constants.DEFAULT_TEXT_FOLDER));
        File file = fileChooser.showSaveDialog(outputBrowse.getScene().getWindow());
        if (file != null) {
            outputTextField.setText(file.getAbsolutePath());
        }
    }
}
