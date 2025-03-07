package com.javarush.bulimova;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Cipher {

    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ', '\n'};

    // тут без переноса строки
//    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
//            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
//            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public final static Map<Character, Integer> indexes = new HashMap<>();

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    int key;


    public Cipher(int key) {
        this.key = key;
    }

    static {
        for (int i = 0; i < ALPHABET.length; i++) {
            indexes.put(ALPHABET[i], i);

        }
       // System.out.println(indexes);
    }


    public List<Character> code(List<Character> encodeText) {
        // Логика шифрования

        List<Character> encodeText2 = new ArrayList<>();
        int length = ALPHABET.length;
        for (Character c : encodeText) {
            char ch = c;
            if (indexes.containsKey(ch)) {
                Integer index = indexes.get(ch);
                index = (index + key) % length;
                encodeText2.add(ALPHABET[index]);
            }
        }

        return encodeText2;
    }


    public List<Character> deCode(List<Character> mainText) {
        // Логика расшифровки
        List<Character> decodeText2 = new ArrayList<>();
        int length = ALPHABET.length;
        for (Character c : mainText) {
            char ch = c;
            if (indexes.containsKey(ch)) {
                Integer index = indexes.get(ch);
                if ((index - key) > 0) {
                    index = (index - key) % length;
                    decodeText2.add(ALPHABET[index]);
                } else {
                    index = ((index - key) + length) % length;
                    decodeText2.add(ALPHABET[index]);
                }

            }
        }


        return decodeText2;

    }

}
