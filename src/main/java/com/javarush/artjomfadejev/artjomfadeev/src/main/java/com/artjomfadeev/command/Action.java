package com.javarush.artjomfadejev.artjomfadeev.src.main.java.com.artjomfadeev.command;

import com.javarush.artjomfadejev.artjomfadeev.src.main.java.com.artjomfadeev.entity.Result;

public interface Action {

    Result execute(String[] parameters);


}
