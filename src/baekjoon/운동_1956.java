package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 운동_1956 {

    private static int V, E, inf = 10000001;
    private static int[][] distance;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        distance = new int[V + 1][V + 1];
        // init inf
        for (int i = 0; i <= V; i++) {
            Arrays.fill(distance[i], inf);
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            distance[to][from] = cnt;
        }

        floydWarshall();

        int minDistance = calMinDistance();
        System.out.println(minDistance >= inf ? -1 : minDistance);
    }

    /**
     * 싸이클: (i -> j) + (j -> i) 가 inf 보다 작다면 최소값임.
     */
    private static int calMinDistance() {
        int result = inf;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) continue;
                result = Math.min(result, distance[i][j] + distance[j][i]);
            }
        }

        return result;
    }

    private static void floydWarshall() {
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                if (i == k) continue;
                for (int j = 1; j <= V; j++) {
                    if (i == j || k == j) continue;
                    distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]);
                }
            }
        }
    }
}
