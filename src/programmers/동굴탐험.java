package programmers;

import java.util.*;

public class 동굴탐험 {
    static List<Integer>[] list;
    static int[] prev;
    static boolean[] v;
    static Map<Integer, Integer> map = new HashMap<>();

    public boolean solution(int n, int[][] path, int[][] order) {
        boolean answer = true;

        list = new ArrayList[n];
        prev = new int[n];
        v = new boolean[n];

        Arrays.fill(prev, -1);
        prev[0] = 0;
        for (int i = 0; i < n; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < path.length; i++) {
            int start = path[i][0];
            int end = path[i][1];
            list[start].add(end);
            prev[end] = start;
        }

        for (int i = 0; i < order.length; i++)
            map.put(order[i][0], order[i][1]);

        cal();
        return answer;
    }

    public static void cal() {
        Queue<Integer> q = new LinkedList<>();
        v[0] = true;
        q.add(0);
        while (!q.isEmpty()) {
            int p = q.poll();

            int size = list[p].size();

            for (int i = 0; i < size; i++) {
                int idx = list[p].get(i);

                if (map.containsKey(idx)) {
                    System.out.println("hi");
                }
            }

        }
    }
}
