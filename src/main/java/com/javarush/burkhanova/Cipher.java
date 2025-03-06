package com.javarush.burkhanova;

public class Cipher {
    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '-', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public Cipher(char[] alphabet) {

    }

    public static String encrypt(String text, int shift) {
        char[] array = text.toCharArray();

        for (int i = 0; i < array.length; i++) {
            char lowerCase = Character.toLowerCase(array[i]);
            for (int j = 0; j < ALPHABET.length; j++) {

                if (lowerCase != ALPHABET[j]) {
                    continue;
                } else if (lowerCase == ALPHABET[j]) {
                    int index = j;
                    int newIndex = (index + shift) % ALPHABET.length;
                    array[i] = ALPHABET[newIndex];
                    break;


                }
            }


        }
        return new String(array);

    }


    public static String decrypt(String text, int shift) {
        char[] array = text.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char lowerCase = Character.toLowerCase(array[i]);
            for (int j = 0; j < ALPHABET.length; j++) {
                if (lowerCase != ALPHABET[j]) {
                    continue;
                } else if (lowerCase == ALPHABET[j]) {
                    int index = j;
                    int oldIndex = (index - shift) % ALPHABET.length;
                    if (oldIndex < 0){
                        oldIndex =( ALPHABET.length ) + oldIndex;
                    }
                    array[i] = ALPHABET[oldIndex];
                    break;

                }

            }

        }

        return new String(array);
    }




}
