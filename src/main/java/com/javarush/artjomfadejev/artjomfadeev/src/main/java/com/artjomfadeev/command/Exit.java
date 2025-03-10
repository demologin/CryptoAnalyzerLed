package com.javarush.artjomfadejev.artjomfadeev.src.main.java.com.artjomfadeev.command;

import com.javarush.artjomfadejev.artjomfadeev.src.main.java.com.artjomfadeev.constant.Const;
import com.javarush.artjomfadejev.artjomfadeev.src.main.java.com.artjomfadeev.entity.Result;
import com.javarush.artjomfadejev.artjomfadeev.src.main.java.com.artjomfadeev.entity.ResultCode;

public class Exit extends AbstractAction {

    @Override
    public Result execute(String[] parameters) {
        return new Result(ResultCode.OK, Const.APPLICATION_CLOSED);
    }
}
