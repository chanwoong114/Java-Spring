package 재귀.별찍기;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static char[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr = new char[n][n];

        for (int i=0; i<n; i++) {
            Arrays.fill(arr[i], ' ');
        }
        star(n, 0, 0);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void star(int n, int x, int y) {
        if (n == 1) {
            arr[x][y] = '*';
            return;
        }
        int v = n/3;

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                else {
                    star(v, x + (v * i), y + (v * j));
                }
            }
        }

    }
}
