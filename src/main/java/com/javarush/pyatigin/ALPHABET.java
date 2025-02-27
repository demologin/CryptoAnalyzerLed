package com.javarush.pyatigin;

public class ALPHABET {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', ' ', '?'};

    public static int getALPHABETLength() {
        return ALPHABET.length;
    }

    public static char getCharAlphabet(int index) {
        return ALPHABET[index];
    }

    //Подумать как вернуть Большие буквы
    public static int getIndexOfAlphabet(char c) {
        for (int i = 0; i < ALPHABET.length; i++) {
            if (ALPHABET[i] == Character.toLowerCase(c)) {
                return i;
            }
        }
        //Подумать как через ошибку вернуть что нет char
        return -1;
    }
}
