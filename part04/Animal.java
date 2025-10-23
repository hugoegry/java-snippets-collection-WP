public class Animal {
    protected enum Type {MAMMAL, FISH, BIRD}
    private String name;
    private int legs;
    private Type type;

    private static int numberOfAnimals = 0;
    private static int numberOfMammals = 0;
    private static int numberOfFish = 0;
    private static int numberOfBirds = 0;

    protected Animal(String name, int legs, Type type) {
        this.name = name;
        this.legs = legs;
        this.type = type;
        System.out.println("My name is " + this.name + " and I am a " + this.getType() + "!");
        numberOfAnimals++;
        switch (type) {
            case MAMMAL -> numberOfMammals++;
            case FISH -> numberOfFish++;
            case BIRD -> numberOfBirds++;
        }
    }
    public String getName() {
        return this.name;
    }

    public int getLegs() {
        return this.legs;
    }

    public String getType() {
        return switch (type) {
            case MAMMAL -> "mammal";
            case FISH -> "fish";
            case BIRD -> "bird";
        };
    }


    ///---------------------------------
    /// 
    /// 
    /// 
    public static int getNumberOfAnimals() {
        displayCount("animal", numberOfAnimals);
        return numberOfAnimals;
    }

    public static int getNumberOfMammals() {
        displayCount("mammal", numberOfMammals);
        return numberOfMammals;
    }

    public static int getNumberOfFish() {
        displayCount("fish", numberOfFish);
        return numberOfFish;
    }

    public static int getNumberOfBirds() {
        displayCount("bird", numberOfBirds);
        return numberOfBirds;
    }

    private static void displayCount(String type, int count) {
        String plural = (count == 1) ? "" : (type.equals("fish") ? "" : "s"); // gere le pluriel avec exception pour fish  \\
        String verb = (count == 1) ? "is" : "are"; // gere le verbe \\
        System.out.println("There " + verb + " currently " + count + " " + type + plural + " in our world.");
    }
}