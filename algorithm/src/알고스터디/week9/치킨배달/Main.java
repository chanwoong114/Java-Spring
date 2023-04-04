package 알고스터디.week9.치킨배달;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m, minimum;
    static int arr[][];
    static ArrayList<Point> chicken, home;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 1) {
                    home.add(new Point(i, j));
                } else if (arr[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }
        visited = new boolean[chicken.size()];
        minimum = (int) 1e9;
        combination(0, 0);
        bw.write(minimum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void combination(int idx, int cnt) {
        if (cnt == m) {
            minimum = Math.min(cal(), minimum);
            return;
        }
        for (int i = idx; i < chicken.size(); i++) {
            visited[i] = true;
            combination(i + 1, cnt + 1);
            visited[i] = false;
        }
    }

    static int cal() {
        int res = 0;
        for (int i = 0; i < home.size(); i++) {
            int distance = (int) 1e9;
            for (int j = 0; j < chicken.size(); j++) {
                if (visited[j]) {
                    distance = Math.min(distance, Math.abs(chicken.get(j).x - home.get(i).x) + Math.abs(chicken.get(j).y - home.get(i).y));
                }
            }
            res += distance;
        }
        return res;
    }
}
