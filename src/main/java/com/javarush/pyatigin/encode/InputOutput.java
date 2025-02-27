package com.javarush.pyatigin.encode;
import com.javarush.pyatigin.GetOptions;
import java.io.*;
import java.nio.file.Path;
public class InputOutput {
    public InputOutput(GetOptions getOptions) {
        Path path=getOptions.path;
        String dest="C:\\vs\\log1.txt";
        File outputFileName=new File(dest);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path.toFile())))) {
            try (BufferedWriter writter = new BufferedWriter(new FileWriter(outputFileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if(getOptions.option==1){
                       Encode encode= new Encode();
                       line=encode.Encode(line,getOptions.key);
                   }
                    writter.write(line);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
}
}
