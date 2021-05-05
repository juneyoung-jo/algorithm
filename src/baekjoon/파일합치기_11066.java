package baekjoon;

import java.io.*;
import java.util.*;

public class 파일합치기_11066 {
	static int T, K, arr[], dp[][], sum[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			K = Integer.parseInt(br.readLine());

			arr = new int[K];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < K; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dp = new int[K][K];

			int ans = Integer.MAX_VALUE;

			// 구간합 배열
			sum = new int[K + 1];
			for (int i = 1; i <= K; i++) {
				sum[i] = sum[i - 1] + arr[i - 1];
			}

			for (int i = 0; i < K - 1; i++) {
				ans = Math.min(ans, cal(0, i) + cal(i + 1, K - 1));
			}

			sb.append(ans + "\n");
		}

		System.out.println(sb);
	}

	private static int cal(int start, int end) {
		if (start == end) {
			dp[start][end] = arr[start];
			return arr[start];
		}
		if (dp[start][end] != 0) {
			return dp[start][end];
		}

		int anss = Integer.MAX_VALUE;
		for (int i = start; i < end; i++) {
			anss = Math.min(anss, cal(start, i) + cal(i + 1, end) + sum[end + 1] - sum[start]);
			dp[start][end] = anss;
		}

		return anss;
	}

}
