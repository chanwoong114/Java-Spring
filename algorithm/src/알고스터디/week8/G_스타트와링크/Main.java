package 알고스터디.week8.G_스타트와링크;

import java.util.Scanner;

public class Main {

    static int n;
    static int arr[][];
    static boolean visited[];
    static int minimum = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        visited = new boolean[n];

        team(0, 0);
        System.out.println(minimum);

    }
    static int min(int num1, int num2) {
        if (num1 > num2) {
            return num2;
        } else {
            return num1;
        }
    }

    static void team(int depth, int idx) {
        if (depth == n/2) {
            diff();
            return;
        }
        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                team(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
    static void diff() {
        int team1 = 0;
        int team2 = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    team1 += arr[i][j];
                    team1 += arr[j][i];
                } else if (!visited[i] && !visited[j]) {
                    team2 += arr[i][j] + arr[j][i];
                }
            }
        }
        minimum = min(minimum, Math.abs(team1 - team2));
        if (minimum == 0) {
            System.out.println(minimum);
            System.exit(0);
        }
    }
}
