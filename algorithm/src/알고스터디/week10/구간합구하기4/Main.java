package 알고스터디.week10.구간합구하기4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] sumArr = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            sumArr[i] = sumArr[i-1] + arr[i-1];
        }

        for (int i = 0; i < m; i++) {
            int k = sc.nextInt();
            int l = sc.nextInt();
            sb.append(String.format("%d\n", sumArr[l] - sumArr[k-1]));
        }
        System.out.println(sb);
    }
}

