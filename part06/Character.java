public abstract class Character implements Movable {
    protected String name;
    protected int life = 50;
    protected int agility = 2;
    protected int strength = 2;
    protected int wit = 2;
    protected String RPGClass;

    public Character(String name,  String RPGClass) {
        this.name = name;
        this.RPGClass = RPGClass;
    }

    public int getAgility() {
        return this.agility;
    }
    public int getStrength() {
        return this.strength;
    }
    public int getWit() {
        return this.wit;
    }
    public String getName() {
        return this.name;
    }
    public int getLife() {
        return this.life;
    }
    public String getRPGClass() {
        return this.RPGClass;
    }

    public final void unsheathe() {
        System.out.println(this.name + ": unsheathes his weapon.");
    }

    public void attack(String weapon) {
        System.out.println(this.name + ": Rrrrrrrrr....");
    }

    @Override
    public void moveRight() {
        System.out.println(this.name + ": moves right");
    }

    @Override
    public void moveLeft() {
        System.out.println(this.name + ": moves left");
    }

    @Override
    public void moveForward() {
        System.out.println(this.name + ": moves forward");
    }

    @Override
    public void moveBack() {
        System.out.println(this.name + ": moves back");
    }

}