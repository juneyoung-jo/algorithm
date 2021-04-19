package swexpertacademy;

import java.util.Scanner;

public class 프리랜서_4052 {
	static int N, M, arr[][], dp[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();

			arr = new int[N][3];

			for (int i = 0; i < N; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
				arr[i][2] = sc.nextInt();
			}

			dp = new int[M + 1];

			for (int i = 1; i <= M; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[j][1] != i) {
						dp[i] = Math.max(dp[i - 1], dp[i]);
						continue;
					}
					if (dp[arr[j][0] - 1] + arr[j][2] > dp[i - 1])
						dp[i] = Math.max(dp[arr[j][0] - 1] + arr[j][2], dp[i]);
				}
			}

			System.out.printf("#%d %d\n", test_case, dp[M]);

		}

	}

}
