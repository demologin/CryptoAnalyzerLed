package com.javarush.pyatigin.io;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreateFileWithDate {
    public Path CreateFileNameWithDate(Path pathFileInput) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_HH_mm_ss");
        String fileName = LocalDateTime.now().format(formatter) + pathFileInput.getFileName().toString();
        Path pathDirectory = pathFileInput.getParent();
        return pathDirectory.resolve(fileName);
    }
}
