package com.javarush.babkin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Incryptfile {
    public static void doIncrypt(String src, String dst, int key) {

        Path pathInput = Paths.get(src);
        Path pathOutput = Paths.get(dst);

        try (BufferedReader reader = Files.newBufferedReader(pathInput, StandardCharsets.UTF_8);
             BufferedWriter writer = Files.newBufferedWriter(pathOutput, StandardCharsets.UTF_8)
        ) {
            char[] buffer = new char[128]; // 128Kb
            while (reader.ready())
            {
                int real = reader.read(buffer);
                writer.write(Cryptoway.incrypt(buffer, key), 0, real);

            }
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Text incrypt");

    }
}
