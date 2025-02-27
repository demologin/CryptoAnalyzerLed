package com.javarush.kazakov;

import com.javarush.kazakov.controllers.RootController;
import com.javarush.kazakov.controllers.screen.Screens;
import com.javarush.kazakov.controllers.style.Stylesheets;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import picocli.CommandLine.Command;

@Command(name = "gui", description = "Runs Caesar cipher at gui mode")
public class GUIMode extends Application implements Runnable {
    @Override
    public void run() {
        System.out.println("Application runs at gui mode");
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.centerOnScreen();
        primaryStage.setTitle("CryptoAnalyzer");
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/menuBar.fxml"));
        Pane root = loader.load();

        RootController rootController = RootController.getInstance();
        rootController.setRootNode(root);
        rootController.setCurrentScreen(Screens.WELCOME);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(Stylesheets.LIGHT.getStyle());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
