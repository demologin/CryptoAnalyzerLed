package com.javarush.Apalinskiy;

import com.javarush.Apalinskiy.IO.Reader;
import com.javarush.Apalinskiy.IO.Writer;
import com.javarush.Apalinskiy.Logic.Decryption;
import com.javarush.Apalinskiy.Logic.Encryption;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Encryption encryption = new Encryption();
        Decryption decryption = new Decryption();
        Reader reader = new Reader();
        System.out.println("Введите путь к файлу");
        char[] text = reader.reader();
        char[] encryptionText = encryption.encryption(text, 5);
        Writer writer = new Writer(encryptionText);
        char[] decryptionText = decryption.decryption(encryptionText, 5);
        writer = new Writer(decryptionText);

    }
}
