package com.javarush.kazakov.core.files;

import com.javarush.kazakov.constants.Constants;
import com.javarush.kazakov.core.Collector;
import com.javarush.kazakov.core.Translator;
import com.javarush.kazakov.core.exceptions.CryptoAnalyzerException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.javarush.kazakov.constants.Constants.DEFAULT_TEMP_NAME;
import static com.javarush.kazakov.constants.Constants.ROOT_FOLDER;

public class FileManager {
    public static final Path TEMP = Path.of(ROOT_FOLDER + File.separator + DEFAULT_TEMP_NAME);
    private final Path input;
    private final Path output;

    public FileManager(Path input) {
        this.input = absolutizePath(input);
        this.output = TEMP;
        validatePaths(this.input, this.output);
    }

    public FileManager(Path input, Path output) {
        this.input = absolutizePath(input);
        this.output = absolutizePath(output);
        validatePaths(this.input, this.output);
    }

    private <T> T read(Processable<?> p) {
        try (BufferedReader br = Files.newBufferedReader(input)) {
            return (T) p.process(br);
        } catch (IOException e) {
            throw new CryptoAnalyzerException("Error while processing file: " + e);
        }
    }

    public long translateFile(Translator translator) {
        long countChars = 0;
        try (BufferedReader reader = Files.newBufferedReader(input);
             BufferedWriter writer = Files.newBufferedWriter(output)) {
            while (reader.ready()) {
                String result = translator.translate(reader.readLine());
                writer.write(result);
                writer.newLine();
                countChars += result.length() + 1;
            }
        } catch (IOException e) {
            throw new CryptoAnalyzerException("Error while processing file: " + e);
        }
        return countChars;
    }

    @SuppressWarnings("unused")
    public long countChars() {
        return read((Processable<Long>) br -> {
            long result = 0;
            while (br.ready()) {
                result += br.readLine().length();
            }
            return result;
        });
    }

    public Collector collectData() {
        return read((Processable<Collector>) br -> {
            Collector collector = new Collector(input);
            while (br.ready()) {
                collector.collectCharsFromString(br.readLine());
            }
            return collector;
        });
    }

    public Collector collectData(long size) {
        return read((Processable<Collector>) br -> {
            Collector collector = new Collector(input);
            for (long i = 0; i < size; i++) {
                String s = br.readLine();
                i += s.length();
                collector.collectCharsFromString(s);
            }
            return collector;
        });
    }

    private void validatePaths(Path... paths) {
        FileValidator validator = new FileValidator(paths);
        validator.validate();
    }

    private Path absolutizePath(Path path) {
        if (!path.isAbsolute()) {
            return path.toAbsolutePath().normalize();
        }
        return path;
    }

    public Path getInput() {
        return input;
    }

    public Path getOutput() {
        return output;
    }
}

