package 단계별로_풀어보기.MST.최소_스패닝_트리2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static class Node {
        int idx, cost;
        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

    }

    static int N, M;
    static List<Node>[] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        graph = new ArrayList[N+1];

        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int v = sc.nextInt();
            int u = sc.nextInt();
            int c = sc.nextInt();

            graph[v].add(new Node(u, c));
            graph[u].add(new Node(v, c));
        }
        prim();
    }

    static void prim() {
        boolean[] visited = new boolean[N+1];
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        queue.offer(new Node(1, 0));

        int total = 0;

        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            int v = temp.idx;
            int cost = temp.cost;

            if (visited[v]) continue;

            visited[v] = true;
            total += cost;

            for (Node n: graph[v]) {
                if (!visited[n.idx]) {
                    queue.add(n);
                }
            }
        }
        System.out.println(total);
    }

}
