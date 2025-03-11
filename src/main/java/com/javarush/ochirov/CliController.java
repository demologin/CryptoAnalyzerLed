package com.javarush.ochirov;

import java.util.Scanner;

public class CliController
{
    private final Scanner scanner = new Scanner(System.in);

    public ApplicationArguments getArguments()
    {
        System.out.print(StringConstantsContainer.CLI_APP_DESCRIPTION);
        var mode = scanner.nextLine();

        System.out.println(StringConstantsContainer.CLI_SOURCE_PATH_DESCRIPTION);
        var sourcePath = scanner.nextLine();

        System.out.println(StringConstantsContainer.CLI_DESTINATION_PATH_DESCRIPTION);
        var destPath = scanner.nextLine();

        System.out.println(StringConstantsContainer.CLI_KEY_DESCRIPTION);
        var key = scanner.nextLine();

        var appArguments = new ApplicationArguments(mode, sourcePath, destPath, key);
        printArguments(appArguments);

        return appArguments;
    }

    public void println(String message)
    {
        System.out.println(message);
    }

    private void printArguments(ApplicationArguments applicationArguments)
    {
        println(StringConstantsContainer.CLI_SELECTED_MODE_DESCRIPTION + applicationArguments.mode());
        println(StringConstantsContainer.CLI_SELECTED_SOURCE_PATH_DESCRIPTION + applicationArguments.sourcePath());
        println(StringConstantsContainer.CLI_SELECTED_DEST_PATH_DESCRIPTION + applicationArguments.destPath());
        println(StringConstantsContainer.CLI_SELECTED_KEY_DESCRIPTION + applicationArguments.key());
    }
}
