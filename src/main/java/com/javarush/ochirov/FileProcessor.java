package com.javarush.ochirov;

import com.javarush.ochirov.exception.ApplicationException;
import com.javarush.ochirov.exception.ErrorCode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessor
{
    public int copyWithOffset(ApplicationArguments applicationArguments)
    {
        var mode = applicationArguments.mode();
        if (!mode.equals(StringConstantsContainer.ENCRYPT_MODE_ARGUMENT)
                && !mode.equals(StringConstantsContainer.DECRYPT_MODE_ARGUMENT))
        {
            throw new ApplicationException(StringConstantsContainer.INVALID_MODE_ERROR_DESCRIPTION, ErrorCode.INCORRECT_MODE_ERROR);
        }

        var sourcePath = buildPath(applicationArguments.sourcePath());
        var destPath = buildPath(applicationArguments.destPath());
        try (var bufferedReader = Files.newBufferedReader(sourcePath);
             var bufferedWriter = Files.newBufferedWriter(destPath))
        {
            int readSymbolCode;
            while ((readSymbolCode = bufferedReader.read()) != -1)
            {
                var readSymbol = (char) readSymbolCode;
                var alphabetLength = Alphabet.CHAR_ARRAY.length;
                if (Alphabet.CHAR_INDEX.containsKey(readSymbol))
                {
                    var index = Alphabet.CHAR_INDEX.get(readSymbol);
                    var key = Integer.parseInt(applicationArguments.key());
                    var shiftedIndex = (index + key + (Math.abs(index) + Math.abs(key)) * alphabetLength) % alphabetLength;
                    bufferedWriter.write(Alphabet.CHAR_ARRAY[shiftedIndex]);
                }
            }
        }
        catch (NumberFormatException e)
        {
            throw new ApplicationException(StringConstantsContainer.INVALID_KEY_ERROR_DESCRIPTION, e, ErrorCode.PARSE_KEY_ERROR);
        }
        catch (IOException e)
        {
            throw new ApplicationException(StringConstantsContainer.INVALID_PATH_ERROR_DESCRIPTION, e, ErrorCode.INCORRECT_FILE_ERROR);
        }

        return 0;
    }

    private Path buildPath(String filename)
    {
        var path = Path.of(filename);
        if (!path.isAbsolute())
        {
            path = Path.of(System.getProperty(StringConstantsContainer.PATH_USER_DIR)
                    + File.separator
                    + StringConstantsContainer.PATH_TEXT
                    + File.separator
                    + filename);
        }

        return path;
    }
}
