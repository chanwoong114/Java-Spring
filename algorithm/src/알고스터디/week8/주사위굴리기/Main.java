package 알고스터디.week8.주사위굴리기;

import java.util.Scanner;

public class Main {

    static int n, m, r, c;
    static int arr[][];
    static int dice[] = {0, 0, 0, 0, 0, 0};
    static int sub[] = {0, 0, 0, 0, 0, 0};
    static int d[][] = {{0, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        int k = sc.nextInt();
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < k; i++) {
            int tmp = sc.nextInt();
            if (roll(tmp)) {
                if (arr[r][c] == 0) {
                    arr[r][c] = dice[5];
                } else {
                    dice[5] = arr[r][c];
                    arr[r][c] = 0;
                }
                System.out.println(dice[0]);
            }

        }
    }

    public static boolean roll(int order) {
        if (order == 1) {
            if ((0 <= r + d[order][0] && r + d[order][0] < n) && (0 <= c + d[order][1] && c + d[order][1] < m)) {
                System.arraycopy(dice, 0, sub, 0, 6);
                dice[0] = sub[3];
                dice[1] = sub[1];
                dice[2] = sub[0];
                dice[3] = sub[5];
                dice[4] = sub[4];
                dice[5] = sub[2];
                r += d[order][0];
                c += d[order][1];
                return true;
            } else {
                return false;
            }
        }
        else if (order == 2) {
            if ((0 <= r + d[order][0] && r + d[order][0] < n) && (0 <= c + d[order][1] && c + d[order][1] < m)) {
                System.arraycopy(dice, 0, sub, 0, 6);
                dice[0] = sub[2];
                dice[1] = sub[1];
                dice[2] = sub[5];
                dice[3] = sub[0];
                dice[4] = sub[4];
                dice[5] = sub[3];
                r += d[order][0];
                c += d[order][1];
                return true;
            } else {
                return false;
            }
        }
        else if (order == 3) {
            if ((0 <= r + d[order][0] && r + d[order][0] < n) && (0 <= c + d[order][1] && c + d[order][1] < m)) {
                System.arraycopy(dice, 0, sub, 0, 6);
                dice[0] = sub[4];
                dice[1] = sub[0];
                dice[2] = sub[2];
                dice[3] = sub[3];
                dice[4] = sub[5];
                dice[5] = sub[1];
                r += d[order][0];
                c += d[order][1];
                return true;
            } else {
                return false;
            }
        }
        else {
            if ((0 <= r + d[order][0] && r + d[order][0] < n) && (0 <= c + d[order][1] && c + d[order][1] < m)) {
                System.arraycopy(dice, 0, sub, 0, 6);
                dice[0] = sub[1];
                dice[1] = sub[5];
                dice[2] = sub[2];
                dice[3] = sub[3];
                dice[4] = sub[0];
                dice[5] = sub[4];
                r += d[order][0];
                c += d[order][1];
                return true;
            } else {
                return false;
            }
        }
    }
}
