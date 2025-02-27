package com.javarush.kazakov.util;

public class Utils {
    public static String capitalize(String str) {
        str = str.replace("_", " ");
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
