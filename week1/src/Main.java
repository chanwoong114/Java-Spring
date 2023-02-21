import Terran.Marine;
import Terran.Tank;

public class Main {
    public static void main(String[] args) {

        Terran.Marine marine = new Marine();
        Terran.Tank tank = new Tank();

        marine.attack();
        marine.status();
        tank.status();



    }
}