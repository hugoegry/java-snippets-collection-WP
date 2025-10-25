public abstract class Weapon {
    protected String name;
    protected int apcost;
    protected int damage;
    protected boolean melee;
    private boolean equipped = false;

    protected Weapon(String name, int apcost, int damage, boolean melee) {
        this.name = name;
        this.apcost = apcost;
        this.damage = damage;
        this.melee = melee;
    }

    public String getName() { 
        return name; 
    }

    public int getApcost() { 
        return apcost; 
    }

    public int getDamage() { 
        return damage; 
    }
    
    public boolean isMelee() { 
        return melee; 
    }

    public boolean isEquipped() { 
        return equipped; 
    }
    public void setEquipped(boolean state) { 
        this.equipped = state; 
    }

    public abstract void attack();
}