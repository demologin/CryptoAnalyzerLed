package com.javarush.pyatigin.io;

import com.javarush.pyatigin.GetOptions;
import com.javarush.pyatigin.decode.BruteForce;
import com.javarush.pyatigin.decode.Decode;
import com.javarush.pyatigin.encode.Encode;

import java.io.*;
import java.nio.file.Path;

public class inputOutput {
    public inputOutput(GetOptions getOptions) {
        Path pathFileInput = getOptions.getPath();
        CreateFileWithDate createFileWithDate = new CreateFileWithDate();
        Path pathFileOutput = createFileWithDate.createFileNameWithDate(pathFileInput);
//        String dest = "C:\\vs\\log1.txt";
//        File outputFileName = new File(dest);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(pathFileInput.toFile())))) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathFileOutput.toFile()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (getOptions.getOption() == 1) {
                        Encode encode = new Encode();
                        line = encode.getEncode(line, getOptions.getKey());
                    } else if (getOptions.getOption() == 2) {
                        Decode decode = new Decode();
                        line = decode.getDecode(line, getOptions.getKey());
                    } else if (getOptions.getOption() == 3) {
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
