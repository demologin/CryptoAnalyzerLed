package com.javarush.halubkova;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class MainApp {
    private static final int MODE_ENCODE = 1;
    private static final int MODE_DECODE = 2;

    public static void main(String[] args) throws IOException, CharNotFoundException {

        Scanner scan = new Scanner(System.in);
        System.out.println("Выберете операцию: для кодирования - 1, декодирования - 2");
        String operation = scan.nextLine();
        int operat = Integer.parseInt(operation);
        System.out.println("Введите путь к файлу с текстом"); //C:\Users\volha\entry.txt
        String inputFile = scan.nextLine();
        System.out.println("Введите ключ шифрования");
        String key = scan.nextLine();
        int shift = Integer.parseInt(key);
        System.out.println("Введите имя для файла с результатами (должен заканчиваться на .txt)"); //result.txt
        String outputFile = scan.nextLine();

        String text = FileManager.readFile(inputFile);
        Cipher cip = new Cipher(Alphabet.getAlphabet());
        String result = "";
        if (operat == MODE_ENCODE) {
            result = cip.encrypt(text, shift);
        }
        if (operat == MODE_DECODE) {
            result = cip.decrypt(text, shift);
        }
        String pathOfOutputFile = String.valueOf(Path.of(inputFile).getParent()) + "\\" + outputFile;
        FileManager.createFile(pathOfOutputFile);
        FileManager.writeFile(result, pathOfOutputFile);

    }

    //Добавить валидацию через валидатор и выбросить исключения

    //В MainApp пользователь выбирает режим работы, например, через командную строку
    // или простой GUI.

}
