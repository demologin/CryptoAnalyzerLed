package com.javarush.kalichinskaia.console.args;

import java.util.List;
import java.util.Scanner;

public interface ArgsProvider {
    List<String> get(Scanner scanner);
}
