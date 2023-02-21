package Unit;

public class Unit {

    public String name;
    public boolean fly;
    public boolean longdistance;
    public int atk;
    public int def;

    public Unit(String name, boolean fly, boolean longdistance, int atk, int def) {
        this.name = name;
        this.fly = fly;
        this.longdistance = longdistance;
        this.atk = atk;
        this.def = def;
    }

    public void attack() {
        System.out.println("공격합니다.");
    }

    public void status() {
        System.out.println(this.name);
        System.out.println(this.fly);
        System.out.println(this.longdistance);
        System.out.println(this.atk);
        System.out.println(this.def);
    }


}
