package larina;
import java.text.*;
import java.io.*;
import java.util.Scanner;

public class ConsoleRunner {
    public static final String rusletters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя" +
            " ., ': -!?"; //Russian alphabet and punctuation
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст:");
        String inputFilePath = scanner.nextLine();
        System.out.println("Введите путь:");
        String outputFilePath = scanner.nextLine();
        int key = 8; //Encryption key
        String text = readTextFromFile(inputFilePath);

