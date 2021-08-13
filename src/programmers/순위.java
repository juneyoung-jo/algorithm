package programmers;

import java.util.*;

public class 순위 {
    static List<Integer>[] list;
    static boolean[][] v;

    public int solution(int n, int[][] results) {
        int answer = 0;

        list = new ArrayList[n + 1];
        v = new boolean[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < results.length; i++) {
            int winner = results[i][0];
            int loser = results[i][1];
            list[winner].add(loser);
        }


        for (int i = 1; i <= n; i++) {
            cal(i, i, i);
        }

        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            result[i]--;
            for (int j = 1; j <= n; j++) {
                if (v[i][j]) {
                    result[i]++;
                    result[j]++;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (result[i] == n) answer++;
        }
        return answer;
    }

    public static void cal(int idx, int winner, int next) {
        if (v[idx][next]) return;
        v[idx][next] = true;

        int size = list[winner].size();
        for (int i = 0; i < size; i++) {
            cal(idx, list[winner].get(i), list[winner].get(i));
        }
    }
}
