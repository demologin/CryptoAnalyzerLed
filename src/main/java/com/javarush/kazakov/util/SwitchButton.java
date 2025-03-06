package com.javarush.kazakov.util;

import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class SwitchButton extends Group {
    private static final int ANIMATION_DURATION = 300;
    private final Circle circle;
    private final int width;
    private final int height;
    private final double radius;
    private boolean left;
    private final SimpleBooleanProperty leftProperty;

    public SwitchButton(int width, int height) {
        left = true;
        leftProperty = new SimpleBooleanProperty(left);
        this.width = width;
        this.height = height;
        radius = height / 2.;
        circle = getCircle();
        getChildren().addAll(getRectangle(), circle);
        setId("switchButton");
        getStyleClass().add("switch-button");
        setOnMouseClicked(this::switchState);
    }

    private void switchState(MouseEvent ignore) {
        left = !left;
        leftProperty.set(left);
        TranslateTransition translateTransition =
                new TranslateTransition(Duration.millis(ANIMATION_DURATION), circle);
        if (left) {
            translateTransition.setFromX(width - height);
            translateTransition.setToX(0);
            translateTransition.play();
        } else {
            translateTransition.setFromX(0);
            translateTransition.setToX(width - height);
            translateTransition.play();
        }
    }

    private Rectangle getRectangle() {
        Rectangle rectangle = new Rectangle(width, height, Paint.valueOf("#494949"));
        rectangle.setArcWidth(height);
        rectangle.setArcHeight(height);
        rectangle.getStyleClass().add("switch-rectangle");
        return rectangle;
    }

    private Circle getCircle() {
        Circle circle = new Circle(radius, radius, radius, Paint.valueOf("#929292"));
        circle.getStyleClass().add("switch-circle");
        return circle;
    }

    public SimpleBooleanProperty getLeftProperty() {
        return leftProperty;
    }
}
