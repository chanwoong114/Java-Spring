package 알고스터디.week10.하노이;

import java.util.Scanner;

public class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println((int) Math.pow(2, n) - 1);
        hanoi(1, 3, n);
        System.out.println(sb);
    }
    static void hanoi(int start, int end, int depth) {
        if (depth == 1) {
            sb.append(String.format("%d %d\n", start, end));
            return;
        }

        hanoi(start, 6-start-end, depth-1);
        sb.append(String.format("%d %d\n", start, end));
        hanoi(6-start-end, end, depth-1);
    }
}
