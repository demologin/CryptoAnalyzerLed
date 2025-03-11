package com.javarush.ochirov;

public record ApplicationArguments(String mode, String sourcePath, String destPath, String key)
{
    public ApplicationArguments(String mode, String sourcePath, String destPath, String key)
    {
        this.mode = "".equals(mode) ? StringConstantsContainer.DEFAULT_MODE_ARGUMENT : mode;
        this.sourcePath = "".equals(sourcePath) ? StringConstantsContainer.DEFAULT_SOURCE_PATH_ARGUMENT : sourcePath;
        this.destPath = "".equals(destPath) ? StringConstantsContainer.DEFAULT_DEST_PATH_ARGUMENT : destPath;
        this.key = "".equals(key) ? StringConstantsContainer.DEFAULT_KEY_ARGUMENT : key;
    }
}
