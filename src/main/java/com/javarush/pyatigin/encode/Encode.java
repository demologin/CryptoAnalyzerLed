package com.javarush.pyatigin.encode;

import com.javarush.pyatigin.ALPHABET;

public class Encode {
    int lengthAlphabet = ALPHABET.getALPHABETLength();

    public Encode() {
    }

    public String getEncode(String line, int key) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = line.toCharArray();
        for (char c : chars) {
            int index = ALPHABET.getIndexOfAlphabet(c);
            if (index == -1) {
                stringBuilder.append(c);
            } else {
                if (index + key >= lengthAlphabet) {
                    index = index + key - lengthAlphabet;
//                System.out.println(ALPHABET.getCharAlphabet(index));
                    stringBuilder.append(ALPHABET.getCharAlphabet(index));
                } else {
                    char x = ALPHABET.getCharAlphabet(index + key);
//                System.out.println(x);
                    stringBuilder.append(x);
                }
            }

        }
        return stringBuilder.toString();
    }
}
