// Instruction : Return the received arguments in an ArrayList from a variable number of parameters. 
import java.util.ArrayList;
import java.util.Arrays;

public class Ex05 {
   public static ArrayList<String> myGetArgs(String... var) {
        if (var == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(Arrays.asList(var));
    }
}
