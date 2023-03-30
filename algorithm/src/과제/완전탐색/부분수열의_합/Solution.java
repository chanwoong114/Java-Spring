package 과제.완전탐색.부분수열의_합;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static int n, m, cnt;
    static int arr[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc < T+1; tc++) {
            n = sc.nextInt();
            m = sc.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            cnt = 0;
            combi(0, 0);
            System.out.println("#" + tc + " " + cnt);
        }
    }

    static void combi(int idx, int total) {
        if (total > m) {
            return;
        }
        if (total == m) {
            cnt += 1;
            return;
        }
        for (int i = idx; i < n; i++) {
            combi(i+1, total + arr[i]);
        }
    }
}
