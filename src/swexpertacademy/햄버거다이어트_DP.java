package swexpertacademy;

import java.util.Scanner;

public class 햄버거다이어트_DP {
	static int T,N,L;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			
			
			int[] point = new int[N+1];
			int[] cal = new int[N+1];
			
			for (int i = 1; i <= N; i++) {
				point[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			
			int[][] dp = new int[N+1][L+1];
			
			for (int i = 1; i < dp.length; i++) {
				for (int j = 0; j < dp[i].length; j++) {
					if(cal[i] > j) {
						dp[i][j] = dp[i-1][j];
					}else {
						dp[i][j] = Math.max(point[i] + dp[i-1][j-cal[i]], dp[i-1][j]);
					}
				}
			}
			
			System.out.printf("#%d %d\n",tc,dp[N][L]);
			
			
			
		}
		
	}

}
