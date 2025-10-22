package chocolate;

public class Mars {
    private static int counter = 0;
    private final int id = counter++;
    public Mars() {
    }

    public int getId() {
        return id;
    }

}
