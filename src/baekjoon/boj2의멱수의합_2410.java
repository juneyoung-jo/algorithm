package baekjoon;

import java.util.Scanner;

public class boj2의멱수의합_2410 {
	static int N, ans, dp[];
	static final int DIV = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		dp = new int[1000001];

		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= N; i++) {
			if (i % 2 == 0) dp[i] = (dp[i - 1] + dp[i / 2]) % DIV;
			else dp[i] = dp[i - 1];
		}
		
		System.out.println(dp[N]);

	}

}
