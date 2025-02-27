package com.javarush.ageev.cryptocore;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class CaesarCipher implements Cipher{
    private final Properties properties = new Properties();
    private static final int DEFAULT_OFFSET = 1;

    private String clearAlphabet;
    private String shiftedAlphabet;
    private int offset;
    private int maxOffset;

    private void loadProperties() {
        try (FileInputStream stream = new FileInputStream(this.getClass().getResource("/ageev/app.properties").getPath())) {
            properties.load(stream);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (properties.containsKey("cesarAlphabet")) {
            this.clearAlphabet = properties.getProperty("cesarAlphabet");
        } else {
            throw new RuntimeException("Configuration file is not support Cesar cipher (cesarAlphabet)");
        }

    }
    public CaesarCipher() {
        loadProperties();
        maxOffset = clearAlphabet.length()-1;
        setOffset(DEFAULT_OFFSET);
    }

    public int getMaxOffset() {
        return maxOffset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
        this.shiftedAlphabet = shiftAlphabet(offset);
        System.out.println(shiftedAlphabet);
    }
    public int getOffset() {
        return this.offset;
    }

    private String shiftAlphabet(int offset) {
        return clearAlphabet.substring(offset) + clearAlphabet.substring(0, offset);
    }



    private char encrypt(char c) {
        // TODO Символ не найден в алфавите


        if (this.clearAlphabet.indexOf(c, 0) != -1) {
            return this.shiftedAlphabet.charAt(this.clearAlphabet.indexOf(c, 0));
        } else {
            try {
                // Устанавливаем кодировку UTF-8 для System.out
                System.setOut(new PrintStream(System.out, true, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                System.err.println("UTF-8 encoding is not supported: " + e.getMessage());
            }
            System.out.println((int)c);
            throw new RuntimeException("Symbol");
        }
    }

    private char decrypt(char c) {
        // TODO Символ не найден в алфавите
        return this.clearAlphabet.charAt(this.shiftedAlphabet.indexOf(c, 0));
    }

    @Override
    public String textEncrypt(String str) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i <str.length(); i++) {
            encryptedText.append(encrypt(str.charAt(i)));
        }
        return encryptedText.toString();
    }

    @Override
    public String textDecrypt(String str) {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i <str.length(); i++) {
            decryptedText.append(decrypt(str.charAt(i)));
        }
        return decryptedText.toString();
    }

    @Override
    public Boolean fileEncrypt(Path in, Path out) {
        try (BufferedReader reader = Files.newBufferedReader(in);
             BufferedWriter writer = Files.newBufferedWriter(out);) {

            while (reader.ready()) {
                writer.append(encrypt((char) reader.read()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return true;
    }

    @Override
    public Boolean fileDecrypt(Path in, Path out) {
        try (BufferedReader reader = Files.newBufferedReader(in);
             BufferedWriter writer = Files.newBufferedWriter(out);) {

            while (reader.ready()) {
                writer.append(decrypt((char) reader.read()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public String toString() {
        return "CesarCipher{" +
                "\n\toffset=" + offset +
                "\n\tclearAlphabet='" + clearAlphabet + '\'' +
                "\n\tshiftedAlphabet='" + shiftedAlphabet + '\'' +
                "\n}";
    }
}
