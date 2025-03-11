package com.javarush.ochirov;

import com.javarush.ochirov.exception.ApplicationException;

public class ConsoleApplication
{
    private final FileProcessor fileProcessor = new FileProcessor();
    private final CliController cliController = new CliController();

    public void run()
    {
        var appArguments = cliController.getArguments();
        try
        {
            var resultMessage = fileProcessor.copyWithOffset(appArguments) == 0
                    ? StringConstantsContainer.CLI_COMPLETED_DESCRIPTION
                    : StringConstantsContainer.CLI_FAILED_DESCRIPTION;

            cliController.println(resultMessage);
        }
        catch (ApplicationException e)
        {
            cliController.println(e.getMessage() + e);
        }
    }
}
