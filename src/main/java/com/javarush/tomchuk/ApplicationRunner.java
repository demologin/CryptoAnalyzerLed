package com.javarush.tomchuk;

import com.javarush.tomchuk.controller.MainController;

public class ApplicationRunner {

    public static void main(String[] args) {
        System.out.println("Application was successfully started...");
        MainController.noName();
        System.out.println("Application was closed.");
    }
}
