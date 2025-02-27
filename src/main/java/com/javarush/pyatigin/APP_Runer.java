package com.javarush.pyatigin;

import com.javarush.pyatigin.encode.InputOutput;

public class APP_Runer {
    public static void main(String[] args) {
        Menu menu = new Menu();
        int option= menu.MenuOption();
        GetOptions getOptions = new GetOptions(option);
        InputOutput io = new InputOutput(getOptions);
        }
    }

