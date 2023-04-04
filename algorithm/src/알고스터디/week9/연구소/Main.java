package 알고스터디.week9.연구소;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n, m, maxV;
    static int arr[][];
    static ArrayList<Point> check = new ArrayList<>();
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 2) {
                    check.add(new Point(i, j));
                }
            }
        }

        maxV = 0;
        makewall(0);
        System.out.println(maxV);

    }

    static void makewall(int depth) {
        if (depth == 3) {
            maxV = Math.max(maxV, virus());
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    makewall(depth + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    static int virus() {
        int visited[][] = new int[n][m];
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < check.size(); i++) {
            queue.offer(check.get(i));
        }

        while (!queue.isEmpty()) {
            Point next = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m){
                    continue;
                }
                if (visited[nx][ny] == 0 && arr[nx][ny] ==0) {
                    visited[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && arr[i][j] == 0) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }
}
