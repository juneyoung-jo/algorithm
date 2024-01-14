package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로_1753_1 {

    private static int V, E, K;
    private static List<Edge>[] edges;
    private static int[] distance;

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
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        edges = new ArrayList[V + 1];
        distance = new int[V + 1]; // 최단경로 결과를 담을 배열
        for (int i = 0; i <= V; i++) {
            edges[i] = new ArrayList<>();
        }

        // result 배열 max 값으로 초기화(최소값을 찾기 위함)
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 인접 리스트 생성
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            edges[from].add(new Edge(to, cnt));
        }

        dijkstra();
        cal();

    }

    private static void cal() {
        for (int i = 1; i < distance.length; i++) {
            System.out.println(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]);
        }
    }

    private static void dijkstra() {
        boolean[] v = new boolean[V + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cnt));
        distance[K] = 0;
        pq.add(new Edge(K, distance[K]));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int to = current.to;
            v[to] = true;

            for (Edge e : edges[to]) {
                if (!v[e.to]
                        && distance[to] + e.cnt < distance[e.to]) {
                    distance[e.to] = distance[to] + e.cnt;
                    pq.add(new Edge(e.to, distance[e.to]));
                }
            }
        }
    }
}
