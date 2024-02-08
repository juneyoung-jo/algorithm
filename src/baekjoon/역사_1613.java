package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 역사_1613 {
    private static int N, K, S, MAX = 10000001;
    private static int[][] distance;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        distance = new int[N + 1][N + 1];

        // dis 배열 초기화
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i != j) {
                    distance[i][j] = MAX;
                }
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            distance[from][to] = 1;
        }

        // 각 정점 별 최소거리 배열
        floydWarshall();

        S = Integer.parseInt(br.readLine());
        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            sb.append(calResult(prev, next)).append("\n");
        }

        System.out.println(sb);
    }


    private static void floydWarshall() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (i == k) continue;
                for (int j = 1; j <= N; j++) {
                    if (i == j || j == k) continue;
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
    }


    private static int calResult(int prev, int next) {
        if (distance[prev][next] != MAX) { // 앞에 있는 번호의 사건이 먼저 일어났으면 -1
            return -1;
        } else if (distance[next][prev] != MAX) { // 뒤에 있는 번호의 사건이 먼저 일어났으면 1
            return 1;
        }
        // 어떤지 모르면(유추할 수 없으면) 0
        return 0;
    }
}
