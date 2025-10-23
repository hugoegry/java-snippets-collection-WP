public class GreatWhite extends Shark {

    public GreatWhite(String name) {
        super(name);
    }

    @Override
    public boolean canEat(Animal other) {
        if (other == this) return false;
        if (other instanceof Canary) {
            System.out.println(getName() + ": Next time you try to give me that to eat, I'll eat you instead.");
            return false;
        }
        return true;
    }

    @Override
    public void eat(Animal other) {
        if (canEat(other)) {
            System.out.println(getName() + " ate a " + other.getType() + " named " + other.getName() + ".");
            if (other instanceof Shark) System.out.println(getName() + ": The best meal one could wish for.");
            this.smellBlood(false);
        } else System.out.println(getName() + ": It's not worth my time.");
    }
}
