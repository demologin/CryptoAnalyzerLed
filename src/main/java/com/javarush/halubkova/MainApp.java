package com.javarush.halubkova;

import java.io.IOException;
import java.nio.file.Path;

public class MainApp {
    private static final int MODE_ENCODE = 1;
    private static final int MODE_DECODE = 2;

    public static void main(String[] args) throws IOException, CharNotFoundException, ShiftNotValidException, FileNameException {

        Dialog dialog = new Dialog();
        DialogDTO dto = dialog.ask();
        int operation = dto.getOperation();
        String inputFilePath = dto.getInputFilePath();
        int keyCipher = dto.getKeyCipher();
        String outputFileName = dto.getOutputFileName();

        Cipher cip = new Cipher(Alphabet.getAlphabet());
        String text = FileManager.readFile(inputFilePath);

        String result = "";
        if (operation == MODE_ENCODE) {
            result = cip.encrypt(text, keyCipher);
        }
        if (operation == MODE_DECODE) {
            result = cip.decrypt(text, keyCipher);
        }
        String pathOfOutputFile = Path.of(inputFilePath).getParent() + "\\" + outputFileName;
        FileManager.createFile(pathOfOutputFile);
        FileManager.writeFile(result, pathOfOutputFile);

    }

}
