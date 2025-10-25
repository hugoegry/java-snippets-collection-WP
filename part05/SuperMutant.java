import java.util.concurrent.atomic.AtomicInteger;

public class SuperMutant extends Monster {
    private static AtomicInteger count = new AtomicInteger(0);

    public SuperMutant() {
        super("SuperMutant #" + count.incrementAndGet(), 170, 20);
        System.out.println(getName() + ": Roaarrr!");
        this.damage = 60;
        this.apcost = 20;
    }

    @Override
    public void recoverAP() {
        super.recoverAP();
        if (hp < 170) hp = Math.min(170, hp + 10);
    }
}
