package com.javarush.bulimova;

import com.javarush.khmelov.constant.Alphabet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Cipher {

    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public final  static Map <Character, Integer> index = new HashMap<>();

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
            index.put(ALPHABET[i], i);
        }
    }


    public List<Character>  code(List<Character> encodeText) {
        // Логика шифрования

// найти символ на позиции смещенной на заданный сдвиг. И помним что в примере с игрушкой Y стала А (и не улетела в космос).
// Как это гарантировать? (можно сделать (позиция буквы + сдвиг) %( размер алфавита). Процент - оператор получения остатка от деления).
        List <Character> encodeText2= new ArrayList<>();
        int length = ALPHABET.length;
        for (Character c : encodeText) {
            char ch = encodeText.get(c);
            if (index.containsKey(ch)) {
                Integer index = this.index.get(ch);
                index = (index+key)%length;
                encodeText2.add(ALPHABET[index]);
            }

        }

        return encodeText2;
    }



        
//        return encodeText;
//    }
//    public String deCode(String encryptedText, int shift) {
//        // Логика расшифровки
//
//    }

}
