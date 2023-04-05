package 단계별로_풀어보기.투포인터.두_용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int left = 0;
        int right = N-1;
        int diff = Integer.MAX_VALUE;
        int x = 0;
        int y = 0;

        while (left < right) {
            int temp = arr[left] + arr[right];
            int gap = Math.abs(temp);
            if (diff > gap) {
                diff = gap;
                x = arr[left];
                y = arr[right];
            }
            if (temp > 0){
                right--;
            } else {
                left++;
            }
        }
        System.out.println(x + " " + y);
    }
}
