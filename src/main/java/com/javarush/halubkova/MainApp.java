package com.javarush.halubkova;

import com.javarush.halubkova.cipher.Alphabet;
import com.javarush.halubkova.cipher.Cipher;
import com.javarush.halubkova.exception.*;
import com.javarush.halubkova.filemanager.FileManager;
import com.javarush.halubkova.ui.Dialog;
import com.javarush.halubkova.ui.DialogDTO;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public class MainApp {
    private static final int MODE_ENCODE = 1;
    private static final int MODE_DECODE = 2;

    public static void main(String[] args) throws CharNotFoundException, ShiftNotValidException, FileNameException, FileNotFoundException, IOException {
        Dialog dialog = new Dialog();
        DialogDTO dto = dialog.ask();
        int operation = dto.getOperation();
        String inputFilePath = dto.getInputFilePath();
        int keyCipher = dto.getKeyCipher();
        String outputFileName = dto.getOutputFileName();

        String pathOfOutputFile = Path.of(inputFilePath).getParent() + "\\" + outputFileName;
        FileManager.createFile(pathOfOutputFile);

        Cipher cip = new Cipher(Alphabet.getAlphabet());
        Stream<String> text = FileManager.readFile(inputFilePath);

        text.forEach(str -> {
            String result = "";
            if (operation == MODE_ENCODE) {
                result = cip.encrypt(str, keyCipher);
            }
            if (operation == MODE_DECODE) {
                result = cip.decrypt(str, keyCipher);
            }
            try {
                FileManager.writeFile(result, pathOfOutputFile);
            } catch (IOException e) {
                throw new OutputFileException();
            }
        });

    }
}
