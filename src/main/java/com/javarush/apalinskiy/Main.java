package com.javarush.apalinskiy;


import com.javarush.apalinskiy.exceptions.AppException;
import com.javarush.apalinskiy.exceptions.ExceptionMessage;
import com.javarush.apalinskiy.view.MainMenu;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class Main {
    public static void main(String[] args) {
        int i = 0;
        MainMenu menu = new MainMenu();
        do {
            try {
                menu.Menu();
            } catch (AppException e) {
                i = -1;
            } catch (NoSuchFileException e) {
                System.out.println(ExceptionMessage.getSuchFileExc());
                i = -1;
            } catch (IOException e) {
                System.out.println(ExceptionMessage.getIoExc());
                i = -1;
            } catch (NumberFormatException e) {
                System.out.println(ExceptionMessage.getNfExc());
                i = -1;
            }
        } while (i == -1);
    }
}
