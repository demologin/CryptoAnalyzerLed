package com.javarush.kazakov.constants;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static final String ROOT_FOLDER = System.getProperty("user.dir") + File.separator;
    public static final String DEFAULT_TEXT_FOLDER = ROOT_FOLDER + "text";
    public static final String DEFAULT_TEMP_NAME = "temp.txt";
    public static final String DEFAULT_INPUT_NAME = "text.txt";
    public static final String DEFAULT_ENCRYPTED_NAME = "encrypted.txt";
    public static final String DEFAULT_DECRYPTED_NAME = "decrypted.txt";
    public static final String DEFAULT_REPRESENT_NAME = "dict.txt";
    public static final char[] ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,'\":-!? ".toCharArray();
    public static final Map<Character, Integer> ALPHABET_MAP = new HashMap<>();
    public static final Path DEFAULT_INPUT_PATH = Path.of(DEFAULT_TEXT_FOLDER, DEFAULT_INPUT_NAME);
    public static final Path DEFAULT_ENCRYPTED_PATH = Path.of(DEFAULT_TEXT_FOLDER, DEFAULT_ENCRYPTED_NAME);
    public static final Path DEFAULT_DECRYPTED_PATH = Path.of(DEFAULT_TEXT_FOLDER, DEFAULT_DECRYPTED_NAME);
    public static final Path DEFAULT_REPRESENT_PATH = Path.of(DEFAULT_TEXT_FOLDER, DEFAULT_REPRESENT_NAME);

    static {
        for (int i = 0; i < ALPHABET.length; i++) {
            ALPHABET_MAP.put(ALPHABET[i], i);
        }
    }
}
