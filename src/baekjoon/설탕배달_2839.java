package baekjoon;

import java.util.Scanner;

public class 설탕배달_2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] dp = new int[5003];
		dp[0] = dp[1] = dp[2] = dp[4] = Integer.MAX_VALUE;
		dp[3] = dp[5] = 1;
		
		for (int i = 6; i < dp.length; i++) {
			dp[i] = Math.min(dp[i-3], dp[i-5]) ==Integer.MAX_VALUE?Integer.MAX_VALUE:Math.min(dp[i-3], dp[i-5])+1;
		}
		System.out.println(dp[N]==Integer.MAX_VALUE?-1:dp[N]);
	}

}
