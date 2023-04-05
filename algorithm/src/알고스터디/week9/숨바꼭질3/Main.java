package 알고스터디.week9.숨바꼭질3;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static class Point {
        int idx, cost;
        Point(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }


    static int N, M;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[100001];
        Arrays.fill(arr, (int) 1e9);

        System.out.println(dijkstra());
    }
    static int dijkstra(){
        PriorityQueue<Point> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        queue.offer(new Point(N, 0));
        arr[N] = 0;
        int nx = 0;


        while (!queue.isEmpty()) {
            Point temp = queue.poll();

            if (arr[temp.idx] < temp.cost) {
                continue;
            }

            nx = temp.idx - 1;
            if (nx >= 0) {
                if (arr[nx] > temp.cost + 1){
                    arr[nx] = temp.cost + 1;
                    queue.offer(new Point(nx, arr[nx]));
                }
            }
            nx = temp.idx + 1;
            if (nx <= 100000) {
                if (arr[nx] > temp.cost + 1) {
                    arr[nx] = temp.cost + 1;
                    queue.offer(new Point(nx, arr[nx]));
                }
            }
            nx = temp.idx * 2;
            if (nx <= 100000) {
                if (arr[nx] > temp.cost) {
                    arr[nx] = temp.cost;
                    queue.offer(new Point(nx, arr[nx]));
                }
            }

        }


        return arr[M];
    }

}
