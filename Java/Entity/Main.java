package Entity;

// main program
public class Main {
    public static void main(String args[]) {
        Hero layla = new Hero("Layla", 1000, 75, 50, "Inspire");
        Hero miya = new Hero("Miya", 1100, 75, 50, "Flicker");
        Minion creep = new Minion("Creep", 1500, 25);
        Lord Lord = new Lord("Lord", 5000, 500, 100);


        // output HP awal
        miya.print();
        layla.print();

        // miya diserang layla
        miya.reduceHP(layla.basicAttack());

        // layla diserang miya menggunakan skill 3
        layla.reduceHP(miya.skillThree());


        // output hp setela di serang
        miya.print();
        layla.print();
    }
}
