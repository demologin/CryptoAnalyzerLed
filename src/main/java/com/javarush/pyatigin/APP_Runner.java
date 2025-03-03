package com.javarush.pyatigin;

import com.javarush.pyatigin.io.inputOutput;

public class APP_Runner {
    public static void main(String[] args) {
        while (true) {
            Menu menu = new Menu();
            int option = menu.menuOption();
            if (option == 4) {
                break;
            }
            GetOptions getOptions = new GetOptions(option);
            new inputOutput(getOptions);
            System.out.println("Congratulations, the file has been created");
            System.out.println("Select menu item for new operation or exit");
        }
    }
}