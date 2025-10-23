/*
===============================================================================
Part 04 : INHERITANCE
===============================================================================
Objective:
    Deep dive into Object-Oriented Programming (OOP) through the concepts of:
        - enum
        - static methods and fields
        - protected visibility
        - inheritance

Key Principle:
    Inheritance allows a class (child) to acquire the attributes and methods of
    another class (parent). For example:
        Apple inherits from Fruit → inherits eat() and color.
        GreenApple inherits from Apple and therefore from Fruit too.

    Non-private members (methods and attributes) are inherited.
    Inheritance can be chained indefinitely.

Naming Convention:
    - All output messages must end with a newline.
    - Getters/Setters follow CamelCase convention:
        Example: attribute `bobby` → getBobby() / setBobby().

===============================================================================
🧩 EXERCISE 01 — ./Animal.java
===============================================================================
1. Create a class `Animal` with:
    - protected enum Type { MAMMAL, FISH, BIRD }
    - protected attributes: name, legs, type

2. Add a protected constructor:
       Animal(String name, int legs, Type type)
       - Stores the parameters in the corresponding attributes.
       - Displays: "My name is [name] and I am a [type]!"

3. Add getters for all attributes:
       getName(), getLegs(), getType()

    ⚠️ No setter for legs (animals never lose legs).
    ⚠️ getType() should NOT return the enum value directly — follow example output.

4. The constructor is protected → cannot always be instantiated directly.

Example:
    Animal isidore = new Animal("Isidore", 4, Animal.Type.MAMMAL);
    Output:
        My name is Isidore and I am a mammal!
        Isidore has 4 legs and is a mammal.

===============================================================================
🧩 EXERCISE 02 — ./Animal.java
===============================================================================
1. Add private static fields:
       numberOfAnimals, numberOfMammals, numberOfFish, numberOfBirds

2. Add corresponding getters:
       getNumberOfAnimals(), getNumberOfMammals(), getNumberOfFish(), getNumberOfBirds()

3. Each getter:
       - Returns the number of instances.
       - Displays:
            - "There are currently [x] animals in our world."   (x ≥ 2)
            - "There is currently 1 animal in our world."
            - "There are currently 0 animals in our world."

4. Same logic for each type (mammals, fish, birds).
5. Animals never die → counters only increase.

===============================================================================
🧩 EXERCISE 03 — ./Cat.java
===============================================================================
1. Create a class `Cat` that inherits from `Animal`.

2. Attributes:
       private String color (getter only)

3. Constructor:
       Cat(String name, String color)
           - Sets legs = 4, type = MAMMAL
           - Default color = "grey" if not specified
           - Displays:
                 "My name is [name] and I am a mammal!"
                 "[name]: MEEEOOWWWW"

4. Method:
       public void meow()
           Displays: "[name] the [color] kitty is meowing."

Example:
    Cat isidore = new Cat("Isidore", "orange");
    Output:
        My name is Isidore and I am a mammal!
        Isidore: MEEEOOWWWW
        Isidore has 4 legs and is a mammal.
        Isidore the orange kitty is meowing.

===============================================================================
🧩 EXERCISE 04 — ./Shark.java & ./Canary.java
===============================================================================
🔹 SHARK CLASS:
    - Inherits from Animal.
    - Constructor:
         Shark(String name)
             - legs = 0, type = FISH
             - Displays:
                 "My name is [name] and I am a fish!"
                 "A KILLER IS BORN!"
    - Private boolean frenzy = false
    - Methods:
         void smellBlood(boolean state)
             → sets frenzy to the given value
         void status()
             → "[name] is smelling blood and wants to kill." if frenzy = true
             → "[name] is swimming peacefully." otherwise

🔹 CANARY CLASS:
    - Inherits from Animal.
    - Constructor:
         Canary(String name)
             - legs = 2, type = BIRD, eggs = 0
             - Displays:
                 "My name is [name] and I am a bird!"
                 "Yellow and smart? Here I am!"
    - Private int eggs
    - Methods:
         int getEggsCount()
         void layEgg()
             → increases eggs by 1

===============================================================================
🧩 EXERCISE 05 — ./Shark.java
===============================================================================
Add methods to the Shark class:

    boolean canEat(Animal a)
        → returns true if Shark can eat the given animal.

    void eat(Animal a)
        → Displays:
            "[SharkName] ate a [AnimalType] named [AnimalName]." if canEat() = true
            "[SharkName]: It's not worth my time." otherwise
        → frenzy must reset to false after eating.
        → Shark cannot eat itself.

===============================================================================
🧩 EXERCISE 06 — ./BlueShark.java & ./GreatWhite.java
===============================================================================
Create subclasses of Shark:

🔹 BlueShark:
    - Can only eat FISH.
    - Override canEat() accordingly.

🔹 GreatWhite:
    - Refuses to eat Canary:
        Displays: "[name]: Next time you try to give me that to eat, I'll eat you instead."
    - If it eats another Shark:
        After eating → "[name]: The best meal one could wish for."
    - Otherwise → behaves like Shark.

    ⚙️ Use @Override annotation and instanceof keyword properly.

===============================================================================
*/

class TestMain { // this is just for testing purposes \\
    public static void main(String[] args) {
       Cat isidore = new Cat("Isidore", "orange");
        System.out.println(isidore.getName() + " has " + isidore.getLegs() + " legs and is a " + isidore.getType() + ".");
        isidore.meow();
        Canary titi = new Canary("Titi");
        Shark willy = new Shark("Willy");
        willy.status();
        willy.smellBlood(true);
        willy.status();
        titi.layEgg();
        System.out.println(titi.getEggsCount());

        BlueShark blue = new BlueShark("Bluey");
        GreatWhite white = new GreatWhite("Whitey");

        white.smellBlood(true);
        white.eat(titi);
        white.eat(willy);
    }
}
