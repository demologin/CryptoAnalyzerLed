package com.javarush.kazakov.core.files;

import com.javarush.kazakov.core.Collector;
import com.javarush.kazakov.core.Translator;
import com.javarush.kazakov.core.exceptions.CryptoAnalyzerException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.javarush.kazakov.constants.Constants.DEFAULT_TEMP_NAME;
import static com.javarush.kazakov.constants.Constants.ROOT_FOLDER;

/**
 * The {@code FileManager} class encapsulates operations performed with files.
 * <p>
 * {@code FileManager} has two constructors, one of them accepts only an input file path,
 * the output is assigned to a temporary file path.
 * Second constructor accepts both an input path and an output path.
 * <p>
 * The main purpose of the class is to translate the state of a file to a new state
 * and write the new state using {@code translateFile(Translator)}.
 * Additionally, the class can collect data from files.
 * Also, all input parameters are automatically validated.
 *
 * @see Collector
 * @see Translator
 * @see FileValidator
 * @see FileManager#translateFile(Translator)
 */
public class FileManager {
    public static final Path TEMP = Path.of(ROOT_FOLDER + File.separator + DEFAULT_TEMP_NAME);
    private final Path input;
    private final Path output;

    /**
     * Creates an object of {@code FileManager}.
     * Assigning the output to a temporary file path.
     *
     * @param input Input file path
     */
    public FileManager(Path input) {
        this.input = absolutizePath(input);
        this.output = TEMP;
        validatePaths(this.input, this.output);
    }

    /**
     * Creates an object of {@code FileManager}.
     *
     * @param input Input file path
     * @param output Output file path
     */
    public FileManager(Path input, Path output) {
        this.input = absolutizePath(input);
        this.output = absolutizePath(output);
        validatePaths(this.input, this.output);
    }

    /**
     * This method is an attempt to experiment with functional programming(closures).
     * It does not claim to be the right solution, it was created just for fun.
     *
     * @param p Instance of {@code Processable<?>}
     * @see Processable
     */
    private <T> T read(Processable<?> p) {
        try (BufferedReader br = Files.newBufferedReader(input)) {
            return (T) p.process(br);
        } catch (IOException e) {
            throw new CryptoAnalyzerException("Error while processing file: " + e);
        }
    }

    /**
     * Translates the input file into a new state line by line and writes that state to the output file.
     *
     * @param translator {@link Translator} instance
     * @return Number of characters written
     */
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

    /**
     * Counts the number of characters in the input file.
     *
     * @return Number of characters
     */
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

    /**
     * Collects all information from a file.
     *
     * @return {@link Collector} instance of input file
     */
    public Collector collectData() {
        return read((Processable<Collector>) br -> {
            Collector collector = new Collector(input);
            while (br.ready()) {
                collector.collectCharsFromString(br.readLine());
            }
            return collector;
        });
    }

    /**
     * Collects information from a file, limited by the number of characters required for reading.
     * Works with a small infelicity, because the file is read line by line.
     *
     * @param size {@code long} number of characters required to read.
     * @return {@link Collector} instance of input file.
     */
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

