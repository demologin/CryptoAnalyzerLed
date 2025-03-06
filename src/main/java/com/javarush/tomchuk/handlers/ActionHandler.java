package com.javarush.tomchuk.handlers;

import com.javarush.tomchuk.constant.ResultCode;
import com.javarush.tomchuk.util.PathBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class ActionHandler {

    abstract ResultCode handle(String[] arguments);

    protected static Character[] readChars(String sourcePath) {
        try (
                BufferedReader bufferedReader = Files.newBufferedReader(PathBuilder.getPath(sourcePath));
        ) {
            List<Character> allChars = new ArrayList<>();
            while (bufferedReader.ready()) {
                char character = (char) bufferedReader.read();
                allChars.add(character);
            }
            return allChars.toArray(new Character[0]);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    protected static ResultCode writeChars(String targetPath, Character[] characters) {
        try (
                BufferedWriter bufferedWriter = Files.newBufferedWriter(PathBuilder.getPath(targetPath));
        ) {
            bufferedWriter.write(Arrays.toString(characters));
            return ResultCode.OK;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return ResultCode.ERROR;
        }
    }
}