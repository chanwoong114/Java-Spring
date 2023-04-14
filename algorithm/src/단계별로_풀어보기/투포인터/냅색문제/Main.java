package 단계별로_풀어보기.투포인터.냅색문제;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int n, c, index;
    static int[] arr;
    static ArrayList<Integer> aSum, bSum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); 
        c = sc.nextInt();
        arr = new int[n+1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        aSum = new ArrayList<>();
        bSum = new ArrayList<>();

        aBruteForce(0, 0);
        bBruteForce(n/2, 0);
        Collections.sort(bSum);

        int ans = 0;
        for (int i = 0; i < aSum.size(); i++) {
            index -= 1;
            binarySearch(0, bSum.size() - 1, aSum.get(i));
            ans += index + 1;
        }

        System.out.println(ans);
    }

    static void aBruteForce(int start, int sum) {
        if (sum > c) return;
        if (start == n/2) {
            aSum.add(sum);
            return;
        }
        aBruteForce(start + 1, sum + arr[start]);
        aBruteForce(start + 1, sum);
    }

    static void bBruteForce(int start, int sum) {
        if (sum > c) return;
        if (start == n) {
            bSum.add(sum);
            return;
        }
        bBruteForce(start + 1, sum + arr[start]);
        bBruteForce(start + 1, sum);
    }

    static void binarySearch(int start, int end, int val) {
        if (start > end) return;

        int mid = (start + end) / 2;

        if (bSum.get(mid) + val <= c) {
            index = mid;
            binarySearch(mid + 1, end, val);
        } else {
            binarySearch(start, mid - 1, val);
        }
    }
}
