package com.javarush.burdygin.activity;

import java.util.Map;

public interface Mode {
    default void start(Map<String, String> map, Activity activity){
    }
}
