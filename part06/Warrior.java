public class Warrior extends Character {

    public Warrior(String name) {
        super(name, "Warrior");
        this.strength = 10;
        this.agility = 8;
        this.life = 100;
        this.wit = 3;
        System.out.println(this.name + ": My name will go down in history!");
    }

    @Override
    public void attack(String weapon) {
        if (weapon == null || (!weapon.equalsIgnoreCase("hammer") && !weapon.equalsIgnoreCase("sword"))) {
            //System.out.println(this.name + ": I don’t need this stupid weapon!");
            return;
        }

        System.out.println(this.name + ": Rrrrrrrrr....");
        System.out.println(this.name + ": I'll crush you with my " + weapon + "!");
    }

    @Override
    public void moveRight() {
        System.out.println(this.name + ": moves right like a bad boy.");
    }

    @Override
    public void moveLeft() {
        System.out.println(this.name + ": moves left like a bad boy.");
    }

    @Override
    public void moveForward() {
        System.out.println(this.name + ": moves forward like a bad boy.");
    }

    @Override
    public void moveBack() {
        System.out.println(this.name + ": moves back like a bad boy.");
    }

}
