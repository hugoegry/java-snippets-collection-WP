public class Cat extends Animal {
    private String color;

    public Cat(String name, String color) {
        super(name, 4, Type.MAMMAL);
        this.color = color;
        System.out.println(name + ": MEEEOOWWWW");
    }

    public String getColor() {
        return this.color;
    }

    public void meow() {
        System.out.println(getName() + " the " + this.color + " kitty is meowing.");
    }
}
