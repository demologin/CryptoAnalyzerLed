package com.javarush.zhdanovskikh;

import java.io.File;

public class Constants {
    private static final String RUS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String ENG = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS ="0123456789";
    private static final String SIGNS = "~!@#$%^&*()_+-=`{}|[];':,.<>/? ";
    public static final String ALPHABET = RUS + ENG + RUS.toUpperCase()+ ENG.toUpperCase() + SIGNS + NUMBERS;
    public static final String TXT_FOLDER = System.getProperty("user.dir") +
            File.separator +
            "text" +
            File.separator;
}
