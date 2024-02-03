package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 호석이두마리치킨 {

    private static int N, M;
    private static int[][] distance;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        distance = new int[N + 1][N + 1];

        // dis 배열 초기화
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i != j) {
                    distance[i][j] = 10000001;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            distance[to][from] = 1;
            distance[from][to] = 1;
        }

        // 각 정점 별 최소거리 배열
        floydWarshall();

        // 치킨집 조합 계산
        int[] results = calResult();
        System.out.println(results[0] + " " + results[1] + " " + results[2]);

    }

    private static int[] calResult() {
        int minValue = Integer.MAX_VALUE;
        int fistNode = 100;
        int secondNode = 100;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                int sum = 0;
                for (int k = 1; k <= N; k++) {
                    sum += Math.min(distance[k][i], distance[k][j]) * 2;
                }
                if (minValue > sum) {
                    minValue = sum;
                    fistNode = i;
                    secondNode = j;
                }
            }
        }

        return new int[]{fistNode, secondNode, minValue};
    }

    private static void floydWarshall() {
        for (int k = 1; k <= N; k++) { // 거쳐가는 노드
            for (int i = 1; i <= N; i++) { // 시작점
                if (i == k) continue;
                for (int j = 1; j <= N; j++) { // 도착점
                    if (i == j || k == j) continue;
                    if (distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
    }

}
