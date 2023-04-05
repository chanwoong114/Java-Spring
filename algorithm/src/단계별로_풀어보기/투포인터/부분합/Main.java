package 단계별로_풀어보기.투포인터.부분합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int left = 0;
        int right = 0;
        int cnt = Integer.MAX_VALUE;

        while (right <= N) {
            if (sum >= M) {
                sum -= arr[left++];
                if (cnt > right - left + 1) cnt = right - left + 1;
            } else {
                sum += arr[right++];
            }
        }
        System.out.println(cnt == Integer.MAX_VALUE ? 0 : cnt);

    }
}
