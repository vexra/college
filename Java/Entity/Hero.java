package Entity;

public class Hero extends Entity{
    int damage;
    int armor;
    String emblem;

    public Hero(String name, int HP, int damage, int armor, String emblem) {
        this.name = name;
        this.HP = HP;
        this.damage = damage;
        this.armor = armor;
        this.emblem = emblem;
    }

    @Override 
    public int basicAttack() {
        return this.damage;
    }

    @Override
    public void gainHP(int gain) {
        this.HP += gain;
    }

    @Override
    public void reduceHP(int reduce) {
        int diff = this.armor - reduce;
        
        if (diff < 0) this.HP += diff;
    }

    public int skillOne() {
        return this.damage * 2;
    }

    public int skillTwo() {
        return this.damage * 2 + 100;
    }

    public int skillThree() {
        return this.damage * 3;
    }

    public String getEmblem() {
        return this.emblem;
    }

    public void setEmblem(String emblem) {
        this.emblem = emblem;
    }

    public void print() {
        System.out.println("Name" + this.name);
        System.out.println("HP" + this.HP);
        System.out.println("Armor" + this.armor);
        System.out.println("Damage" + this.damage);
        System.out.println("Emblem" + this.emblem);
    }
}
