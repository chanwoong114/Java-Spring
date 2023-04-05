package 단계별로_풀어보기.투포인터.두_수의_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int left = 0;
        int right = n-1;
        int cnt = 0;

        while (left < right) {
            int temp = arr[left] + arr[right];
            if (temp == x) {
                cnt += 1;
            }
            if (temp <= x) {
                left += 1;
            } else {
                right -=1;
            }
        }

        System.out.println(cnt);
    }
}
