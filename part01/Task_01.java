// Instruction: Concatenate two strings and display the result using exactly one System.out.print.
public class Ex01 {
    public static void myConcat(String str1, String str2) {
        if (str1 == null) str1 = "";
        if (str2 == null) str2 = "";
        System.out.print(str1 + " " + str2);
    }
}