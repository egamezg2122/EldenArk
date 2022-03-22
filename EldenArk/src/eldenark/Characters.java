package eldenark;

public class Characters {
        
    // Main atributes
    
    private int level;
    
    private int xp; // Experience Points
    
    private int damage;
    
    private int defense;
    
    private int hp; // Health Points
    
    private int maxHP;
    
    private int mp; // Mana Points
    
    private int maxMP;
        
    private int specialDamage;
        
    
    // Constructors
    
    public Characters (int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage) {
        
        this.level = 1; // Always start at level 1

        this.xp = 0; // Experience always start at 0

        this.damage = damage;

        this.defense = defense;

        this.hp = hp;

        this.maxHP = maxHP;

        this.mp = mp;

        this.maxMP = maxMP;

        this.specialDamage = specialDamage;

    }
    
    
    // Getters

    public int getLevel() {
        
        return level;
        
    }

    public int getXp() {
        
        return xp;
        
    }

    public int getDamage() {
        
        return damage;
        
    }

    public int getDefense() {
        
        return defense;
        
    }

    public int getHp() {
        
        return hp;
        
    }

    public int getMaxHP() {
        
        return maxHP;
        
    }

    public int getMp() {
        
        return mp;
        
    }

    public int getMaxMP() {
        
        return maxMP;
        
    }

    public int getSpecialDamage() {
        
        return specialDamage;
        
    }
    
    
    
    // Setters

    public void setLevel(int level) {
        
        this.level = level;
        
    }

    public void setXp(int xp) {
        
        this.xp = xp;
        
    }

    public void setDamage(int damage) {
        
        this.damage = damage;
        
    }

    public void setDefense(int defense) {
        
        this.defense = defense;
        
    }

    public void setHp(int hp) {
        
        this.hp = hp;
        
    }

    public void setMaxHP(int maxHP) {
        
        this.maxHP = maxHP;
        
    }

    public void setMp(int mp) {
        
        this.mp = mp;
        
    }

    public void setMaxMP(int maxMP) {
        
        this.maxMP = maxMP;
        
    }

    public void setSpecialDamage(int specialDamage) {
        
        this.specialDamage = specialDamage;
        
    }
   
}
