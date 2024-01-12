package baekjoon;

import java.io.*;
import java.util.*;

public class 최소스패닝트리_1197 {
    private static int V, E;
    private static List<Edge>[] edges;

    private static class Edge {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        edges = new ArrayList[V + 1];


        // 간선 배열 초기화
        for (int i = 0; i <= V; i++) {
            edges[i] = new ArrayList<>();
        }

        // 인접 리스트 생성
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[from].add(new Edge(to, cost));
            edges[to].add(new Edge(from, cost));
        }

        System.out.println(prim());
    }

    private static int prim() {
        boolean[] v = new boolean[V + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Edge(1, 0)); // start, startCost

        int result = 0;
        while (!pq.isEmpty()) {
            Edge poll = pq.poll();
            int to = poll.to;
            int cost = poll.cost;

            if (v[to]) continue; // 이미 방문한 노드일 경우
            v[to] = true;

            result += cost; // 가중치 계산
            for (Edge e : edges[to]) {
                // 방문하지 않은 간선 pq 에 추가
                if (!v[e.to]) {
                    pq.add(e);
                }
            }
        }

        return result;
    }
}
