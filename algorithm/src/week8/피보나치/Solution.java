package week8.피보나치;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = fib(N);

        System.out.println(M);

    }

    public static Integer fib(int num) {
        if (num == 1) {
            return 1;
        }
        if (num == 0) {
            return 0;
        }
        return fib(num - 1) + fib(num - 2);
    }
}