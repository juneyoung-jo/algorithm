package programmers;

import java.util.*;

public class 섬연결하기 {
    static int parents[];
    static class Point {
        int v, w, cost;

        public Point(int v, int w, int cost) {
            this.v = v;
            this.w = w;
            this.cost = cost;
        }
    }

    public int solution(int n, int[][] costs) {

        int answer = 0;
        parents = new int[n];
        List<Point> list = new ArrayList<Point>();

        for (int i = 0; i < costs.length; i++) {
            list.add(new Point(costs[i][0], costs[i][1], costs[i][2]));
        }

        Collections.sort(list, (o1, o2) -> o1.cost - o2.cost);
        makeSet();

        for (Point p : list) {
            if (n == 1) break;
            if (union(p.v, p.w)) {
                answer += p.cost;
                n--;
            }
        }

        return answer;
    }

    private static boolean union(int x, int y) {
        int xx = find(x);
        int yy = find(y);
        if (xx == yy) return false;
        parents[yy] = xx;
        return true;
    }

    private static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    private static void makeSet() {
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }
}
