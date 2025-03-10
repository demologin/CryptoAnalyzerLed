package com.javarush.smirnov;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Encode {

    int key;

    public Encode(int key){
        this.key = key;
    }

    public void EnCode(){

        Path pathFile = PathBuilder.GetPathFile();
        Path pathSaveFileToEncoding = PathBuilder.GetPathFileToSaveEncoding();

        int value;
        int index;
        try (BufferedReader bufRead = Files.newBufferedReader(pathFile);
             BufferedWriter bufWrite = Files.newBufferedWriter(pathSaveFileToEncoding)){
            while ((value = bufRead.read()) > -1){
                char ch = (char) value;
                ch = Character.toLowerCase(ch);
                if (Alfabet.map.containsKey(ch) || ch == '\n') {
                    if (ch == '\n'){
                        bufWrite.write('\n');
                    } else {
                        index = (Alfabet.map.get(ch) + key) % Alfabet.length;
                        bufWrite.write(Alfabet.alfabet[index]);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(Constants.incorInput);
        }

    }
}
