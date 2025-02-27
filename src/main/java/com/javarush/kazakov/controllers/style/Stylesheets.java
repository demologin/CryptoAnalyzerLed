package com.javarush.kazakov.controllers.style;

import java.util.Objects;

public enum Stylesheets {
    DARK(Objects.requireNonNull(Stylesheets.class.getResource("/css/dark.css")).toExternalForm()),
    LIGHT(Objects.requireNonNull(Stylesheets.class.getResource("/css/light.css")).toExternalForm());

    final String style;

    Stylesheets(String style) {
        this.style = style;
    }
    public String getStyle() {
        return style;
    }
}
