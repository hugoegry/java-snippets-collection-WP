public class Warrior extends Character {

    public Warrior(String name) {
        super(name, "Warrior");
        this.life = 100;
        this.strength = 10;
        this.agility = 8;
        this.wit = 3;
        System.out.println(this.name + ": My name will go down in history!");
    }

    @Override
    public void attack(String weapon) throws WeaponException {
        if (weapon == null || weapon.isEmpty()) {
            throw new WeaponException(this.name + ": I refuse to fight with my bare hands.");
        }

        String w = weapon.trim();
        if (!w.equalsIgnoreCase("hammer") && !w.equalsIgnoreCase("sword")) {
            throw new WeaponException(this.name + ": A " + w + "?? What should I do with this?!");
        }

        System.out.println(this.name + ": Rrrrrrrrr....");
        System.out.println(this.name + ": I'll crush you with my " + w + "!");
    }
}
