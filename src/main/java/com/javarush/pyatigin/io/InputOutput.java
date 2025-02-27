package com.javarush.pyatigin.io;

import com.javarush.pyatigin.GetOptions;
import com.javarush.pyatigin.decode.BruteForce;
import com.javarush.pyatigin.decode.Decode;
import com.javarush.pyatigin.encode.Encode;

import java.io.*;
import java.nio.file.Path;

public class InputOutput {
    public InputOutput(GetOptions getOptions) {
        Path pathFileInput = getOptions.path;
        CreateFileWithDate createFileWithDate = new CreateFileWithDate();
        Path pathFileOutput = createFileWithDate.CreateFileNameWithDate(pathFileInput);
//        String dest = "C:\\vs\\log1.txt";
//        File outputFileName = new File(dest);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(pathFileInput.toFile())))) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathFileOutput.toFile()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (getOptions.option == 1) {
                        Encode encode = new Encode();
                        line = encode.getEncode(line, getOptions.key);
                    } else if (getOptions.option == 2) {
                        Decode decode = new Decode();
                        line = decode.getDecode(line, getOptions.key);
                    } else if (getOptions.option == 3) {
                        BruteForce bf = new BruteForce();
                        line = bf.getBruteForce(line);
                    }
                    writer.write(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
