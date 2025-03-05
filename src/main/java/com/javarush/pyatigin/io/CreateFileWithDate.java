package com.javarush.pyatigin.io;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreateFileWithDate {
    public Path createFileNameWithDate(Path pathFileInput) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_HH_mm_ss");
        try {
            String fileName = LocalDateTime.now().format(formatter) + pathFileInput.getFileName().toString();
            Path pathDirectory = pathFileInput.getParent();
            return pathDirectory.resolve(fileName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
