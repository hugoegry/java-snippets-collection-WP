import java.util.*;

public class SpaceArena {
    private List<Monster> monsters = new ArrayList<>();
    private List<SpaceMarine> marines = new ArrayList<>();
    private List<Unit> alreadyEntered = new ArrayList<>(); // sav qui est entré dans l arene \\
    public void enlistMonsters(List<Monster> newMonsters) {
        for (Monster m : newMonsters) if (!monsters.contains(m)) monsters.add(m);
    }

    public void enlistSpaceMarines(List<SpaceMarine> newMarines) {
        for (SpaceMarine sm : newMarines) if (!marines.contains(sm)) marines.add(sm);
    }

    public boolean fight() {
        if (monsters.isEmpty()) {
            System.out.println("No monsters available to fight.");
            return false;
        }
        if (marines.isEmpty()) {
            System.out.println("Those cowards ran away.");
            return false;
        }

        int monsterIndex = 0;
        int marineIndex = 0;
        boolean hasFought = false;

        // Cherche les premiers vivants dans chaque camp
        while (marineIndex < marines.size() && marines.get(marineIndex).getHp() <= 0) marineIndex++;
        while (monsterIndex < monsters.size() && monsters.get(monsterIndex).getHp() <= 0) monsterIndex++;
        if (marineIndex >= marines.size() || monsterIndex >= monsters.size()) return false;

        SpaceMarine marine = marines.get(marineIndex);
        Monster monster = monsters.get(monsterIndex);

        if (!alreadyEntered.contains(marine)) {
            System.out.println(marine.getName() + " has entered the arena.");
            alreadyEntered.add(marine);
        }
        if (!alreadyEntered.contains(monster)) {
            System.out.println(monster.getName() + " has entered the arena.");
            alreadyEntered.add(monster);
        }
        hasFought = true;

        while (marineIndex < marines.size() && monsterIndex < monsters.size()) {

            while (marine.getHp() > 0 && monster.getHp() > 0) {
                if (!marine.attack(monster)) {
                    if (!marine.moveCloseTo(monster)) marine.recoverAP();
                }

                if (monster.getHp() <= 0) break;

                if (!monster.attack(marine)) {
                    if (!monster.moveCloseTo(marine)) monster.recoverAP();
                }
            }

            if (marine.getHp() > 0) {
                marine.recoverAP();
                monsterIndex++;
                if (monsterIndex >= monsters.size()) break;
                monster = monsters.get(monsterIndex);
                alreadyEntered.add(monster);
                System.out.println(monster.getName() + " has entered the arena.");
            } else {
                monster.recoverAP();
                marineIndex++;
                if (marineIndex >= marines.size()) break;
                marine = marines.get(marineIndex);
                alreadyEntered.add(marine);
                System.out.println(marine.getName() + " has entered the arena.");
            }
        }

        if (marineIndex >= marines.size()) System.out.println("The monsters are victorious.");
        else System.out.println("The spaceMarines are victorious.");

        return hasFought;
    }

}