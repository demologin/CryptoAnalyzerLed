package com.javarush.pyatigin.io;

import com.javarush.pyatigin.GetOptions;
import com.javarush.pyatigin.decode.BruteForce;
import com.javarush.pyatigin.decode.Decode;
import com.javarush.pyatigin.encode.Encode;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class InputOutput {


    public InputOutput() {
    }

    public Path inputOutput(GetOptions getOptions) {
        Path pathFileInput = getOptions.getPath();
        Path pathFileOutput = new CreateFileWithDate().createFileNameWithDate(pathFileInput);
        try (BufferedReader reader = Files.newBufferedReader(pathFileInput)) {
            try (BufferedWriter writer = Files.newBufferedWriter(pathFileOutput)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    switch (getOptions.getOption()) {
                        case 1 -> {
                            Encode encode = new Encode();
                            line = encode.getEncode(line, getOptions.getKey());
                        }
                        case 2 -> {
                            Decode decode = new Decode();
                            line = decode.getDecode(line, getOptions.getKey());
                        }
                        case 3 -> {
                            BruteForce bf = new BruteForce();
                            line = bf.getBruteForce(line);
                        }
                    }
                    writer.write(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return pathFileOutput;
    }
}