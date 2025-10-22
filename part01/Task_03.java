// Instruction : Print each element of an ArrayList on a new line using exactly one for loop.
import java.util.ArrayList;

public class Ex03 {
    public static void printArray(ArrayList<String> element) {
        if (element != null && !element.isEmpty()) {
            for (String str : element) {
                System.out.println(str);
            }
        }
    }
}
