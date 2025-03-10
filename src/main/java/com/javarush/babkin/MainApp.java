package com.javarush.babkin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName1 = sc.nextLine();
        String fileName2 = sc.nextLine();
        String fileName3 = sc.nextLine();

        Path path1 = Paths.get(fileName1);
        Path path2 = Paths.get(fileName2);
        Path path3 = Paths.get(fileName3);

        try (BufferedReader reader = Files.newBufferedReader(path1, StandardCharsets.UTF_8);
             BufferedWriter writer = Files.newBufferedWriter(path2, StandardCharsets.UTF_8)
        ) {
            char[] buffer = new char[128]; // 128Kb
            while (reader.ready())
            {
                int real = reader.read(buffer);
                writer.write(Crypto.incrypt(buffer, 15), 0, real);

            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (BufferedReader reader = Files.newBufferedReader(path2, StandardCharsets.UTF_8);
             BufferedWriter writer = Files.newBufferedWriter(path3, StandardCharsets.UTF_8)
        ) {
            char[] buffer = new char[128]; // 128Kb
            while (reader.ready())
            {
                int real = reader.read(buffer);
                writer.write(Crypto.dicrypt(buffer, 15), 0, real);

            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
