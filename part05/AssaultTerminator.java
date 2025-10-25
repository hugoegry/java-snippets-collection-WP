public class AssaultTerminator extends SpaceMarine {
    public AssaultTerminator(String name) {
        super(name, 150, 30);
        System.out.println(name + " has teleported from space.");
        equip(new PowerFist());
    }

    @Override
    public void receiveDamage(int damage) {
        if (dead) return;
        damage = Math.max(1, damage - 3);
        hp -= damage;
        if (hp <= 0) {
            hp = 0;
            dead = true;
        }
    }
}
