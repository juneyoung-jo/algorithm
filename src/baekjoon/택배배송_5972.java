package baekjoon;

import java.io.*;
import java.util.*;

public class 택배배송_5972 {
    private static int N, M;
    private static List<Edge>[] edges;

    private static class Edge {
        int to, cnt;

        public Edge(int to, int cnt) {
            this.to = to;
            this.cnt = cnt;
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

        // 양방향 인접리스트 생성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            edges[from].add(new Edge(to, cnt));
            edges[to].add(new Edge(from, cnt));
        }

        System.out.println(dijkstra());
    }

    private static int dijkstra() {
        boolean[] v = new boolean[N + 1];
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE); //최소값을 구하기 위해 Max 로 초기화
        distance[1] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cnt));
        pq.add(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int to = current.to;

            for (Edge e : edges[to]) {
                if (!v[e.to]
                        && distance[to] + e.cnt < distance[e.to]) {
                    distance[e.to] = distance[to] + e.cnt;
                    pq.add(new Edge(e.to, distance[e.to]));
                }
            }

        }
        return distance[N];
    }
}
