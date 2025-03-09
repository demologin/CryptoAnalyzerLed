package com.javarush.lepeshinskiy;

public class Cipher {
    
    public static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.," + '"' + "':-!? ";
    
    public String encrypt(String text, int key) {
        return processCryptography(text, key);
    }
    
    public String decrypt(String text, int key) {
        return processCryptography(text, ALPHABET.length() - (key % ALPHABET.length()));
    }
    
    private String processCryptography(String text, int key) {
        StringBuilder result = new StringBuilder();
        
        for (char character : text.toCharArray()) {
            int index = ALPHABET.indexOf(Character.toLowerCase(character));
            
            if (index == -1) {
                result.append(character);
                continue;
            }
            
            int shiftedIndex = (index + key) % ALPHABET.length();
            if (shiftedIndex < 0) {
                shiftedIndex += ALPHABET.length();
            }
            
            char newChar = ALPHABET.charAt(shiftedIndex);
            result.append(newChar);
        }
        
        return result.toString();
    }
    
    public int getAlphabetSize() {
        return ALPHABET.length();
    }
}