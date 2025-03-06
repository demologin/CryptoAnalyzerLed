package com.javarush.apalinskiy.exceptions;

import com.javarush.apalinskiy.constants.Const;

import java.nio.file.Path;


public class ExceptionMessage {
    private static final String message = Const.ANSI_RED + "\nIncorrect number.\n";
    private static final String bruteforceMessage = Const.ANSI_RED + "\nError, couldn't be decrypted. Possible reasons: \n " +
            "- the file is too small; \n" +
            "- the file encoding is different or too complicated.\n";
    private static final String suchFileExc = Const.ANSI_RED + "\nIncorrect path.\n";
    private static final String ioExc = Const.ANSI_RED + "\nInput and output error\n";
    private static final String nfExc = Const.ANSI_RED + "\nIt's not a number.\n";

    public static String getSuchFileExc(Path path) {
        return suchFileExc + path + "\n";
    }

    public static String getBruteforceMessage() {
        return bruteforceMessage;
    }

    public static String getMessage() {
        return message;
    }

    public static String getIoExc() {
        return ioExc;
    }

    public static String getNfExc() {
        return nfExc;
    }
}
