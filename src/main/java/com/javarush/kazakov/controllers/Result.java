package com.javarush.kazakov.controllers;

import com.javarush.kazakov.controllers.screen.ResultScreenController;
import com.javarush.kazakov.controllers.screen.Screens;
import com.javarush.kazakov.core.exceptions.CryptoAnalyzerException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.MissingResourceException;

public class Result {
    private final String result;
    private final Path output;
    private final String example;

    public Result(String result, Path output) {
        this.result = result;
        this.output = output;
        this.example = loadOutputChunk();
    }

    public VBox generateResult() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Screens.RESULT.getPath()));
            VBox vBox = loader.load();
            ResultScreenController controller = loader.getController();
            if (example.isEmpty()){
                controller.getResultLabel().setVisible(false);
            }
            controller.setResultText(result);
            controller.setExample(example);
            return vBox;
        } catch (IOException e) {
            throw new MissingResourceException("Missing fxml resource",
                    Screens.class.getSimpleName(),
                    Path.of(Screens.RESULT.getPath()).getFileName().toString());
        }

    }

    private String loadOutputChunk() {
        if (output.toString().isEmpty()) {
            return "";
        }
        String chunk;
        int chunkSize = 300;
        try (Reader reader = Files.newBufferedReader(output)) {
            char[] buffer = new char[chunkSize];
            int read = reader.read(buffer);
            chunk = new String(buffer, 0, read);
            chunk = read < chunkSize ? chunk : chunk + "...";
        } catch (IOException e) {
            throw new CryptoAnalyzerException("Unable to load file " + e);
        }
        return chunk;
    }
}
