package com.javarush.pyatigin;

import com.javarush.pyatigin.io.InputOutput;

public class APP_Runner {
    public static void main(String[] args) {
        Menu menu = new Menu();
        int option = menu.MenuOption();
        GetOptions getOptions = new GetOptions(option);
        InputOutput io = new InputOutput(getOptions);
    }
}

