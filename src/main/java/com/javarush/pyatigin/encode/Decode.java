package com.javarush.pyatigin.encode;

import com.javarush.pyatigin.ALPHABET;

public class Decode {
    int lengthAlphabet = ALPHABET.getALPHABETLength();

    public Decode() {
    }

    public String Decode(String line, int key) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int index = ALPHABET.getIndexOfAlphabet(c);
            if (index == -1) {
                stringBuilder.append(c);
            } else {
                if (index - key < 0) {
                    index = index - key + lengthAlphabet;
//                System.out.println(ALPHABET.getCharAlphabet(index));
                    stringBuilder.append(ALPHABET.getCharAlphabet(index));
                } else {
                    char x = ALPHABET.getCharAlphabet(index - key);
//                System.out.println(x);
                    stringBuilder.append(x);
                }
            }

        }
        return stringBuilder.toString();
    }
}

