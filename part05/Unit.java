public abstract class Unit implements Fighter {
    protected String name;
    protected int hp;
    protected int ap;
    protected Fighter closeTarget;
    protected boolean dead = false;

    protected Unit(String name, int hp, int ap) {
        this.name = name;
        this.hp = hp;
        this.ap = ap;
        this.closeTarget = null;
    }

    public String getName() { 
        return name; 
    }

    public int getHp() { 
        return hp; 
    }

    public int getAp() { 
        return ap;
    }

    public Fighter getCloseTarget() { 
        return closeTarget; 
    }

    // public void resetCloseTarget() {
    //     closeTarget = null;
    // }

    @Override
    public void receiveDamage(int damage) {
        if (dead) return;
        hp -= damage;
        if (hp <= 0) {
            hp = 0;
            dead = true;
        }
    }

    @Override
    public boolean moveCloseTo(Fighter target) {
        if (dead || target == null || target == this) return false;
        if (closeTarget == target) return false;
        closeTarget = target;
        System.out.println(name + " is moving closer to " + target.getName() + ".");
        return true;
    }

    @Override
    public void recoverAP() {
        ap += 7;
        if (ap > 50) ap = 50;
    }
}
