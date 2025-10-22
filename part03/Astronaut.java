/*
====================================================================
Part 03 : PACKAGES
====================================================================

This module goes deeper into Object-Oriented Programming by introducing:
  - the static keyword;
  - Java packages and sub-packages;
  - inter-class communication across multiple namespaces.

Exercises progressively build on previous ones (Mars, Astronaut, Team) and
focus on modular organization and object collaboration.

Summary of exercises:
  Ex01 → Mars class with auto-incremented id (using static).
  Ex02 → Astronaut class with unique id, private attributes, and creation message.
  Ex03 → Two Mars classes (chocolate.Mars and planet.Mars) demonstrating package management.
  Ex04 → Astronaut.doActions() handling multiple parameter types (none, planet.Mars, chocolate.Mars),
           updating destination or snack count accordingly.
  Ex05 → planet.moon.Phobos class holding a reference to a planet.Mars and its landing site.
  Ex06 → Team class managing astronauts: add, remove, countMembers, showMembers
           (displaying mission status or standby).
  Ex07 → Team.doActions() calls doActions() for all team members and handles shared chocolate
           and Phobos missions collectively.

General rules:
  - Commit only .java files, never .class files.
  - One public class per file, named exactly like the file.
  - Follow package structures strictly as specified.
  - Follow prototypes, method signatures, and expected outputs exactly.
  - Each display must end with a newline.
  - Manage ids using static attributes to ensure unique numbering across instances.
====================================================================
*/

public class Astronaut {
    private static int counter = 0; 
    private final int id = counter++;
    private String name;
    private int snacks = 0;
    private String destination = null;

    public Astronaut(String name) {
        this.name = name;
        System.out.println(this.name + " ready for launch!");
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getSnacks() {
        return this.snacks;
    }

    public String getDestination() {
        return this.destination;
    }

    public void doActions() {
        System.out.println(this.name + ": Nothing to do.");
        if (this.destination == null) {
            System.out.println(this.name + ": I may have done nothing, but I have " + this.snacks + " Mars to eat at least!");
        }
    }

    public void doActions(Object obj) {
        if (obj instanceof planet.Mars) {
            planet.Mars planetMars = (planet.Mars) obj;
            this.destination = planetMars.getLandingSite();
            System.out.println(this.name + ": Started a mission!");
        } else if (obj instanceof chocolate.Mars) {
            chocolate.Mars chocoMars = (chocolate.Mars) obj;
            this.snacks++;
            System.out.println(this.name + ": Thanks for this Mars number " + chocoMars.getId());
        } else if (obj instanceof planet.moon.Phobos) {
            planet.moon.Phobos phobos = (planet.moon.Phobos) obj;
            planet.Mars mars = phobos.getMars();
            this.destination = phobos.getLandingSite();
            System.out.println(this.name + ": Started a mission!");
        } else {
            System.out.println(this.name + ": Nothing to do.");
        }

        if (this.destination == null) {
            System.out.println(this.name + ": I may have done nothing, but I have " + this.snacks + " Mars to eat at least!");
        }
    }
}