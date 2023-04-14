package 단계별로_풀어보기.투포인터.소수의_연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        Arrays.fill(arr, 1);
        arr[0] = arr[1] = 0;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 2 * i; j < n + 1; j += i) {
                arr[j] = 0;
            }
        }
        ArrayList<Integer> prime = new ArrayList<>();
        for (int i = 2; i < n + 1; i++) {
            if (arr[i] == 1) prime.add(i);
        }

        int cnt = 0;

        for (int left = 0; left < prime.size(); left++) {
            int right = left;
            int sum = prime.get(left);
            if (sum == n) {
                cnt++;
                break;
            }
            right++;
            while (right < prime.size()) {
                sum += prime.get(right);
                if (sum == n) cnt++;
                else if (sum > n) {
                    break;
                }
                right++;
            }
        }

        System.out.println(cnt);
    }
}
