package baekjoon;

import java.io.*;
import java.util.*;

public class 학교탐방하기_13418 {
    private static int N, M;
    private static List<Edge>[] edges;

    static private class Edge {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        // 인접리스트 생성
        for (int i = 0; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[from].add(new Edge(to, cost));
            edges[to].add(new Edge(from, cost));
        }

        PriorityQueue<Edge> maxPq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        int maxValue = prim(maxPq);

        PriorityQueue<Edge> minPq = new PriorityQueue<>((o1, o2) -> o2.cost - o1.cost);
        int minValue = prim(minPq);

        System.out.println((maxValue * maxValue) - (minValue * minValue));

    }

    private static int prim(PriorityQueue<Edge> pq) {
        boolean[] v = new boolean[N + 1];
        int result = 0;
        pq.add(new Edge(0, -1));

        while (!pq.isEmpty()) {
            Edge poll = pq.poll();
            int to = poll.to;
            int cost = poll.cost;

            if (v[to]) continue;
            v[to] = true;

            if(cost == 0) {
                result += 1;
            }

            for (Edge e : edges[to]) {
                if (!v[e.to]) {
                    pq.add(e);
                }
            }
        }

        return result;
    }
}
