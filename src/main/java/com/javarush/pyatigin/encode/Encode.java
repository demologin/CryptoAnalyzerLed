package com.javarush.pyatigin.encode;

import com.javarush.pyatigin.ALPHABET;

public class Encode {
    int lengthAlphabet = ALPHABET.getALPHABETLength();
    public Encode() {
    }
    public String Encode(String line, int key) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int index = ALPHABET.getIndexOfAlphabet(c);
            if ((index + key) > lengthAlphabet) {
                index = index + key - chars.length;
//                System.out.println(ALPHABET.getCharAlphabet(index));
                stringBuilder.append(ALPHABET.getCharAlphabet(index));
            } else {
                char x = ALPHABET.getCharAlphabet(index+key);
//                System.out.println(x);
                stringBuilder.append(x);
            }

        }
        return stringBuilder.toString();
    }
}
