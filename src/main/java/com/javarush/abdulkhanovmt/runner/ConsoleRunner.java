package com.javarush.abdulkhanovmt.runner;

import com.javarush.abdulkhanovmt.controller.MainController;
import com.javarush.abdulkhanovmt.functionality.Const;

public class ConsoleRunner {

    public static void main(String[] args) {
        MainController mainController = new MainController(Const.SOURCE_FILE_NAME,
                Const.ENCODED_FILE_NAME,
                Const.DECODED_FILE_NAME,
                Const.BRUTEFORCED_FILE_NAME,
                Const.ANALYZE_FILE_NAME);
        mainController.run();

    }
}
