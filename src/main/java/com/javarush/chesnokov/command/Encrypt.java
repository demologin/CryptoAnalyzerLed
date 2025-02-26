package com.javarush.chesnokov.command;

import com.javarush.chesnokov.Alphabet;
import com.javarush.chesnokov.Cipher;

public class Encrypt implements Command {

    @Override
    public void execute() {
        System.out.println("Выполняется шифрование...");

        Cipher cipher = new Cipher(Alphabet.ALPHABET);
        String text = "Тестовый текст для проверки";
        int shift = 1;
        cipher.encrypt(text,shift);

    }

}
