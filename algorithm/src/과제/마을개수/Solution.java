package 과제.마을개수;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    static int N, M;
    static int[] rep, rank;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc < T+1; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();

            rep = new int[N+1];
            rank = new int[N+1];
            for (int i = 1; i < N+1; i++) {
                rep[i] = i;
            }

            for (int i = 0; i < M; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                union(u, v);
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i < N + 1; i++) {
                set.add(find_set(rep[i]));
            }
            System.out.println("#"+tc+" "+set.size());
        }
    }

    static int find_set(int x) {
        while (x != rep[x]) {
            x = rep[x];
        }
        return x;
    }

    static void union(int x, int y) {
        int xp = find_set(x);
        int yp = find_set(y);

        if (rank[xp] == rank[yp]) {
            rep[yp] = xp;
            rank[xp] += 1;
        } else if (rank[xp] < rank[yp]) {
            rep[xp] = yp;
        } else {
            rep[yp] = xp;
        }
    }
}
