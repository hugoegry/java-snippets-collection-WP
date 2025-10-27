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
    public void attack(String weapon) throws WeaponException {
        if (weapon == null || weapon.isEmpty()) {
            throw new WeaponException(this.name + ": I refuse to fight with my bare hands.");
        }

        String w = weapon.trim();
        if (!w.equalsIgnoreCase("magic") && !w.equalsIgnoreCase("wand")) {
            throw new WeaponException(this.name + ": I don't need this stupid " + w + "! Don't misjudge my powers!");
        }

        System.out.println(this.name + ": Rrrrrrrrr....");
        System.out.println(this.name + ": Feel the power of my " + w + "!");
    }
}
