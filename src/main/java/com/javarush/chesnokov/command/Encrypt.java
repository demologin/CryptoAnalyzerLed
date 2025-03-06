package com.javarush.chesnokov.command;


import com.javarush.chesnokov.result.Result;

public class Encrypt extends AbstractCommand {

    @Override
    public Result execute() {
        System.out.println("Выполняется шифрование...");

        int shift = 1;
        String source = "C:\\Users\\derom\\IdeaProjects\\text.txt";
        String target = "C:\\Users\\derom\\IdeaProjects\\encode.txt";

        return copyWithKey(source, target, shift);
    }
}
