package com.javarush.pyatigin.decode;

import com.javarush.pyatigin.constatnt.ALPHABET;

public class Decode {
    int lengthAlphabet = ALPHABET.getALPHABETLength();

    public Decode() {
    }

    public String getDecode(String line, int key) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = line.toCharArray();
        for (char c : chars) {
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

