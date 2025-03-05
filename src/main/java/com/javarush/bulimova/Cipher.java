package com.javarush.bulimova;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Cipher {

    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

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
        System.out.println(indexes);
    }


    public List<Character> code(List<Character> encodeText) {
        // Логика шифрования

// найти символ на позиции смещенной на заданный сдвиг. И помним что в примере с игрушкой Y стала А (и не улетела в космос).
// Как это гарантировать? (можно сделать (позиция буквы + сдвиг) %( размер алфавита). Процент - оператор получения остатка от деления).
        List<Character> encodeText2 = new ArrayList<>();
        int length = ALPHABET.length;
        for (Character c : encodeText) {
            char ch = c;
            if (indexes.containsKey(ch)) {
                Integer index = indexes.get(ch);
                //index = (index + key + Math.abs(key) * length) % length;
                index = (index + key) % length;
                encodeText2.add(ALPHABET[index]);
            }
//            else if (ch == '\n') {
//                encodeText2.add(ch);
//            }

        }

        return encodeText2;
    }


    public List<Character> deCode(List<Character> mainText) {
        // Логика расшифровки
        List <Character> decodeText2= new ArrayList<>();
        int length = ALPHABET.length;
        for (Character c : mainText) {
            char ch = c;
            if (indexes.containsKey(ch)) {
                Integer index = indexes.get(ch);
                index = (Math.abs(index-key))%length;
                //index = (index - key - Math.abs(key) * length) % length;
                decodeText2.add(ALPHABET[index]);
            }
//            else if (ch == '\n') {
//                decodeText2.add(ch);
//            }

        }

        return decodeText2;

    }

//    }
}