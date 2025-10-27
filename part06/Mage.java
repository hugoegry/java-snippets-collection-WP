public class Mage extends Character {

    public Mage(String name) {
        super(name, "Mage");
        this.life = 70;
        this.strength = 3;
        this.agility = 10;
        this.wit = 10;
        System.out.println(this.name + ": May the gods be with me.");
    }

    @Override
    public void attack(String weapon) {
        if (weapon == null || (!weapon.equalsIgnoreCase("magic") && !weapon.equalsIgnoreCase("wand"))) {
            System.out.println(this.name + ": I don’t need this stupid weapon!");
            return;
        }

        System.out.println(this.name + ": Rrrrrrrrr....");
        System.out.println(this.name + ": Feel the power of my " + weapon + "!");
    }

    @Override
    public void moveRight() {
        System.out.println(this.name + ": moves right furtively.");
    }

    @Override
    public void moveLeft() {
        System.out.println(this.name + ": moves left furtively.");
    }

    @Override
    public void moveForward() {
        System.out.println(this.name + ": moves forward furtively.");
    }

    @Override
    public void moveBack() {
        System.out.println(this.name + ": moves back furtively.");
    }
}
