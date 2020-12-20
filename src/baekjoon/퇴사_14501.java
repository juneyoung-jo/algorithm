package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_14501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N + 1];
		int[] P = new int[N + 1];

		int[] dp = new int[N + 2];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		// 알고리즘
		for (int i = N; i >= 1; i--) {
			if (i + T[i] > N + 1) {
				dp[i] = dp[i + 1];
			} else {
				if (P[i] + dp[i + T[i]] > dp[i + 1])
					dp[i] = P[i] + dp[i + T[i]];
				else
					dp[i] = dp[i + 1];
			}
		}

		System.out.println(dp[1]);
	}

}
