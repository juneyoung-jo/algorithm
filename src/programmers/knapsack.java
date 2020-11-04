package programmers;

import java.util.Scanner;

public class knapsack {
	static int T, N, K, ans;
	static int[] weights, values;
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();

			weights = new int[N + 1];
			values = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				weights[i] = sc.nextInt();
				values[i] = sc.nextInt();
			}
			
			dp = new int[N+1][K+1];
			
			for (int i = 1; i < dp.length; i++) {
				for (int j = 0; j < dp[i].length; j++) {
					if(weights[i] > j) {
						dp[i][j] = dp[i-1][j];
					}else {
						dp[i][j] = Math.max(values[i] + dp[i-1][j-weights[i]], dp[i-1][j]);
					}
				}
			}
			
			System.out.printf("#%d %d\n",tc,dp[N][K]);
			
			
		}

	}

}
