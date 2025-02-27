package com.javarush.kulikov;

public class MainApp {
    public static void main(String[] args) {
        Cipher cipher = new Cipher();
        System.out.println(cipher.encrypt("Привет мир!", 0));
    }
}
