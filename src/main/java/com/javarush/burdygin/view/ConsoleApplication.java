package com.javarush.burdygin.view;

import com.javarush.burdygin.constant.Constants;
import com.javarush.burdygin.controller.Controller;
import com.javarush.burdygin.exception.EmptyFileException;
import com.javarush.burdygin.exception.IncorrectModeException;
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
            case Constants.MODE_ENCODE -> System.out.print('\n' + Messages.ENCODING_MESSAGE);
            case Constants.MODE_DECODE -> System.out.println('\n' + Messages.DECODING_MESSAGE);
            case Constants.MODE_BRUTE_FORCE -> System.out.printf('\n' + Messages.BRUTE_FORCE_MESSAGE);
            case Constants.MODE_EXIT -> {
                System.out.print(Messages.EXIT_MESSAGE);
                isExit = true;
            }
        }

        if (!isExit) {
            try {
                controller.start(args);
            } catch (IncorrectModeException e) {
                System.out.println(Messages.INCORRECT_MODE_MESSAGE);
            } catch (EmptyFileException e) {
                System.out.println(Messages.EMPTY_FILE_MESSAGE);
            } catch (RuntimeException e) {
                if (e.getCause() instanceof NoSuchFileException) {
                    String path = String.valueOf(PathHelper.get(Constants.SOURCE_FILE).toAbsolutePath());
                    System.out.printf(Messages.FILE_NOT_FOUND_MESSAGE, path);
                } else {
                    System.out.println(Messages.UNKNOWN_ERROR_MESSAGE);
                }
            }
            if (args.get(Constants.MODE_FLAG).equals(Constants.MODE_BRUTE_FORCE)){
                System.out.printf("key = %s", Math.abs(Integer.parseInt(args.get(Constants.KEY))));
            }
            System.out.print('\n' + Messages.COMPLETE_MESSAGE);
        }

    }
}
