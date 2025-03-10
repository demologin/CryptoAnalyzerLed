package com.javarush.artjomfadejev.artjomfadeev.src.main.java.com.artjomfadeev.controller;

import com.javarush.artjomfadejev.artjomfadeev.src.main.java.com.artjomfadeev.command.Action;
import com.javarush.artjomfadejev.artjomfadeev.src.main.java.com.artjomfadeev.entity.Result;
import com.javarush.artjomfadejev.artjomfadeev.src.main.java.com.artjomfadeev.entity.ResultCode;
import com.javarush.artjomfadejev.artjomfadeev.src.main.java.com.artjomfadeev.exception.AppException;

public class MainController {

    public Result doAction(String actionName, String[] parameters) {
        Action action = ActionContainer.get(actionName);
        try {
            return action.execute(parameters);
        } catch (NumberFormatException | AppException e) {
            return new Result(ResultCode.ERROR, e.getMessage());
        }
    }
}
