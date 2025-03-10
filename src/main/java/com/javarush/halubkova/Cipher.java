package com.javarush.halubkova;

public class Cipher {
    private char[] alphabet;

    public Cipher(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public String encrypt(String text, int shift) throws CharNotFoundException {
        String exit = "";
        for (int i = 0; i < text.length(); i++) {
            int position = -1;
            for (int j = 0; j < alphabet.length; j++) {
                if ((text.charAt(i)) == alphabet[j]) {
                    position = j + shift;
                }
            }
            if (position > alphabet.length - 1) {
                position = position % alphabet.length;
                exit = exit + String.valueOf(alphabet[position]);
            } else if (position == -1) {
                throw new CharNotFoundException();
            } else {
                exit = exit + String.valueOf(alphabet[position]);
            }
        }
        return exit;
        //как можно ускорить
        // какую структуру данных нужно использовать чтобы ускорить
        // этот процесс (раз в 15), ведь необязательно же сканировать всю библиотеку в поисках книги на
        // букву Ы (Ладно, П).
    }

    public String decrypt(String encryptedText, int shift) throws CharNotFoundException {

        String exit = "";
        for (int i = 0; i < encryptedText.length(); i++) {
            int position = alphabet.length;
            for (int j = 0; j < alphabet.length; j++) {
                if ((encryptedText.charAt(i)) == alphabet[j]) {
                    position = j - shift;
                }
            }
            if (position < 0) {
                position = alphabet.length + position;
                exit = exit + String.valueOf(alphabet[position]);
            } else if (position == alphabet.length) {
                throw new CharNotFoundException();
                //System.out.println("исключение: нет такого символа");
            } else {
                exit = exit + String.valueOf(alphabet[position]);
            }
        }
        return exit;
    }

    //Ты будешь использовать этот код использовать в следующих подзадачах, поэтому выводить результат можно
    // в поток.

}
