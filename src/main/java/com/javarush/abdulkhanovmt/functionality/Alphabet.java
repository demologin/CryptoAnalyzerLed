package com.javarush.abdulkhanovmt.functionality;

import java.util.*;

public class Alphabet {

    private final static String RUS_ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private final static String PUNCTUATION_MARKS = ",.`~' -/!? :;%№\"\\";
    private final static char[] bookmarksArray = RUS_ALPHABET.toLowerCase().toCharArray();
    private final static char[] signsArray = PUNCTUATION_MARKS.toLowerCase().toCharArray();
    private static char[] rusExtAlphabet;
    private static final ArrayList<Character> charArr = new ArrayList<>();

    static {
        Arrays.sort(bookmarksArray);
        Arrays.sort(signsArray);
        rusExtAlphabet = Arrays.copyOf(bookmarksArray, bookmarksArray.length + signsArray.length);
        rusExtAlphabet = Arrays.copyOfRange(signsArray, bookmarksArray.length, signsArray.length);
        int arraysSize = bookmarksArray.length + signsArray.length;

        for (int i = 0; i < arraysSize; i++) {
            charArr.add(rusExtAlphabet[i]);
        }
    }

    public static int getRuLength(){
        return rusExtAlphabet.length;
    }

    public static int getIndex(char character) {
        int index = -1;
        if (belongsToAlphabet(character)) {
            index = charArr.indexOf(character);
        }
        return index;
    }

    public static char getCharacter(int index) {
        if (index >= rusExtAlphabet.length) {
            index = index % rusExtAlphabet.length;
        }
        return charArr.get(index);
    }

    public static boolean belongsToAlphabet(char character) {
        int index = charArr.indexOf(character);
        return index >= 0 && index < charArr.size();
    }

}
