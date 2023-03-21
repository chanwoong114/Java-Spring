package 유기농배추;

import java.util.*;

public class Solution {

    public static int n;
    public static int m;
    public static int arr[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; tc++) {
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();
            int cnt = 0;
            arr = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = 0;
                }
            }

            for (int i = 0; i < k; i++) {
                int b = sc.nextInt();
                int a = sc.nextInt();
                arr[a][b] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1) {
                        bfs(i, j);
                        cnt += 1;
                    }
                }
            }

            System.out.println(cnt);

        }
    }

    public static void bfs(int num1, int num2) {
        int dk[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{num1, num2});
        arr[num1][num2] = 0;

        while (!queue.isEmpty()) {
            int[] a = queue.pollFirst();
            for (int[] ints : dk) {
                int newA = a[0] + ints[0];
                int newB = a[1] + ints[1];

                if (((0 <= newA && newA < n) && (0 <= newB && newB < m)) && arr[newA][newB] == 1) {
                    queue.add(new int[]{newA, newB});
                    arr[newA][newB] = 0;
                }
            }
        }
    }

}
