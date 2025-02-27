package com.javarush.kazakov.controllers.screen;

public abstract class AbstractScreenController {
    protected Screens screen;

    public void setScreen(Screens screen) {
        this.screen = screen;
    }

    protected abstract void init();
}
