package com.javarush.apalinskiy.view;

import com.javarush.apalinskiy.constants.Const;

import java.nio.file.Path;

public class Massages {
    public void getMassage(Path path, String str) {
        String pathMassage = "Enter the " + str + " path or the name of the file in the" +
                " format \"File Name.txt \" or press Enter to select the default.";
        String def = "Default - ";
        System.out.println(Const.ANSI_YELLOW + pathMassage + "\n" + def + path);
    }

    public void getDone() {
        String allDone = "All done!";
        System.out.println(Const.ANSI_GREEN + allDone);
    }

    public void getKey() {
        String key = "Enter key from 1 to 80!";
        System.out.println(key);
    }

}
