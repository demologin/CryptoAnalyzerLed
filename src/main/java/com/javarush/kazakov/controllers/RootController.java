package com.javarush.kazakov.controllers;

import com.javarush.kazakov.controllers.screen.Screens;
import com.javarush.kazakov.controllers.style.Stylesheets;
import com.javarush.kazakov.util.SwitchButton;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class RootController {
    private static final RootController INSTANCE;
    private Screens currentScreen;
    private Pane currentPane;
    private Pane rootNode;

    static {
        INSTANCE = new RootController();
    }

    private RootController() {
    }

    public static RootController getInstance() {
        return INSTANCE;
    }

    public Screens getCurrentScreen() {
        return currentScreen;
    }

    public void setCurrentScreen(Screens screen) {
        setCurrentScreen(screen, screen.getScreen());
    }

    public void setCurrentScreen(Screens screen, Pane newPane) {
        if (currentScreen == screen) {
            return;
        }
        ObservableList<Node> children = rootNode.getChildren();
        if (currentPane != null) {
            children.remove(currentPane);
        }
        currentScreen = screen;
        currentPane = newPane;
        children.add(currentPane);
    }

    public void setRootNode(Pane rootNode) {
        this.rootNode = rootNode;
        setSwitchNode(rootNode);
    }

    private void setSwitchNode(Pane rootNode) {
        ((SwitchButton) findStyleSwitchNode(rootNode)).getLeftProperty().addListener(this::changeStyle);
    }

    private Node findStyleSwitchNode(Pane rootNode) {
        for (Node child : rootNode.getChildren()) {
            if (child.getId().equals("menuBar")) {
                for (Node child2 : ((VBox) child).getChildren()) {
                    if (child2.getId().equals("switchButton")) {
                        return child2;
                    }
                }

            }
        }
        return new Pane(new Label("switchButton not found"));
    }

    private void changeStyle(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        ObservableList<String> stylesheets = rootNode.getScene().getStylesheets();
        stylesheets.clear();
        if (newValue) {
            stylesheets.add(Stylesheets.LIGHT.getStyle());
        } else {
            stylesheets.add(Stylesheets.DARK.getStyle());
        }
    }
}
