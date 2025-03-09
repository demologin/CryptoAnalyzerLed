package com.javarush.tomchuk.controller;

import com.javarush.tomchuk.constant.Menu;
import com.javarush.tomchuk.constant.Result;
import com.javarush.tomchuk.constant.ResultCode;
import com.javarush.tomchuk.constant.StandartOperation;

public class MainController {

    public static void noName() {
        StandartOperation operation = Menu.chooseOperation();
        String[] arguments;
        if (operation.equals(StandartOperation.EXIT) || operation.equals(StandartOperation.UNSUPPORTED_OPERATION)) {
            Result result = Result.getResult(operation, ResultCode.OK);
            System.out.println(Result.getMessage(result));
            noName();
            return;
        } else if (operation.equals(StandartOperation.ENCODE) || operation.equals(StandartOperation.DECODE)) {
            String[] files = Menu.uploadFilePaths();
            arguments = new String[] {files[0], files[1], Menu.getKey()};
        } else if (operation.equals(StandartOperation.ANALYZE) || operation.equals(StandartOperation.BRUTFORCE)) {
            arguments = Menu.uploadFilePaths();
        } else {
            arguments = new String[0];
        }
        Result result;
        try {
            result = Menu.execute(operation, arguments);
            System.out.println(Result.getMessage(result));
        } catch (NumberFormatException | NullPointerException e) {
            result = Result.OPERATION_ERROR;
            System.out.println(Result.getMessage(result));
            noName();
        }
    }
}
