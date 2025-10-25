import java.util.concurrent.atomic.AtomicInteger;

public class RadScorpion extends Monster {
    private static AtomicInteger count = new AtomicInteger(0);

    public RadScorpion() {
        super("RadScorpion #" + count.incrementAndGet(), 80, 50);
        System.out.println(getName() + ": Crrr!");
        this.damage = 25;
        this.apcost = 8;
    }

    @Override
    public boolean attack(Fighter target) {
        boolean success = super.attack(target);
        if (success && target instanceof SpaceMarine && !(target instanceof AssaultTerminator)) {
            target.receiveDamage(damage); // double damage vs non-terminators
        }
        return success;
    }
}
