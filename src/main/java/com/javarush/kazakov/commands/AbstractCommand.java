package com.javarush.kazakov.commands;

import com.javarush.kazakov.constants.Constants;
import com.javarush.kazakov.core.Translator;
import com.javarush.kazakov.core.files.FileManager;

import java.nio.file.Path;
import java.util.Scanner;
import java.util.concurrent.Callable;

import static com.javarush.kazakov.constants.InteractiveConstants.DECRYPTION_OFFER_MESSAGE;
import static com.javarush.kazakov.constants.InteractiveConstants.SPECIFY_OUTPUT_MESSAGE;

public abstract class AbstractCommand implements Callable<String> {
    protected Path input;
    protected Path output;
    protected Path representative;
    protected int key;
    protected Scanner scanner;

    public abstract void interact();

    protected String translate(String msg) {
        FileManager fileManager = new FileManager(input, output);
        long start = System.currentTimeMillis();
        long count = fileManager.translateFile(new Translator(key));
        long end = System.currentTimeMillis();
        return String.format(msg, count, fileManager.getOutput(), end - start);
    }

    protected int specify(String msg, int val) {
        System.out.printf(msg, val);
        String str = scanner.nextLine();
        if (str != null && !str.isEmpty()) {
            return Integer.parseInt(str);
        }
        return val;
    }

    protected Path specify(String msg, Path path) {
        System.out.printf(msg, path);
        String str = scanner.nextLine();
        if (str != null && !str.isEmpty()) {
            return Path.of(str);
        }
        return path;
    }

    protected void decryptOffer() {
        if (isPermissionGranted()) {
            output = specify(SPECIFY_OUTPUT_MESSAGE, output);
            Decrypt decrypt = new Decrypt(input, output, key);
            System.out.println(decrypt.call());
        }
    }

    private boolean isPermissionGranted() {
        while (true) {
            System.out.printf(DECRYPTION_OFFER_MESSAGE, input.getFileName());
            String s = scanner.nextLine();
            if (s.equals("y")) {
                return true;
            } else if (s.equals("n")) {
                return false;
            }
        }
    }

    public int getKey() {
        return key;
    }
}
