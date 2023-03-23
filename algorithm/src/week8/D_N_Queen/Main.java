package week8.D_N_Queen;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {
    static int n;
    static int cnt = 0;
    static int arr[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        Arrays.fill(arr, 0);

        n_queen(0);
        System.out.println(cnt);
    }

    public static boolean location(int d) {
        for (int i = 0; i < d; i++) {
            if (arr[d] == arr[i] || abs(arr[d] - arr[i]) == abs(d - i)){
                return false;
            }
        }
        return true;
    }

    public static void n_queen(int k){
        if (k == n) {
            cnt += 1;
        } else {
            for (int i = 0; i < n; i++) {
                arr[k] = i;
                if (location(k)) {
                    n_queen(k+1);
                }
            }
        }
    }

}

