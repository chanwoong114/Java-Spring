package 알고스터디.week8.C_N과M4;

import java.util.Scanner;

public class Main {
    static int n, m;
    static int arr[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];

        per(0);
        System.out.print(sb);

    }

    public static void per(int k){
        if (k == m) {
            for (int i=0; i<m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i < n+1; i++) {
            if (k > 0) {
                if (arr[k-1] <= i) {
                    arr[k] = i;
                } else {
                    continue;
                }
            } else {
                arr[k] = i;
            }
            per(k+1);
        }
    }
}
