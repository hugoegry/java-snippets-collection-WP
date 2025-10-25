public abstract class SpaceMarine extends Unit {
    protected Weapon weapon = null;

    protected SpaceMarine(String name, int hp, int ap) {
        super(name, hp, ap);
    }

    public Weapon getWeapon() { 
        return weapon;
    }

    @Override
    public boolean equip(Weapon weapon) {
         if (weapon == null || weapon.isEquipped()) return false;
        this.weapon = weapon;
        weapon.setEquipped(true);
        System.out.println(name + " has been equipped with a " + weapon.getName() + ".");
        return true;
    }

    @Override
    public boolean attack(Fighter target) {
        if (dead) return false;

        if (weapon == null) {
            System.out.println(name + ": Hey, this is crazy. I'm not going to fight this empty-handed.");
            return false;
        }

        if (weapon.isMelee() && closeTarget != target) {
            System.out.println(name + ": I'm too far away from " + target.getName() + ".");
            return false;
        }

        if (ap < weapon.getApcost()) return false;

        System.out.println(name + " attacks " + target.getName() + " with a " + weapon.getName() + ".");
        weapon.attack();
        ap -= weapon.getApcost();
        target.receiveDamage(weapon.getDamage());
        return true;
    }

    @Override
    public void receiveDamage(int damage) {
        if (dead) return;
        hp -= damage;
        if (hp <= 0) {
            hp = 0;
            dead = true;
            //if (weapon != null) weapon.setEquipped(false);
        }
    }

    @Override
    public void recoverAP() {
        ap += 9;
        if (ap > 50) ap = 50;
    }
}
