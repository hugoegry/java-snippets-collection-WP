// Instruction : Return the word "woof" repeated nbr times using a for loop.

public class Ex02 {
    public static String getAngryDog(int nbr) {
        if (nbr <= 0) {
            return "\n";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nbr; i++) {
            sb.append("woof");
        }

        sb.append("\n");
        return sb.toString();
    }
}
