package Entity;

public class Lord extends Entity {
    int damage;

    public Lord(String name, int HP, int damage, int armor) {
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
