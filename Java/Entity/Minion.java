package Entity;

public class Minion extends Entity {
    int damage;

    public Minion(String name, int HP, int damage) {
        this.name = name;
        this.HP = HP;
        this.damage = damage;
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
        this.HP -= reduce;
    }

    public void print() {
        System.out.println("Name" + this.name);
        System.out.println("HP" + this.HP);
        System.out.println("Damage" + this.damage);
    }
}
