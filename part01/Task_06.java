// Instruction : Print the "look-and-say" sequence up to iteration nbr (0-indexed), print nothing if nbr < 0.
public class Ex06 {
    public static void sequence(int nbr) {
        if (nbr < 0) return;

        String current = "1";
        System.out.println(current);

        for (int i = 0; i < nbr; i++) {
            StringBuilder next = new StringBuilder();

            int count = 1;
            for (int j = 1; j <= current.length(); j++) {
                if (j < current.length() && current.charAt(j) == current.charAt(j - 1)) {
                    count++;
                } else {
                    next.append(count).append(current.charAt(j - 1));
                    count = 1;
                }
            }

            current = next.toString();
            System.out.println(current);
        }
    }
}
