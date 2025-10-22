import java.util.ArrayList;
import java.util.List;

public class Team {
    private final String name;
    private List<Astronaut> members;

    public Team(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void add(Astronaut astro) {
        if (!members.contains(astro)) members.add(astro);
    }

    public void remove(Astronaut astro) {
        if (members.contains(astro)) members.remove(astro);
    }

    public int countMembers() {
        return members.size();
    }

    public void showMembers() {
        if (members.isEmpty()) return;

        StringBuilder sb = new StringBuilder();
        sb.append(name).append(": ");
        for (int i = 0; i < members.size(); i++) {
            Astronaut astro = members.get(i);
            sb.append(astro.getName());
            if (astro.getDestination() != null) sb.append(" on mission");
            else sb.append(" on standby");

            if (i != members.size() - 1) sb.append(", ");
        }
        sb.append(".");
        System.out.println(sb.toString());
    }

    public void doActions() {
        System.out.println(this.name + ": Nothing to do.");
    }

    public void doActions(Object obj) {
        if (this.members.isEmpty()) {
            System.out.println(this.name + ": Nothing to do.");
            return;
        }
        for (Astronaut astro : this.members) {
            astro.doActions(obj);
        }
    }
}
