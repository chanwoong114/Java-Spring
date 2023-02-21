import Terran.*;
import Protos.*;
import Unit.Unit;
import Zerg.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        Marine marine = new Marine();
        Ultralisk ultralisk = new Ultralisk();

        while (marine.def > 0 && ultralisk.def > 0) {
            ultralisk.def -= marine.atk;
            System.out.println(ultralisk.def);
            marine.def -= ultralisk.atk;
            System.out.println(marine.def);
            break;
        }


    }
}