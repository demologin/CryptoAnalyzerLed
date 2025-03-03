package com.javarush.user_roman;

import java.nio.file.Path;

public class FinalConstant {
    private static final Path testPath = Path.of("src/main/java/com/javarush/user_roman/text/test.txt");
    private static final Path textPath = Path.of("src/main/java/com/javarush/user_roman/text/test.txt");

    public static Path getTest() {
        return testPath;
    }

    public static Path getText() {
        return textPath;
    }
}
