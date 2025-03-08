package com.javarush.abdulkhanovmt.functionality;

import java.util.*;

public class Alphabet {

    private final static String RUS_ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private final static String PUNCTUATION_MARKS = ",.`~'-/!? :;%№\"\\";
    private final static char[] bookmarksArray = RUS_ALPHABET.toLowerCase().toCharArray();
    private final static char[] signsArray = PUNCTUATION_MARKS.toLowerCase().toCharArray();
    private static char[] rusExtAlphabet = new char[bookmarksArray.length+signsArray.length];
    private static final ArrayList<Character> charArr = new ArrayList<>();

    static {
        Arrays.sort(bookmarksArray);
        Arrays.sort(signsArray);
        System.arraycopy(bookmarksArray, 0, rusExtAlphabet, 0, bookmarksArray.length);
        System.arraycopy(signsArray, 0, rusExtAlphabet, bookmarksArray.length, signsArray.length);
        int arraysSize = rusExtAlphabet.length;

        for (int i = 0; i < arraysSize; i++) {
            charArr.add(rusExtAlphabet[i]);
        }
    }

    public static int getRuLength() {
        return rusExtAlphabet.length;
    }

    public static int getIndex(char character) {
        int index = -1;
        character = Character.toLowerCase(character);
        if (belongsToAlphabet(character)) {
            index = charArr.indexOf(character);
        } else{
            return index;
        }
        return index;
    }

    public static char getCharacter(int index) {
        if (index >= rusExtAlphabet.length) {
            index = index % rusExtAlphabet.length;
        } else if(index<0){
            return '\n';
        }
        return charArr.get(index);
    }

    public static boolean belongsToAlphabet(char character) {
        int index = 0;
        if (charArr.contains(character)) {
            index = charArr.indexOf(character);
        } else {
            index = -1;
        }
        return index >= 0 && index < charArr.size();
    }

}
