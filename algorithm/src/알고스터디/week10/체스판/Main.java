package 알고스터디.week10.체스판;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static char[][] board;
    static int[][] checkW, checkB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N + 1][M + 1];
        checkW = new int[N + 1][M + 1];
        checkB = new int[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i + 1][j + 1] = line.charAt(j);
            }
        }
        check();
        int result = (int) 1e9;
        for (int i = K; i < N + 1; i++) {
            for (int j = K; j < M + 1; j++) {
                int x = i - K;
                int y = j - K;

                int countW = checkW[i][j] - checkW[x][j] - checkW[i][y] + checkW[x][y];
                int countB = checkB[i][j] - checkB[x][j] - checkB[i][y] + checkB[x][y];

                result = Math.min(result, countW);
                result = Math.min(result, countB);
            }
        }
        System.out.println(result);
    }

    static void check() {
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                checkW[i][j] = checkW[i - 1][j] + checkW[i][j - 1] - checkW[i - 1][j - 1];
                checkB[i][j] = checkB[i - 1][j] + checkB[i][j - 1] - checkB[i - 1][j - 1];
                if ((i + j) % 2 == 0) {
                    if (board[i][j] == 'B') checkW[i][j] += 1;
                    else checkB[i][j] += 1;
                } else {
                    if (board[i][j] == 'W') checkW[i][j] += 1;
                    else checkB[i][j] += 1;
                }
            }
        }
    }
}
