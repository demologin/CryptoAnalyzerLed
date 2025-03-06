package com.javarush.tomchuk.command;

import com.javarush.tomchuk.constant.ResultCode;

public interface Action {

    ResultCode execute(String sourceText, String destinationText);
}
