package com.javarush.kazakov.controllers.screen;

import com.javarush.kazakov.util.Utils;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.nio.file.Path;
import java.util.MissingResourceException;

public enum Screens {
    WELCOME("/fxml/welcomeScreen.fxml"),
    ENCRYPT("/fxml/translateScreen.fxml"),
    DECRYPT("/fxml/translateScreen.fxml"),
    BRUTE_FORCE("/fxml/analysisScreen.fxml"),
    ANALYSIS("/fxml/analysisScreen.fxml"),
    RESULT("/fxml/resultScreen.fxml");

    private VBox screen;
    private final String path;

    Screens(String path) {
        this.path = path;
    }

    public VBox getScreen() {
        if (screen == null) {
            screen = load();
        }
        return screen;
    }

    public String getPath() {
        return path;
    }

    private VBox load() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            VBox vBox = loader.load();
            AbstractScreenController controller = loader.getController();
            controller.setScreen(this);
            controller.init();
            return vBox;
        } catch (IOException e) {
            throw new MissingResourceException("Missing fxml resource", Screens.class.getSimpleName(), Path.of(path).getFileName().toString());
        }
    }

    @Override
    public String toString() {
        return Utils.capitalize(this.name());
    }
}
