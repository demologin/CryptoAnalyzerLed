package com.javarush.chesnokov;

public class Alphabet {

    private final String alphabet;

    public Alphabet() {
        StringBuilder alphabetBuilder = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {
            alphabetBuilder.append(c);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            alphabetBuilder.append(c);
        }
        for (char c = 'а'; c <= 'я'; c++) {
            alphabetBuilder.append(c);
        }
        for (char c = 'А'; c <= 'Я'; c++) {
            alphabetBuilder.append(c);
        }
        alphabetBuilder.append(" .,!?;:\"'()[]{}<>@#$%^&*`~");
        this.alphabet = alphabetBuilder.toString();
    }

    public String getAlphabet() {
        return alphabet;
    }
}
