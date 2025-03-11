package com.javarush.chesnokov;

public class Alphabet {

    private final String alphabet;

    public Alphabet() {
        StringBuilder alphabetBuilder = new StringBuilder();

        alphabetBuild('a', 'z', alphabetBuilder);
        alphabetBuild('A', 'Z', alphabetBuilder);
        alphabetBuild('а', 'я', alphabetBuilder);
        alphabetBuild('А', 'Я', alphabetBuilder);

        alphabetBuilder.append(" .,!?;:\"'()[]{}<>@#$%^&*`~");
        this.alphabet = alphabetBuilder.toString();
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void alphabetBuild(char start, char end, StringBuilder alphabetBuilder) {
        for (char c = start; c <= end; c++) {
            alphabetBuilder.append(c);
        }
    }

}
