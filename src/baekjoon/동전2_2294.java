package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전2_2294 {
	static int n, k, coin[], dp[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		coin = new int[n];
		dp = new int[k + 1];

		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int j = 1; j <= k; j++) {
			for (int i = 0; i < n; i++) {
				if (j >= coin[i]) {
					if (dp[j - coin[i]] == Integer.MAX_VALUE) continue;
					int cal = 1 + dp[j - coin[i]];
					if (cal < dp[j]) dp[j] = cal;
				}

			}
		}

		System.out.println(dp[k] == Integer.MAX_VALUE ? -1 : dp[k]);

	}

}
