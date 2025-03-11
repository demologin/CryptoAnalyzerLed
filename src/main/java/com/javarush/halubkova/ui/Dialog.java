package com.javarush.halubkova.ui;

import com.javarush.halubkova.cipher.Alphabet;
import com.javarush.halubkova.exception.FileNameException;
import com.javarush.halubkova.exception.FileNotFoundException;
import com.javarush.halubkova.exception.ShiftNotValidException;
import java.util.Scanner;

public class Dialog {
    Validator validator = new Validator();

    public DialogDTO ask() throws FileNotFoundException, ShiftNotValidException, FileNameException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Выберете операцию: для кодирования - 1, декодирования - 2");
        String operation = scan.nextLine();
        int operat = Integer.parseInt(operation);

        System.out.println("Введите путь к файлу с текстом");
        String inputFile = scan.nextLine();
        if (!validator.isFileExists(inputFile)) {
            throw new FileNotFoundException();
        }

        System.out.println("Введите ключ шифрования");
        String key = scan.nextLine();
        int shift = Integer.parseInt(key);
        if (!validator.isValidKey(shift, Alphabet.getAlphabet())) {
            throw new ShiftNotValidException();
        }

        System.out.println("Введите имя для файла с результатами (должен заканчиваться на .txt)");
        String outputFile = scan.nextLine();
        if (!validator.isFileNameValid(outputFile)) {
            throw new FileNameException();
        }
        DialogDTO dialogDTO = new DialogDTO(operat, inputFile, shift, outputFile);

        return dialogDTO;
    }


}
