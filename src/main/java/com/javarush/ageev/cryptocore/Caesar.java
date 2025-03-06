package com.javarush.ageev.cryptocore;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import java.util.stream.Collectors;

public class Caesar implements Cipher {
    private final Properties properties = new Properties();
    private static final int DEFAULT_OFFSET = 1;
    private int maxShift;
    private String alphabet;
    private String shiftedAlphabet;
    private int shift;

    private void loadProperties() throws IOException {
        String propertyPath = this.getClass().getResource("/ageev/app.properties").getPath();
        try (FileInputStream stream = new FileInputStream(propertyPath)) {
            properties.load(stream);
        }

        if (properties.containsKey("cesarAlphabet")) {
            this.alphabet = properties.getProperty("cesarAlphabet");
        }

    }

    private String shiftAlphabet(int shift) {
        return alphabet.substring(shift) + alphabet.substring(0, shift);
    }

    public void setShift(int shift) {
        this.shift = shift;
        this.shiftedAlphabet = shiftAlphabet(shift);
    }

    public int getShift() {
        return this.shift;
    }

    public int getMaxShift() {
        return this.maxShift;
    }

    public Caesar() throws IOException {
        loadProperties();
        this.maxShift = alphabet.length() - 1;
        setShift(DEFAULT_OFFSET);
    }

    @Override
    public char encrypt(char in) {
        return this.shiftedAlphabet.charAt(this.alphabet.indexOf(in));
    }

    @Override
    public char decrypt(char in) {
        return this.alphabet.charAt(this.shiftedAlphabet.indexOf(in));
    }

    @Override
    public String encrypt(String in) {
        return in.chars().mapToObj(c -> String.valueOf(encrypt((char) c))).collect(Collectors.joining());
    }

    @Override
    public String decrypt(String in) {
        return in.chars().mapToObj(c -> String.valueOf(decrypt((char) c))).collect(Collectors.joining());
    }

    @Override
    public boolean encrypt(Path in, Path out) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(in);
             BufferedWriter writer = Files.newBufferedWriter(out)) {
            while (reader.ready()) {
                writer.append(encrypt((char) reader.read()));
            }
        }
        return true;
    }

    @Override
    public boolean decrypt(Path in, Path out) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(in);
             BufferedWriter writer = Files.newBufferedWriter(out)) {
            while (reader.ready()) {
                writer.append(decrypt((char) reader.read()));
            }
        }

        return true;
    }

    public String getSample(Path in, int size) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(in)) {
            char[] buffer = new char[size];
            int bytesRead = reader.read(buffer, 0, size);

            return new String(buffer, 0, bytesRead);
        }

    }
}
