public abstract class Monster extends Unit {
    protected int damage = 0;
    protected int apcost = 0;

    protected Monster(String name, int hp, int ap) {
        super(name, hp, ap);
    }

    public int getDamage() { 
        return damage; 
    }
    public int getApcost() { 
        return apcost; 
    }

    @Override
    public boolean equip(Weapon weapon) {
        System.out.println("Monsters are proud and fight with their own bodies.");
        return false;
    }

    @Override
    public boolean attack(Fighter target) {
        if (dead) return false;
        if (target == null || target.getHp() <= 0) return false;

        if (closeTarget != target) {
            System.out.println(name + ": I'm too far away from " + target.getName() + ".");
            return false;
        }

        if (ap < apcost) return false;

        System.out.println(name + " attacks " + target.getName() + ".");
        ap -= apcost;
        target.receiveDamage(damage);
        return true;
    }
}
