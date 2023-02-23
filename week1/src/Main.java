import Terran.*;
import Protos.*;
import Unit.*;
import Zerg.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();


        System.out.println("원하는 종족을 선택하세요(Terran : 0, Protos : 1, Zerg : 2 : ");
        int n = sc.nextInt();
        int m = random.nextInt(3);

        int a, b;
        String aa, bb;
        if (m == 0) {
            a = 5;
            aa = "Terran";
        } else if (m == 1) {
            a = 4;
            aa = "Protos";
        } else {
            a = 8;
            aa = "Zerg";
        }

        if (n == 0) {
            b = 5;
            bb = "Terran";
        } else if (n == 1) {
            b = 4;
            bb = "Protos";
        } else {
            b = 8;
            bb = "Zerg";
        }
        Unit aaa = makeTerran(2);

        System.out.println(aaa);

        Unit[] com = new Unit[a];
        for (int i = 0; i < a; i++) {
            switch (a){
                case 5:
                    com[i] = makeTerran(random.nextInt(5));
                    break;
                case 4:
                    com[i] = makeProtos(random.nextInt(5));
                    break;
                case 8:
                    com[i] = makeZerg(random.nextInt(5));
                    break;
            }
        }

        Unit[] user = new Unit[b];
        for (int i = 0; i < b; i++) {
            switch (b){
                case 5:
                    user[i] = makeTerran(random.nextInt(5));
                    break;
                case 4:
                    user[i] = makeProtos(random.nextInt(5));
                    break;
                case 8:
                    user[i] = makeZerg(random.nextInt(5));
                    break;
            }
        }


        while (true) {
            int userCheck = 0;
            int comCheck = 0;

            System.out.println("아군 : " + bb);
            for (int i = 0; i < user.length; i++) {
                if (user[i] != null){
                    if (user[i].def <= 0) {
                        user[i] = null;
                        userCheck += 1;
                        continue;
                    }
                    System.out.println(i + ". "+ user[i] + "(현재 방어력 : " + user[i].def + ")");
                }
                else{
                    userCheck += 1;
                }
            }
            System.out.println("적군 : " + aa);
            for (int i = 0; i < com.length; i++) {
                if (com[i] != null){
                    if (com[i].def <= 0) {
                        com[i] = null;
                        comCheck += 1;
                        continue;
                    }
                    System.out.println(i + ". "+ com[i] + "(현재 방어력 : " + com[i].def + ")");
                }
                else {
                    comCheck += 1;
                }
            }

            if (userCheck == user.length) {
                System.out.println("패배했습니다.");
                break;
            }
            else if (comCheck == com.length) {
                System.out.println("승리했습니다!!");
                break;
            }


            System.out.println("공격을 실행할 유닛과 공격받을 적군 유닛을 선택하세요 : ");
            int attack = sc.nextInt();
            int defence = sc.nextInt();

            if (com[defence] == null || user[attack] == null) {
                System.out.println("유효한 번호를 입력하세요.");
                continue;
            }

            com[defence].def -= user[attack].atk;

            while (true) {
                int v, e;
                v = random.nextInt(user.length);
                e = random.nextInt(com.length);

                if (user[v] != null && com[e] != null){
                    user[v].def -= com[e].atk;
                    break;
                }
            }
        }
    }

    public static Unit makeTerran(int k) {

        switch (k) {
            case 0:
                return new Marine();
            case 1:
                return new Tank();
            case 2:
                return new Goliath();
            case 3:
                return new Wraith();
            case 4:
                return new Valkyrie();
            default:
                return null;
        }

    }

    public static Unit makeProtos(int k) {
        switch (k) {
            case 0:
                return new Zealot();
            case 1:
                return new Dragoon();
            case 2:
                return new HighTempler();
            case 3:
                return new Scout();
            case 4:
                return new Corsair();
            default:
                return null;
        }
    }

    public static Unit makeZerg(int k) {
        switch (k) {
            case 0:
                return new Zergling();
            case 1:
                return new Hydralisk();
            case 2:
                return new Ultralisk();
            case 3:
                return new Mutalisk();
            case 4:
                return new Guardian();
            default:
                return null;
        }
    }

    public static void able(Unit[] a, Unit[] b) {
        
    }

}