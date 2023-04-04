package 알고스터디.week9.뱀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n, k, l, timer;
    static int board[][];
    static ArrayList<Integer> time = new ArrayList<>();
    static ArrayList<Point> body = new ArrayList<>();
    static ArrayList<String> direction = new ArrayList<>();
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        board = new int[n][n];
        int visited[][] = new int[n][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a-1][b-1] = 1;
        }
        timer = 0;
        int d = 0;
        l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            time.add(Integer.parseInt(st.nextToken()));
            direction.add(st.nextToken());
        }
        time.add(0);
        direction.add("d");

        body.add(new Point(0, 0));
        body.add(new Point(0, 0));

        while (true) {
            int nx = body.get(0).x + dx[d];
            int ny = body.get(0).y + dy[d];
            timer += 1;

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] == 1) {
                break;
            }

            body.get(0).x = nx;
            body.get(0).y = ny;

            int a = body.get(body.size()-1).x;
            int b = body.get(body.size()-1).y;

            for (int i = body.size()-1; i > 0; i--) {
                visited[body.get(i).x][body.get(i).y] = 0;
                body.get(i).x = body.get(i-1).x;
                body.get(i).y = body.get(i-1).y;
            }

            if (board[nx][ny] == 1) {
                body.add(new Point(a, b));
                board[nx][ny] = 0;
            }

            for (int i = 1; i < body.size(); i++) {
                visited[body.get(i).x][body.get(i).y] = 1;
            }

            if (timer == time.get(0)) {
                if (Objects.equals(direction.get(0), "D")) {
                    d = (d+1)%4;
                } else {
                    d = (d+3)%4;
                }
                time.remove(0);
                direction.remove(0);
            }
        }
        System.out.println(timer);

    }
}
