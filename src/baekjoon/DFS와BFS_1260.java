package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS_1260 {

    /**
     * 입력
     * 4 5 1
     * 1 2
     * 1 3
     * 1 4
     * 2 4
     * 3 4
     * <p>
     * 출력
     * 1 2 4 3
     * 1 2 3 4
     */
    private static int N, M, V;
    private static boolean[][] adj;
    private static boolean[] v;

    private static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adj = new boolean[N + 1][N + 1];
        v = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            // 양방향
            adj[from][to] = true;
            adj[to][from] = true;
        }

        dfs(V);
        sb.append("\n");
        bfs();
        sb.append("\n");
        System.out.println(sb);
    }

    private static void dfs(int index) {
        v[index] = true;
        sb.append(index + " ");
        for (int col = 1; col <= N; col++) {
            if (adj[index][col]
                    && !v[col]) {
                dfs(col);
            }
        }
    }

    private static void bfs() {
        v = new boolean[N + 1]; // 방문 배열 초기화
        Queue<Integer> q = new LinkedList<>();

        v[V] = true; // 첫 번째 노드
        q.add(V);

        while (!q.isEmpty()) {
            Integer index = q.poll();
            sb.append(index + " ");
            for (int col = 1; col <= N; col++) {
                if (adj[index][col]
                        && !v[col]) {
                    v[col] = true;
                    q.add(col);
                }
            }
        }
    }
}
