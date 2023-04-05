package 알고스터디.week9.감시;

import java.util.*;

public class Main {
    static class Point {
        int x, y, p;
        Point(int x, int y, int p) {
            this.x = x;
            this.y = y;
            this.p = p;
        }
    }

    static int N, M, minZero;
    static int[][] arr;
    static int[][][][] cctv = {{}, {{{1, 0}}, {{-1, 0}}, {{0, 1}}, {{0, -1}}},
            {{{1, 0}, {-1, 0}}, {{0, 1}, {0, -1}}},
            {{{-1, 0}, {0, 1}}, {{0, 1}, {1, 0}}, {{1, 0}, {0, -1}}, {{0, -1}, {-1, 0}}},
            {{{0, 1}, {0, -1}, {-1, 0}}, {{-1, 0}, {0, 1}, {1, 0}}, {{0, -1}, {0, 1}, {1, 0}}, {{1, 0}, {-1, 0}, {0, -1}}},
            {{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}}};
    static ArrayList<int []> camera = new ArrayList<>();
    static List<Integer> check_lst;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        check_lst = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            check_lst.add(i);
        }
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
                if (check_lst.contains(arr[i][j])) {
                    camera.add(new int[]{i, j});
                }
            }
        }

        minZero = (int) 1e9;
        dfs(0);
        System.out.println(minZero);
    }

    static int count_zero() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }

    static void dfs(int a) {
        if (a == camera.size()) {
            int c = count_zero();
            if (minZero > c) {
                minZero = c;
            }
            return;
        }

        int x = camera.get(a)[0];
        int y = camera.get(a)[1];

        for (int i = 0; i < cctv[arr[x][y]].length; i++) {
            Queue<Point> load = new LinkedList<>();
            for (int j = 0; j < cctv[arr[x][y]][i].length; j++) {
                int nx = x + cctv[arr[x][y]][i][j][0];
                int ny = y + cctv[arr[x][y]][i][j][1];
                while (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] != 6) {
                    if (!check_lst.contains(arr[nx][ny])) {
                        load.offer(new Point(nx, ny, arr[nx][ny]));
                        arr[nx][ny] = 9;
                    }
                    nx += cctv[arr[x][y]][i][j][0];
                    ny += cctv[arr[x][y]][i][j][1];
                }
            }
            dfs(a + 1);
            while (!load.isEmpty()) {
                Point temp = load.poll();
                arr[temp.x][temp.y] = temp.p;
            }
        }
    }

}