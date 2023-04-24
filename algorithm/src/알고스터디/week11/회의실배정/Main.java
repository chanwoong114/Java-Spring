package 알고스터디.week11.회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Time {
        int n1, n2;
        Time(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Time> arr = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.n2, o2.n2));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            arr.offer(new Time(n1, n2));
        }

        Time temp = arr.poll();
        int cnt = 1, end = temp.n2;
        while (!arr.isEmpty()) {
            temp = arr.poll();
            if (end <= temp.n1) {
                cnt++;
                end = temp.n2;
            }
        }
        System.out.println(cnt);
    }
}
