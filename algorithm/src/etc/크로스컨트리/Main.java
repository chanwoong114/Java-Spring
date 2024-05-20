package etc.크로스컨트리;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            Map<Integer, Integer> teamMap = new HashMap<>();
            Map<Integer, int[]> scoreMap = new HashMap<>();
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                int m = scanner.nextInt();
                arr[j] = m;
                checkMap(teamMap, m);
            }
            int score = 1;
            for (int j = 0; j < n; j++) {
                if (teamMap.get(arr[j]) == 6) {
                    plusScore(scoreMap, arr[j], score);
                    score++;
                }
            }
            System.out.println(checkWinner(scoreMap));
        }
    }

    public static void checkMap(Map<Integer, Integer> map, int checkNum) {
        if (map.containsKey(checkNum)) {
            map.put(checkNum, map.get(checkNum) + 1);
        } else {
            map.put(checkNum, 1);
        }
    }

    public static void plusScore(Map<Integer, int[]> map, int team, int score) {
        if (map.containsKey(team)) {
            if (map.get(team)[0] < 5) {
                map.put(team, new int[]{map.get(team)[0] + 1, map.get(team)[1] + score, 0});
            } else if (map.get(team)[0] == 5) {
                map.put(team, new int[]{map.get(team)[0] + 1, map.get(team)[1], score});
            }
        } else {
            map.put(team, new int[]{2, score, 0});
        }
    }

    public static Integer checkWinner(Map<Integer, int[]> map) {
        return map.entrySet()
                .stream()
                .min((entry1, entry2) -> {
                    int[] value1 = entry1.getValue();
                    int[] value2 = entry2.getValue();
                    int secondCompare = Integer.compare(value1[1], value2[1]);
                    if (secondCompare != 0) {
                        return secondCompare;
                    } else {
                        return Integer.compare(value1[2], value2[2]);
                    }
                })
                .map(Map.Entry::getKey).get();
    }
}
