/*
===============================================================================
Part 05 : ABSTRACT CLASSES AND INTERFACES
===============================================================================
Objective:
    Deepen your understanding of Object-Oriented Programming (OOP) by exploring:
        - abstract classes
        - abstract methods
        - interfaces
        - polymorphism through inheritance and contracts

Key Principles:
    • Abstract Class:
        - Cannot be instantiated directly.
        - Must be extended by concrete child classes.
        - Can contain both implemented and abstract methods.
        - Declared using the `abstract` keyword.
        Example:
            abstract class Animal { abstract void speak(); }

    • Abstract Method:
        - Declared without implementation inside an abstract class.
        - Must be overridden in any non-abstract subclass.

    • Interface:
        - Defines a behavioral contract with only abstract methods (implicitly public and abstract).
        - A class can `implement` one or several interfaces.
        - By convention:
              Interfaces start with 'I'
              Abstract classes start with 'A'

    • Polymorphism:
        - Allows multiple object types (sharing a common parent or interface) to be used interchangeably.

Naming Convention:
    - All output messages must end with a newline.
    - Getters/Setters follow CamelCase convention:
          Example: attribute `bobby` → getBobby() / setBobby().

===============================================================================
🧩 EXERCISE 01 — ./Weapon.java
===============================================================================
Create an abstract class `Weapon` with protected attributes:
    - String name
    - int apcost
    - int damage
    - boolean melee

Requirements:
    - Constructor (protected): Weapon(String name, int apcost, int damage, boolean melee)
    - Getters only (no setters): getName(), getApcost(), getDamage(), isMelee()
    - One abstract method:
          public abstract void attack();

Notes:
    - Abstract classes cannot be instantiated directly.
    - Boolean ≠ boolean (autoboxing not automatic).

===============================================================================
🧩 EXERCISE 02 — ./PlasmaRifle.java & ./PowerFist.java
===============================================================================
Create two classes inheriting from Weapon:

    PlasmaRifle:
        - name = "Plasma Rifle"
        - damage = 21
        - apcost = 5
        - melee = false
        - attack(): displays "PIOU"

    PowerFist:
        - name = "Power Fist"
        - damage = 50
        - apcost = 8
        - melee = true
        - attack(): displays "SBAM"

Use the parent constructor (super) — do not reimplement logic redundantly.

===============================================================================
🧩 EXERCISE 03 — ./Fighter.java
===============================================================================
Create an interface `Fighter` that defines the following methods:

    boolean equip(Weapon w);
    boolean attack(Fighter target);
    void receiveDamage(int damage);
    boolean moveCloseTo(Fighter target);
    void recoverAP();
    String getName();
    int getAp();
    int getHp();

All implementing classes (Monsters, SpaceMarines) must adhere to this contract.

===============================================================================
🧩 EXERCISE 04 — ./Unit.java
===============================================================================
Create an abstract class `Unit` that implements `Fighter`.

Attributes:
    - String name
    - int hp
    - int ap
    - Fighter closeTarget

Constructor (protected):
    Unit(String name, int hp, int ap)

Methods to implement:
    - getName(), getHp(), getAp(), getCloseTarget()
    - receiveDamage(int)
    - moveCloseTo(Fighter)
    - recoverAP()

Rules:
    - HP cannot go below 0.
    - If HP ≤ 0, the Unit is considered dead (only getters remain functional).
    - recoverAP() increases AP by 7 (max 50).

===============================================================================
🧩 EXERCISE 05 — ./Monster.java & ./SpaceMarine.java
===============================================================================
🔹 MONSTER CLASS:
    - Extends Unit.
    - Protected int damage, apcost.
    - equip(): displays "Monsters are proud and fight with their own bodies."
    - attack(): must move if not in melee range, check AP, display attack logs.

🔹 SPACEMARINE CLASS:
    - Extends Unit.
    - Has a Weapon.
    - equip(): displays "[Name] has been equipped with a [WeaponName]."
    - attack(): checks for weapon presence, range, and AP.
    - recoverAP(): +9 instead of +7.

===============================================================================
🧩 EXERCISE 06 — ./TacticalMarine.java & ./AssaultTerminator.java
===============================================================================
TacticalMarine:
    - name required at creation.
    - hp = 100, ap = 20.
    - displays "[Name] on duty."
    - equipped with PlasmaRifle.
    - recoverAP(): +12.

AssaultTerminator:
    - name required.
    - hp = 150, ap = 30.
    - displays "[Name] has teleported from space."
    - equipped with PowerFist.
    - receiveDamage(): reduces damage by 3 (min 1).

===============================================================================
🧩 EXERCISE 07 — ./RadScorpion.java & ./SuperMutant.java
===============================================================================
RadScorpion:
    - name = "RadScorpion #[id]"
    - hp = 80, ap = 50
    - damage = 25, apcost = 8
    - displays "[Name]: Crrr!"
    - double damage against non-AssaultTerminator marines.

SuperMutant:
    - name = "SuperMutant #[id]"
    - hp = 170, ap = 20
    - damage = 60, apcost = 20
    - displays "[Name]: Roaarrr!"
    - recoverAP(): +10 AP and +10 HP (up to max HP).

===============================================================================
🧩 EXERCISE 08 — ./SpaceArena.java
===============================================================================
Create `SpaceArena` to simulate fights between teams of monsters and space marines.

Methods:
    - enlistMonsters(List<Monster>)
    - enlistSpaceMarines(List<SpaceMarine>)
    - fight(): executes turn-based combat rounds.

Rules:
    - Prevent duplicate enlistment.
    - Marines fight first.
    - Display entry messages and fight logs.
    - When one team is wiped out:
          Display "The [team] are victorious."

===============================================================================
*/


import java.util.*;

public class main {
    public static void main(String[] args) {
        SpaceArena arena = new SpaceArena();
        arena.enlistMonsters(Arrays.asList(new RadScorpion(), new SuperMutant(), new RadScorpion()));
        arena.enlistSpaceMarines(Arrays.asList(new TacticalMarine("Joe"), new AssaultTerminator("Abaddon"), new TacticalMarine("Rose")));
        arena.fight();
        System.out.println("--- Next Fight ---");
        arena.enlistMonsters(Arrays.asList(new SuperMutant(), new SuperMutant()));
        arena.fight();
    }
}
