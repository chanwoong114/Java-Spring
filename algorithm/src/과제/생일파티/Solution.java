package 과제.생일파티;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    static class Node {
        int idx, cost;
        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    static int N, M;
    static int[] dist1, dist2;
    static ArrayList<ArrayList<Node>> graph1;
    static ArrayList<ArrayList<Node>> graph2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc < T + 1; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();
            int X = sc.nextInt();
            graph1 = new ArrayList<>();
            graph2 = new ArrayList<>();

            for (int i = 0; i < N + 1; i++) {
                graph1.add(new ArrayList<Node>());
                graph2.add(new ArrayList<Node>());
            }

            for (int i = 0; i < M; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                graph1.get(u).add(new Node(v, w));
                graph2.get(v).add(new Node(u, w));
            }

            dist1 = dijkstra(X, graph1);
            dist2 = dijkstra(X, graph2);
            int maxV = 0;
            for (int i = 1; i < N+1; i++) {
                maxV = Math.max(maxV, dist1[i] + dist2[i]);
            }
            System.out.println("#" + tc + " " + maxV);
        }
    }
    static int[] dijkstra(int start, ArrayList<ArrayList<Node>> graph) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, (int) 1e9);
        dist[start] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        queue.offer(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            for (int i = 0; i < graph.get(temp.idx).size(); i++) {
                Node next = graph.get(temp.idx).get(i);
                int cost = temp.cost + next.cost;
                if (dist[next.idx] > cost) {
                    dist[next.idx] = cost;
                    queue.offer(new Node(next.idx, cost));
                }
            }
        }
        return dist;
    }
}
