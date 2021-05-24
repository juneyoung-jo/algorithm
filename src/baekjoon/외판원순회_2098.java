package baekjoon;

import java.util.*;
import java.io.*;

public class 외판원순회_2098 {

	static int N, map[][];
	static final int INF = Integer.MAX_VALUE - 1000000;
	static int[][] dp = new int[16][1 << 16];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(cal(0, 1));
	}

	public static int cal(int cur, int v) {
		// 종료조건 (모든 점을 다 돌았을 때)
		if (v == (1 << N) - 1) {
			// 마지막 점에서 시작점으로 못가는 경우
			if (map[cur][0] == 0) return INF;

			return map[cur][0];
		}

		// memo (방문한 적이 있음)
		if (dp[cur][v] != 0) return dp[cur][v];

		dp[cur][v] = INF;

		for (int i = 1; i < N; i++) {
			int next = 1 << i;

			// 못가는 경우 or 이미 방문한 경우
			if (map[cur][i] == 0 || (v & next) > 0) continue;

			dp[cur][v] = Math.min(dp[cur][v], cal(i, v | next) + map[cur][i]);
		}

		return dp[cur][v];

	}

}
