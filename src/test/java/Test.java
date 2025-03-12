
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringJoiner;

import com.javarush.pukhov.command.ActionName;
import com.javarush.pukhov.constant.AlphabetCaesar;
import com.javarush.pukhov.constant.Constants;
import com.javarush.pukhov.util.BuilderPath;
import com.javarush.pukhov.view.console.constants.Messages;

public class Test {
    public static void main(String[] args) {
        testAlphabet();
        // testURL();
        // testActionName("123");
        // testActionNameSize(10);
        // testErrorMessage();
        // testStackTrace();
    }

    private static void testAlphabet() {
        Map<Character, Integer> alphabet = AlphabetCaesar.getAlphabet();
        alphabet.remove('к');
        System.out.println(alphabet);
    }

    private static void testURL() {
        ArrayList<String> list;
        System.out.println(Constants.PATH_REPOSITORY);
        System.out.println(BuilderPath.buildPath("dict.txt"));
    }

    private static void testStackTrace() {
        StringBuilder errorBuilder = new StringBuilder();
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            throw new Exception("Check stack trace");
        } catch (Exception e) {
            e.printStackTrace(pw);
            // errorBuilder.append("Сообщение: ").append(e.getMessage()).append("\nСтек
            // вызовов:\n").append(sw.toString());
        }
        try {
            throw new Exception("New check stack trace");
        } catch (Exception e) {
            e.printStackTrace(pw);
            errorBuilder.append("Сообщение: ").append(e.getMessage()).append("\nСтек вызовов:\n").append(sw.toString());
        }
        System.out.print(errorBuilder);
    }

    private static void testErrorMessage() {
        StringJoiner joiner = new StringJoiner(" and ");
        // joiner.add(Messages.INCORRECT_NUMBER);
        System.out.println(joiner.length());
        // joiner.add("%1$s - is not an action");
        String message = String.format(joiner.toString(), "uipo");
        System.out.println(message);
    }

    private static void testActionNameSize(int index) {
        int size = ActionName.values().length;
        System.out.println(size);
        ActionName name = ActionName.values()[index];
        System.out.println(name);
    }

    private static void testActionName(String checkString) {
        ActionName name = ActionName.valueOf(checkString);
        System.out.println(name);
    }

}
