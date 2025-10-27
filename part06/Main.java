/*
===============================================================================
PART 06 : EVERYTHING TOGETHER
===============================================================================

GLOBAL INSTRUCTIONS

This project implements a mini RPG character hierarchy using object-oriented
principles in Java. It includes abstraction, inheritance, encapsulation,
interfaces, method overriding, exception handling, and polymorphism.

STRUCTURE:
  - Character.java     → Abstract base class defining shared attributes and behavior.
  - Warrior.java       → Concrete subclass representing a strong melee fighter.
  - Mage.java          → Concrete subclass representing a powerful spellcaster.
  - Movable.java       → Interface defining movement actions.
  - WeaponException.java → Custom checked exception for invalid weapon use.

FEATURES:
    Character class:
       - Protected attributes: name, life, agility, strength, wit, RPGClass
       - Default values defined in the constructor
       - Attack method printing a generic attack message
       - Final unsheathe() method common to all characters

    Warrior & Mage classes:
       - Specialized stats for each RPG class
       - Overridden attack() method with weapon restrictions
       - Specific creation message
       - Custom movement messages (implements Movable)

    Movable interface:
       - Methods: moveRight, moveLeft, moveForward, moveBack
       - Implemented differently by each subclass

    WeaponException:
       - Custom exception for invalid attacks or empty weapons
       - Distinct messages per class and error type
       - tryToAttack() safely wraps attack() in a try/catch block

    Main (Example.java):
       - Global test suite demonstrating all functionalities:
           → Creation of characters
           → Attribute display
           → Movement tests
           → Attack logic with valid & invalid weapons
           → Exception handling with tryToAttack and direct catch

===============================================================================
*/

class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Jean-Luc");
        Character mage = new Mage("Robert");

        System.out.println();
        System.out.println("--- CHARACTER STATS ---");
        System.out.println(warrior.getName() + " [" + warrior.getRPGClass() + "]");
        System.out.println("Life: " + warrior.getLife());
        System.out.println("Strength: " + warrior.getStrength());
        System.out.println("Agility: " + warrior.getAgility());
        System.out.println("Wit: " + warrior.getWit());
        System.out.println();

        System.out.println(mage.getName() + " [" + mage.getRPGClass() + "]");
        System.out.println("Life: " + mage.getLife());
        System.out.println("Strength: " + mage.getStrength());
        System.out.println("Agility: " + mage.getAgility());
        System.out.println("Wit: " + mage.getWit());
        System.out.println();

        System.out.println("--- MOVEMENT TESTS ---");
        ((Warrior) warrior).moveRight();
        ((Warrior) warrior).moveLeft();
        ((Warrior) warrior).moveBack();
        ((Warrior) warrior).moveForward();
        System.out.println();
        ((Mage) mage).moveRight();
        ((Mage) mage).moveLeft();
        ((Mage) mage).moveBack();
        ((Mage) mage).moveForward();
        System.out.println();

        System.out.println("--- ATTACK TESTS ---");
        warrior.tryToAttack("screwdriver");
        mage.tryToAttack("hammer");
        System.out.println();
        warrior.tryToAttack("hammer");
        mage.tryToAttack("magic");
        System.out.println();

        try {
            mage.attack("");
        } catch (WeaponException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        warrior.unsheathe();
        mage.unsheathe();
    }
}
