package 경사로;

import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int[] lst_row = new int[n];
            int[] lst_col = new int[n];
            for (int j = 0; j < n; j++) {
                lst_row[j] = arr[i][j];
                lst_col[j] = arr[j][i];
            }
            if (check(lst_row)) {
                cnt += 1;
            }
            if (check(lst_col)) {
                cnt += 1;
            }
        }

        System.out.println(cnt);
    }

    static boolean check(int lst[]) {
        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                int a = (int) Math.pow(-1, j);
                int ni = i + a;
                if (ni < 0 || ni >= n) {
                    continue;
                }
                if (lst[ni] >= lst[i]) {
                    continue;
                }
                if (lst[i] - lst[ni] > 1) {
                    return false;
                }

                for (int k = 0; k < m; k++) {
                    if (ni < 0 || ni >= n) {
                        return false;
                    }
                    if (lst[i] - lst[ni] == 1 && visited[ni] == 0) {
                        visited[ni] = 1;
                        ni += a;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
