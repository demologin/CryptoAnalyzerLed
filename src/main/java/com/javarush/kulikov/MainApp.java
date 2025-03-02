package com.javarush.kulikov;

public class MainApp {
    public static void main(String[] args) {
        Cipher cipher = new Cipher();
        String string = cipher.encrypt("Привет мир!", 3);
        System.out.println(string);
        System.out.println(cipher.decrypt(string, 3));
    }
}
