package baekjoon;

import java.util.*;
import java.io.*;

public class 앱_7579 {
	static int N, M, arr[], cost[];

	static class Point {
		int m, c;

		public Point(int m, int c) {
			this.m = m;
			this.c = c;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		cost = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		int cst = 0;
		for (int i = 0; i < N; i++) {
			int c = Integer.parseInt(st.nextToken());
			cost[i] = c;
			cst += c;
		}

		int[][] dp = new int[N + 1][cst + 1];
		int ans = 0;

		for (int i = 1; i <= N; i++) {
			int memory = arr[i - 1];
			int cnt = cost[i - 1];

			for (int j = 0; j < dp[i].length; j++) {
				if (j >= cnt) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cnt] + memory);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		for (int i = 0; i <= cst; i++) {
			if (dp[N][i] >= M) {
				ans = i;
				break;
			}
		}

		System.out.println(ans);

	}

}
