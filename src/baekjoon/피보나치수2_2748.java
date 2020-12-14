package baekjoon;

import java.util.Scanner;

public class 피보나치수2_2748 {
	static int n;
	public static void main(String[] args) {
		long dp[] = new long[91];
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		dp[0] = 0;
		dp[1] = 1;
		
		for (int i = 2; i <= 90; i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		
		System.out.println(dp[n]);

	}

}
