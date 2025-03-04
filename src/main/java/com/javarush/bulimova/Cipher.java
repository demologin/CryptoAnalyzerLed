package com.javarush.bulimova;

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



    public List <Character>  code(List <Character> mainText) {
        // Логика шифрования
        String str1;
//        for (String str : mainText) {
//            char[] chars = str.toLowerCase().toCharArray();
//            for (int i = 0; i < chars.length; i++) {
//
//            }
//        }




        

return mainText;
    }
//    public String deCode(String encryptedText, int shift) {
//        // Логика расшифровки
//
//    }

}
