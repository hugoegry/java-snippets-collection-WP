/*
====================================================================
Parte 02 : OBJECT ORIENTED PROGRAMMING
====================================================================

This module introduces Object Oriented Programming through the Gecko class.
Exercises progressively build key OOP principles:
  - Class definition and object instantiation;
  - Constructors with and without parameters;
  - Attributes and methods (visibility, getters, setters);
  - Method overloading (hello, eat, work, fraternize);
  - State management (energy, age, name);
  - Control structures (switch) and basic polymorphism;
  - Object interaction (Gecko ↔ Gecko, Gecko ↔ Snake).

Each exercise extends the Gecko class with new behavior:
  Ex01 → Create a class and display a welcome message.
  Ex02 → Add a constructor with name handling and default value.
  Ex03 → Encapsulate the name and add a getter method.
  Ex04 → Add an age attribute with getter/setter and status() logic.
  Ex05 → Overload hello() to react to string or integer input.
  Ex06 → Implement eat() with energy management and boundaries.
  Ex07 → Add work() depending on energy level.
  Ex08 → Implement fraternize() for Gecko and Snake interactions.

Strict rules:
  - Do NOT use packages.
  - Commit only .java files, never .class files.
  - One class per file, named exactly like the file.
  - Follow prototypes, signatures, and expected outputs precisely.
  - Always print a newline after each output.
====================================================================
*/

public class Gecko {
    // Attributs \\
    private String name = "Unknown";
    private int age = 0;
    private int energy = 100;

    
    // Constructeurs \\
    public Gecko() {
        System.out.println("Hello!");
    }

    public Gecko(String name) {
        this.name = name;
        System.out.println("Hello " + this.name + "!");
    }

    public Gecko(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Hello " + this.name + "!");
    }


    // Getters / Setters \\
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getEnergy() {
        return this.energy;
    }

    public void setEnergy(int energy) {
        if (energy < 0) {
            this.energy = 0;
        } else if (energy > 100) {
            this.energy = 100;
        } else {
            this.energy = energy;
        }
    }

    // Méthodes \\
    public void status() {
        switch (this.age) {
            case 0:
                System.out.println("Unborn Gecko");
                break;
            case 1:
            case 2:
                System.out.println("Baby Gecko");
                break;
            case 3: case 4: case 5: case 6:
            case 7: case 8: case 9: case 10:
                System.out.println("Adult Gecko");
                break;
            case 11:
            case 12:
            case 13:
                System.out.println("Old Gecko");
                break;
            default:
                System.out.println("Impossible Gecko");
                break;
        }
    }

    // public void hello (Object obj) {
    //     if (obj instanceof String) {
    //         System.out.println("Hello " + obj + ", I'm " + this.name + "!");
    //     } else if (obj instanceof Integer) {
    //         int nb = (Integer) obj;
    //         for (int i = 0; i < nb; i++) {
    //             System.out.println("Hello, I'm " + this.name + "!");
    //         }
    //     }
    // }

    public void hello(String name) {
        System.out.println("Hello " + name + ", I'm " + this.name + "!");
    }

    public void hello(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Hello, I'm " + this.name + "!");
        }
    }

    public void eat(String food) {
        if (food == null) return; // sécurité de base

        String lower = food.toLowerCase();
        switch (lower) {
            case "meat":
                System.out.println("Yummy!");
                this.setEnergy(this.energy + 10);
                break;
            case "vegetable":
                System.out.println("Erk!");
                this.setEnergy(this.energy - 10);
                break;
            default:
                System.out.println("I can't eat this!");
                break;
        }
    }

    public void work() {
        if (this.energy >= 25) {
            System.out.println("I'm working T.T");
            this.setEnergy(this.energy - 9);
        } else {
            System.out.println("Heyyy I'm too sleepy, better take a nap!");
            this.setEnergy(this.energy + 50);
        }
        
    }


    public void fraternize(Object other) {
        if (other == null) return;
        if (other instanceof Gecko) {
            Gecko friend = (Gecko) other;

            boolean selfTired = this.energy < 30;
            boolean friendTired = friend.energy < 30;

            if (selfTired && friendTired) {
                System.out.println("Not today!");
                friend.sayNotToday();
            } else if (!selfTired && !friendTired) {
                System.out.println("I'm going to drink with " + friend.name + "!");
                friend.respondDrink(this);
                this.setEnergy(this.energy - 30);
                friend.setEnergy(friend.energy - 30);
            } else if (selfTired) {
                System.out.println("Sorry " + friend.name + ", I'm too tired to go out tonight.");
                friend.respondTooBad();
            } else {
                friend.sayTooTired(this);
            }
        } else if (other instanceof Snake) {
            if (this.energy >= 10) {
                System.out.println("LET'S RUN AWAY!!!");
                this.setEnergy(0);
            } else {
                System.out.println("...");
            }
        }
    }

    private void respondDrink(Gecko other) {
        System.out.println("I'm going to drink with " + other.name + "!");
    }

    private void sayTooTired(Gecko other) {
        System.out.println("Sorry " + other.name + ", I'm too tired to go out tonight.");
        System.out.println("Oh! That's too bad, another time then!");
    }

    private void respondTooBad() {
        System.out.println("Oh! That's too bad, another time then!");
    }

    private void sayNotToday() {
        System.out.println("Not today!");
    }

}