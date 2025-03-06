package com.javarush.apalinskiy.view;

import com.javarush.apalinskiy.constants.Const;

import java.nio.file.Path;

public class Messages {
    public void getMessage(Path path, String str) {
        String pathMassage = "\nEnter the " + str + " path or the name of the file in the" +
                " format \"File Name.txt \" or press Enter to select the default.";
        String def = "Default - ";
        System.out.println(Const.ANSI_YELLOW + pathMassage + "\n" + def + path + "\n");
    }

    public void getDone() {
        String allDone = "\nAll done!\n";
        System.out.println(Const.ANSI_GREEN + allDone);
    }

    public void getKey() {
        String key = "\nEnter key from 1 to 80!\n";
        System.out.println(key);
    }

}
