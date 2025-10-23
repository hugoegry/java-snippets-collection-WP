public class BlueShark extends Shark {

    public BlueShark(String name) {
        super(name);
    }

    @Override
    public boolean canEat(Animal other) {
        if (other == this) return false;
        return other instanceof Shark || other.getType().equals("fish");
    }
}
