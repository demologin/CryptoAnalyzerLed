package com.javarush.kalichinskaia.logic.executor;


import com.javarush.kalichinskaia.logic.Result;

import java.util.List;

public interface Executor {
    Result execute(List<String> parameters);
}
