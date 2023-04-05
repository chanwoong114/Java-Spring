package 알고스터디.week9.인구이동;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static class Location {
        int x, y;
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, L, R, cnt;
    static int board[][], visited[][];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};

    public static void main(String[] args) {
        int day = 0;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        while (true) {
            visited = new int[N][N];
            cnt = 1;
            ArrayList<Integer> arr = new ArrayList<Integer>();
            arr.add(0);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == 0) {
                        for (int k = 0; k < 4; k++) {
                            if (i + dx[k] >= 0 && i + dx[k] < N && j + dy[k] >= 0 && j + dy[k] < N) {
                                if (Math.abs(board[i][j] - board[i + dx[k]][j + dy[k]]) >= L && Math.abs(board[i][j] - board[i + dx[k]][j + dy[k]]) <= R) {
                                    arr.add(bfs(i, j));
                                    cnt += 1;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (cnt == 1) {
                break;
            }
            divide(cnt, arr);
            day += 1;
        }

        System.out.println(day);
    }


    static void divide(int c, ArrayList<Integer> arr) {
        int count[] = new int[c];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] > 0) {
                    count[visited[i][j]] += board[i][j];
                }
            }
        }
        for (int i = 1; i < c; i++) {
            count[i] /= arr.get(i);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] > 0) {
                    board[i][j] = count[visited[i][j]];
                }
            }
        }
    }

    static int bfs(int r, int c) {
        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(r, c));
        int C = 1;
        visited[r][c] = cnt;

        while (!queue.isEmpty()) {
            Location temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                Location next = new Location(temp.x + dx[i], temp.y + dy[i]);

                if (next.x >= 0 && next.x < N && next.y >=0 && next.y <N && visited[next.x][next.y] == 0){
                    if (Math.abs(board[temp.x][temp.y] - board[next.x][next.y]) >= L && Math.abs(board[temp.x][temp.y] - board[next.x][next.y]) <= R) {
                        visited[next.x][next.y] = cnt;
                        queue.offer(new Location(next.x, next.y));
                        C += 1;
                    }
                }

            }

        }
        return C;
    }
}
