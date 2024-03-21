package Entity;

// abstract class for entity
public abstract class Entity implements ViewData {
    String name;
    int HP;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return this.HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }    

    public abstract int basicAttack();
    public abstract void gainHP(int gain);
    public abstract void reduceHP(int reduce);

}
