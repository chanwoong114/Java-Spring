package 알고스터디.week11.주유소;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        long[] dist = new long[N-1];
        long[] oil = new long[N];
        long cost = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) dist[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) oil[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N - 1; i++) {
            if (dist[i] > 0) {
                cost += oil[i] * dist[i];
            } else {
                continue;
            }
            for (int j = i+1; j < N-1; j++) {
                if (oil[i] <= oil[j]) {
                    cost += oil[i] * dist[j];
                    dist[j] = 0;
                } else {
                    break;
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(cost+"\n");
        bw.close();
        br.close();
    }
}