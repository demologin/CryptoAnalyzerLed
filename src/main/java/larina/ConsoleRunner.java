package larina;
import java.text.*;
import java.io.*;
import java.util.Scanner;

public class ConsoleRunner {
    public static final String rusletters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя" +
            " ., ': -!?"; //Russian alphabet and punctuation
    private static String text ; ;

    private static int key;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст:");
        String inputFilePath = scanner.nextLine();
        System.out.println("Введите путь:");
        String outputFilePath = scanner.nextLine();
        int key = 8; //Encryption key
        String text = readTextFromFile((inputFilePath));

        String encryptedText = encryptText(text, key); // Text Encryption
        writeTextToFile(outputFilePath, encryptedText); // Writing encrypted text to a file

    } private static String readTextFromFile(String filePath) {
        return filePath;
    }

    private static String encryptText(String text, int key) {
        ConsoleRunner.text = text;
        ConsoleRunner.key = key;
        // The logic of text encryption
        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            int index = rusletters.indexOf(c);
            if (index != -1) {
                int newIndex = (index + key) % rusletters.length();
                encrypted.append(rusletters.charAt(newIndex));
            } else {
                encrypted.append(c); // Unmodified characters
            }
        }
        return encrypted.toString();
    }

    private static void writeTextToFile(String filePath, String text) {
        // Logic for writing text to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}