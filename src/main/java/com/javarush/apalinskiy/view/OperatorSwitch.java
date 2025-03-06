package com.javarush.apalinskiy.view;

import java.io.IOException;
import java.util.Scanner;

public class OperatorSwitch {
   public void Switch() throws IOException {
       Scanner scanner = new Scanner(System.in);
       CommandRunner cm = new CommandRunner();
       switch (scanner.nextInt()) {
           case 1:
               cm.Runner(1);
               break;
           case 2:
               cm.Runner(2);
               break;
           case 3:
               cm.Runner(3);
               break;
           case 4:
               break;
           default:
               throw new IndexOutOfBoundsException();
       }
   }
}
