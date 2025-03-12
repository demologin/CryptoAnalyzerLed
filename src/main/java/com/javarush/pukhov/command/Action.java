package com.javarush.pukhov.command;

import java.util.List;

public interface Action {
    public void execute(List<String> parameters);
}
