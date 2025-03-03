package com.javarush.bulimova;

import java.util.List;



public class Cipher {

    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

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



    public List<String>  code(List<String> mainText) {
        // Логика шифрования
        String str1;
        for (String str : mainText) {
            char[] chars = str.toCharArray();
        }




        

return mainText;
    }
//    public String deCode(String encryptedText, int shift) {
//        // Логика расшифровки
//
//    }

}
