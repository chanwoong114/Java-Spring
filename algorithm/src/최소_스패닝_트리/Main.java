package 최소_스패닝_트리;

import java.util.*;

public class Main {
    static class Node{
        int idx, cost;
        Node(int idx, int cost)  {
            this.idx = idx;
            this.cost = cost;
        }
    }
    static List<Node>[] graph;
    static int V, E;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();

        graph = new ArrayList[V+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }
        prim();
    }

    static void prim() {
        boolean[] visited = new boolean[V+1];
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        queue.offer(new Node(1, 0));
        int[] dist = new int[V+1];
        Arrays.fill(dist, (int) 1e9);
        int total = 0;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            int v = temp.idx;
            int cost = temp.cost;

            if (visited[v]) continue;

            visited[v] = true;
            total += cost;
            dist[v] = cost;

            for (Node n: graph[v]) {
                if (!visited[n.idx]) {
                    queue.add(n);
                }
            }
        }
        System.out.println(total);
        for (int i = 1; i < V+1; i++) {
            System.out.print(dist[i] + " ");
        }
    }
}
