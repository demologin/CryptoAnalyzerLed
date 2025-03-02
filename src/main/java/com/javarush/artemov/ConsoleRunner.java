package com.javarush.artemov;

import com.javarush.artemov.console.Menu;
import com.javarush.artemov.controller.InputOutput;

public class ConsoleRunner {
    public static void main(String[] args) {
        Menu menu = new Menu();
        InputOutput inputOutput = new InputOutput();

        String[] inputData = menu.getInputData();
        inputOutput.encryptDecryptFile(inputData);

    }
}
