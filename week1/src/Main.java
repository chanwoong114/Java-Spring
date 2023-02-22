import Terran.*;
import Protos.*;
import Unit.*;
import Zerg.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Marine marine = new Marine();
        Tank tank = new Tank();
        Goliath goliath = new Goliath();
        Wraith wraith = new Wraith();
        Valkyrie valkyrie = new Valkyrie();
        Zealot zealot = new Zealot();
        Dragoon dragoon = new Dragoon();
        HighTempler highTempler = new HighTempler();
        Scout scout = new Scout();
        Corsair corsair = new Corsair();
        Zergling zergling = new Zergling();
        Hydralisk hydralisk = new Hydralisk();
        Ultralisk ultralisk = new Ultralisk();
        Mutalisk mutalisk = new Mutalisk();
        Guardian guardian = new Guardian();

// 셔플, 제네릭 <>
        List<Unit> terran = Arrays.asList(marine, tank, goliath, wraith, valkyrie);
        List<Unit> protos = Arrays.asList(zealot, dragoon, highTempler, scout, corsair);
        List<Unit> zerg = Arrays.asList(zergling, hydralisk, ultralisk, mutalisk, guardian);

        List<List<Unit>> unit = Arrays.asList(terran, protos, zerg);

        Random random = new Random();

        List<Unit> computerTribe = unit.get(random.nextInt(3));

        System.out.printf("원하는 종족을 선택하세요(Terran : 0, Protos : 1, Zerg : 2 : ");
        int n = sc.nextInt();

        List<Unit> userTribe = unit.get(n);

        List<Unit> computer = new ArrayList<>();


        int a;
        if (unit.indexOf(computerTribe) == 0) {
            a = 5;
        } else if (unit.indexOf(computerTribe) == 1) {
            a = 4;
        } else {
            a = 8;
        }

        Unit[] com = new Unit[a];
        for (int i=0; i<a; i++) {
            com[i] = computerTribe.get(random.nextInt(computerTribe.size()));
        }




        System.out.println(Arrays.toString(com));
    }
}