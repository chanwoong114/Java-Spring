package 과제.완전탐색.격자판;

import java.util.*;

public class Solution {
    static String board[][] = new String[4][4];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static ArrayList<String> arr;
    static Set<String> set;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc < 1+T; tc++) {
            set = new HashSet<>();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    board[i][j] = sc.next();
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dfs(i, j, board[i][j]);
                }
            }
            System.out.println("#"+ tc + " " + set.size());
        }
    }

    static void dfs(int r, int c, String s) {
        if (s.length() == 7) {
            set.add(s);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4) {
                dfs(nr, nc, s + board[nr][nc]);
            }
        }
    }

}
