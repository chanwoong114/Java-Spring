package 알고스터디.week11.동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = N - 1; i > -1; i--) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int s = 0; int ans = 0;

        while (M > 0) {
            ans += M/arr[s];
            M %= arr[s];
            s++;
        }

        System.out.println(ans);
    }
}
