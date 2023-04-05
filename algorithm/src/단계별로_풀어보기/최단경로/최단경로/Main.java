package 단계별로_풀어보기.최단경로.최단경로;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static class Node {
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    static int V, E, K;
    static ArrayList<ArrayList<Node>> graph;
    static int dist[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();
        K = sc.nextInt();

        graph = new ArrayList<ArrayList<Node>>();

        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph.get(u).add(new Node(v, w));
        }

        dist = new int[V+1];
        for (int i = 0; i < V + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dijkstra(K);

        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    static void dijkstra(int s) {
        PriorityQueue<Node> queue = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        queue.offer(new Node(s, 0));
        dist[s] = 0;

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (dist[temp.idx] < temp.cost) {
                continue;
            }

            for (int i = 0; i < graph.get(temp.idx).size(); i++) {
                Node nextNode = graph.get(temp.idx).get(i);
                if (dist[nextNode.idx] > temp.cost + nextNode.cost) {
                    dist[nextNode.idx] = temp.cost + nextNode.cost;
                    queue.offer(new Node(nextNode.idx, dist[nextNode.idx]));
                }
            }
        }

    }
}