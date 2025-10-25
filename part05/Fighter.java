public interface Fighter {
    boolean equip(Weapon weapon);
    boolean attack(Fighter target);
    void receiveDamage(int damage);
    boolean moveCloseTo(Fighter target);
    void recoverAP();
    String getName();
    int getAp();
    int getHp();
}