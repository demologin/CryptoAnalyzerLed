package com.javarush.pyatigin;

import com.javarush.pyatigin.io.InputOutput;

import java.nio.file.Path;

public class APP_Runner {
    public static void main(String[] args) {
        while (true) {
            Menu menu = new Menu();
            int option = menu.menuOption();
            if (option == 4) {
                break;
            }
            GetOptions getOptions = new GetOptions(option);
            InputOutput inputOutput = new InputOutput();
            Path fileOutput = inputOutput.inputOutput(getOptions);
            System.out.println("Congratulations, the file has been created " + fileOutput);
            System.out.println("Select menu item for new operation or exit");
        }
    }
}