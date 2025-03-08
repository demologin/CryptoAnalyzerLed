package com.javarush.abdulkhanovmt.functionality;

import com.javarush.abdulkhanovmt.exception.CipherException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForce extends Cipher{

    private static boolean isTrueKey = false;
    private static int countInPrepositions = 0;

    public static void decodeByBruteForce(String sourceFile, String destinationFile){
        int key = 0;
        while(!isTrueKey) {
            decrypt(sourceFile, destinationFile, key);
            if(checkIfTextIsCorrect(destinationFile)){
                System.out.printf("Key \"%d\" is correct\n", key);
                clearBruteForce();
                return;
            } else{
                key++;
            }
        }
        clearBruteForce();
    }

    private static boolean checkIfTextIsCorrect(String sourceFile){
        Path src = FileManager.get(sourceFile);
        try(BufferedReader bufferedReader = Files.newBufferedReader(src)) {
            int symbol1 = 0;
            int symbol2 = 0;
            int symbol3 = 0;
            int i = 1;
            readEncryptedText(bufferedReader, i, symbol1, symbol2, symbol3);
            if(countInPrepositions>0){
                return true;
            }
        } catch (IOException e) {
            throw new CipherException(Const.INCORRECT_FILE + e.getMessage(), e);
        }
        return false;
    }

    private static void readEncryptedText(BufferedReader bufferedReader, int i, int symbol1, int symbol2, int symbol3) throws IOException {
        while (bufferedReader.ready()) {
            if(i ==1){
                symbol1 = bufferedReader.read();
            } else if(i ==2){
                symbol2 = bufferedReader.read();
            } else if(i ==3){
                symbol3 = bufferedReader.read();
            }
            if(i %3==0){
                char s1 = (char) symbol1;
                char s2 = (char) symbol2;
                char s3 = (char) symbol3;
                if(s1==' '&&s2=='в'&&s3==' '){
                    countInPrepositions++;
                }
                i = 0;
            }
            i++;
        }
    }

    private static void clearBruteForce(){
        countInPrepositions = 0;
        isTrueKey = false;
    }



}
