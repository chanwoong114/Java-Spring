package 알고스터디.week9.아기상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int n, size, eat;
    static int board[][];
    static int dx[] = {-1, 0, 0, 1};
    static int dy[] = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        StringTokenizer st;
        int a = 0;
        int b = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    a = i;
                    b = j;
                    board[i][j] = 0;
                }
            }
        }
        size = 2;
        eat = 0;
        int cnt = 0;


        while (true) {
            ArrayList<int []> res = bfs(a, b);
            if (res.isEmpty()) {
                break;
            }
            int arr[] = res.get(0);
            for (int i = 0; i < res.size(); i++) {
                if (arr[0] > res.get(i)[0]) {
                    arr = res.get(i);
                } else if (arr[0] == res.get(i)[0]) {
                    if (arr[1] > res.get(i)[1]) {
                        arr = res.get(i);
                    } else if (arr[1] == res.get(i)[1]) {
                        if (arr[2] > res.get(i)[2]) {
                            arr = res.get(i);
                        }
                    }
                }
            }
            cnt += arr[0];
            a = arr[1];
            b = arr[2];

            board[a][b] = 0;
            eat += 1;
            if (size == eat) {
                size += 1;
                eat = 0;
            }
        }

        System.out.println(cnt);
    }

    static ArrayList<int []> bfs(int a, int b) {
        ArrayList<int []> res = new ArrayList<>();
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int[]{a, b});
        int visited[][] = new int[n][n];
        visited[a][b] = 1;

        while (!queue.isEmpty()) {
            int arr[] = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = arr[0] + dx[i];
                int ny = arr[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                if (board[nx][ny] > size) {
                    continue;
                }
                if (board[nx][ny] != 0 && board[nx][ny] < size && visited[nx][ny] == 0) {
                    res.add(new int[]{visited[arr[0]][arr[1]], nx, ny});
                    visited[nx][ny] = visited[arr[0]][arr[1]] + 1;
                }
                if (visited[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = visited[arr[0]][arr[1]] + 1;
                }
            }
        }

        return res;
    }

}
