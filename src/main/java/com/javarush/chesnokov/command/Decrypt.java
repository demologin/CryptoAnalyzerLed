package com.javarush.chesnokov.command;

import com.javarush.chesnokov.result.Result;

public class Decrypt extends AbstractCommand{

    @Override
    public Result execute() {
        System.out.println("Выполняется дешифрование...");

        int shift = 1;
        String source = "C:\\Users\\derom\\IdeaProjects\\encode.txt";
        String target = "C:\\Users\\derom\\IdeaProjects\\decode.txt";

        return copyWithKey(source, target, -shift);
    }
}
