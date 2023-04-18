package 알고스터디.week10.인간컴퓨터상호작용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();
        int q = Integer.parseInt(br.readLine());

        int[][] dic = new int[S.length() + 1][26];

        for (int i = 1; i < S.length() + 1; i++) {
            for (int j = 0; j < 26; j++) {
                if (S.charAt(i-1) - 'a' == j) dic[i][j] += 1;
                dic[i][j] += dic[i - 1][j];
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            char a = (st.nextToken()).charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(dic[end + 1][a - 'a'] - dic[start][a - 'a'] + "\n");
        }
        System.out.println(sb);


    }
}
