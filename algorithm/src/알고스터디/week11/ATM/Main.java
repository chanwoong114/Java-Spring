package 알고스터디.week11.ATM;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 1; i < N; i++) {
            arr[i] += arr[i-1];
        }

        int a = Arrays.stream(arr).sum();

        System.out.println(a);
    }
}
