package 알고스터디.week9.레이저통신;

import java.util.*;

public class Main {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M;
    static char[][] arr;
    static ArrayList<Point> C;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        arr = new char[N][M];
        C = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String st = sc.next();
            for (int j = 0; j < M; j++) {
                arr[i][j] = st.charAt(j);
                if (arr[i][j] == 'C') {
                    C.add(new Point(i, j));
                }
            }
        }

        bfs();
    }
    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(C.remove(0));
        int[][] visited = new int[N][M];
        visited[queue.element().x][queue.element().y] = 1;

        while(!queue.isEmpty()) {
            Point temp = queue.poll();
            if (temp.x == C.get(0).x && temp.y == C.get(0).y) {
                System.out.println(visited[temp.x][temp.y] - 2);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                while (nx >=0 && nx < N && ny >= 0 && ny < M) {
                    if (arr[nx][ny] == '*') break;
                    if (visited[nx][ny] == 0 || visited[nx][ny] > visited[temp.x][temp.y] + 1) {
                        visited[nx][ny] = visited[temp.x][temp.y] + 1;
                        queue.offer(new Point(nx, ny));
                    }
                    nx += dx[i];
                    ny += dy[i];
                }
            }

        }
    }
}
