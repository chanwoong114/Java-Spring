package 알고스터디.week11.펠린드롬만들기;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pel = sc.next();

        int[] arr = new int[26];

        for (int i = 0; i < pel.length(); i++) {
            arr[pel.charAt(i) - 'A'] += 1;
        }
        char[] ans = new char[pel.length()];
        int flag = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] % 2 == 1) {
                flag += 1;
            }
        }

        if (flag > 1) {
            System.out.println("I'm Sorry Hansoo");
            exit(0);
        }

        int left = 0; int right = pel.length()-1;
        for (int i = 0; i < 26; i++) {
            int n = arr[i]/2;
            arr[i] %= 2;
            for (int j = 0; j < n; j++) {
                ans[left] = (char) (65 + i);
                ans[right] = (char) (65 + i);
                left += 1;
                right -= 1;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 1) {
                ans[left] = (char) (65 + i);
            }
        }

        for (int i = 0; i < pel.length(); i++) {
            System.out.print(ans[i]);
        }

    }
}
