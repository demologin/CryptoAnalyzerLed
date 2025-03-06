package com.javarush.user_roman;

import java.nio.file.Path;

public class FinalConstant {
    private static final Path TEST_PATH = Path.of("src/main/java/com/javarush/user_roman/text/test.txt");
    private static final Path TEXT_PATH = Path.of("src/main/java/com/javarush/user_roman/text/text.txt");
    private static final Path ENCRYPT_PATH = Path.of("src/main/java/com/javarush/user_roman/text/encrypt.txt");
    private static final Path DECRYPT_PATH = Path.of("src/main/java/com/javarush/user_roman/text/decrypt.txt");
    private static final String MENU_ACTION = "************************************************* \n"
            + "\t1-Запись текста в файл test.txt \n "
            + "\t2-Чтение текста из записанного файла test.txt \n "
            + "\t3-Чтение текста из готового файла text.txt \n "
            + "\t4-Шифрование \n "
            + "\t5-Расшифровка \n "
            + "\t6-Выход \n"
            + "************************************************* \n";
    private static final String KAOMOJI_ERROR = ".｡･ﾟﾟ･(＞_＜)･ﾟﾟ･｡. ";
    private static final String KAOMOJI_NOT_FOUND = "¯\\_(ツ)_/¯";
    private static final String KAOMOJI_FILE_WRITE = "(* ^ ω ^) ";
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String ALPHABET_RUS = "ЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮйцукенгшщзхъфывапролджэячсмитьбю";
    private static final String SYMBOLS = " .,”’:-!?'\"";
    private static final String NUMBERS = "0123456789";

    public static Path getTest() {
        return TEST_PATH;
    }

    public static Path getText() {
        return TEXT_PATH;
    }

    public static Path getEncrypt() {
        return ENCRYPT_PATH;
    }

    public static Path getDecryptPath() {
        return DECRYPT_PATH;
    }


    public static String getMenuAction() {
        return MENU_ACTION;
    }

    public static String getKaomojiError() {
        return KAOMOJI_ERROR;
    }

    public static String getKaomojiNotFound() {
        return KAOMOJI_NOT_FOUND;
    }

    public static String getKaomojiFileWrite() {
        return KAOMOJI_FILE_WRITE;
    }

    public static String getAlphabet() {
        return ALPHABET + SYMBOLS + NUMBERS;
    }

    public static String getAlphabetRus() {
        return ALPHABET_RUS + SYMBOLS + NUMBERS;
    }
}
