public class Canary extends Animal {
    private int eggs = 0;

    public Canary(String name) {
        super(name, 2, Type.BIRD);
        System.out.println("Yellow and smart? Here I am!");
    }

    public int getEggsCount() {
        return this.eggs;
    }

    public void layEgg() {
        this.eggs++;
    }
}
