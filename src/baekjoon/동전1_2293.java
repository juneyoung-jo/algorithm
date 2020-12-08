package baekjoon;

import java.util.Scanner;

public class 동전1_2293 {
	static int n, k, num[], dp[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();

		num = new int[n + 1];
		dp = new int[k + 1];

		for (int i = 1; i <= n; i++) {
			num[i] = sc.nextInt();
		}

		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (j >= num[i]) dp[j] += dp[j - num[i]];
			}
		}

		System.out.println(dp[k]);

	}

}
