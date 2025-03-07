package com.javarush.burdygin.view;

import com.javarush.burdygin.constant.Constants;
import com.javarush.burdygin.controller.Controller;
import com.javarush.burdygin.exception.EmptyFileException;
import com.javarush.burdygin.inputOutput.PathHelper;

import java.nio.file.NoSuchFileException;
import java.util.HashMap;
import java.util.Map;

public class ConsoleApplication {

    Menu menu;
    Controller controller;
    Map<String, String> args = new HashMap<>();

    public ConsoleApplication(Menu menu, Controller controller) {
        this.menu = menu;
        this.controller = controller;
    }

    public void run() {
        menu.getUserArguments(args);
        boolean isExit = false;
        switch (args.get(Constants.MODE_FLAG)) {
            case Constants.MODE_ENCODE -> System.out.print('\n' + "encoding...");
            case Constants.MODE_DECODE -> System.out.println('\n' + "decoding...");
            case Constants.MODE_BRUTE_FORCE -> System.out.println("""
                    Brute Force
                    decoding...""");
            case Constants.MODE_EXIT -> {
                System.out.print(Messages.EXIT_MESSAGE);
                isExit = true;
            }
        }
        if (!isExit) {
            try {
                controller.start(args);
            } catch (NullPointerException e) {
                System.out.println("Incorrect mode");
            } catch (EmptyFileException e){
                System.out.println("Source file is empty");
            } catch (RuntimeException e) {
                if (e.getCause() instanceof NoSuchFileException) {
                    String path = String.valueOf(PathHelper.get(Constants.SOURCE_FILE).toAbsolutePath());
                    System.out.printf("File %s not found", path);
                }
                System.out.print('\n' + "Complete!");
            }

        }

    }
}
