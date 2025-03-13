package com.javarush.babkin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Dicryptfile {
    public static void doDicrypt(String src, String dst, int key) {

        Path pathInput = Paths.get(src);
        Path pathOutput = Paths.get(dst);

/*        try (BufferedReader reader = Files.newBufferedReader(pathInput, StandardCharsets.UTF_8);
             BufferedWriter writer = Files.newBufferedWriter(pathOutput, StandardCharsets.UTF_8)
        ) {
            char[] buffer = new char[128]; // 128Kb
            while (reader.ready()) {
                int real = reader.read(buffer);
                writer.write(Cryptoway.dicrypt(buffer, key), 0, real);

            }
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Text dicrypt");
*/
        try (BufferedReader reader = Files.newBufferedReader(pathInput, StandardCharsets.UTF_8);
             BufferedWriter writer = Files.newBufferedWriter(pathOutput, StandardCharsets.UTF_8)
        ) {
            int symb;
            String scrText = "";
            int length = Dictionary.getLengthCharSymbols();

            while (reader.ready()) {
                symb = reader.read();
                char character = (char) symb;

                System.out.println(character);
                if (Dictionary.DICTIONARY.containsKey(character)) {
                    System.out.println(character);
                    Integer index = Dictionary.DICTIONARY.get(character);
                    index = (index - key + Math.abs(key) * length) % length;
                    writer.write(Dictionary.CHAR_SYMBOLS[index]);
                } else if (character == '\n') {
                    writer.write(character);
                } else {
                    writer.write(character);
                }
                System.out.println(character);
            }
        } catch (FileNotFoundException e) {
            System.out.println(Textconstant.FILE_NOT_FOUND);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Text dicrypt");


    }
}
