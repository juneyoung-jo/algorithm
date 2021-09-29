package baekjoon;

import java.util.*;
import java.io.*;

public class 이중우선순위큐_7662 {
    static int T, k;
    static PriorityQueue<Point> maxQ;
    static PriorityQueue<Point> minQ;
    static Set<Integer> set;

    static class Point {
        int idx, num;

        public Point(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }

        public boolean delete() {
            if (set.add(idx)) return true;
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        maxQ = new PriorityQueue<>((o1, o2) -> o2.num - o1.num);
        minQ = new PriorityQueue<>((o1, o2) -> o1.num - o2.num);
        set = new HashSet<>();

        while (T-- > 0) {
            maxQ.clear();
            minQ.clear();
            set.clear();

            k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                Character c = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if (c == 'I') {
                    minQ.add(new Point(i, num));
                    maxQ.add(new Point(i, num));
                } else {
                    if (num == 1) cal(maxQ);
                    else cal(minQ);
                }
            }

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            boolean flag = true;
            while (!minQ.isEmpty()) {
                Point poll = minQ.poll();
                if (poll.delete()) {
                    flag = false;
                    max = Math.max(max, poll.num);
                    min = Math.min(min, poll.num);
                }
            }
            System.out.printf(flag ? "EMPTY\n" : "%d %d\n", max, min);
        }
    }

    private static void cal(PriorityQueue<Point> q) {
        while (!q.isEmpty())
            if (q.poll().delete()) break;
    }
}
