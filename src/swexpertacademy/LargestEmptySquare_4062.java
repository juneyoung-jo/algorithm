package swexpertacademy;

import java.util.Scanner;

public class LargestEmptySquare_4062 {
	static int map[][], N;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			map = new int[N + 1][N + 1];
			int[][] dp = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				String str = sc.next();
				for (int j = 1; j <= N; j++) {
					map[i][j] = str.charAt(j - 1) - '0';
				}
			}

			int ans = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] == 1)
						dp[i][j] = 0;
					else {
						dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
						dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i][j]);
						dp[i][j] += 1;
						if (ans < dp[i][j])
							ans = dp[i][j];
					}
				}
			}

			System.out.printf("#%d %d\n", test_case, ans);

		}
	}

}
