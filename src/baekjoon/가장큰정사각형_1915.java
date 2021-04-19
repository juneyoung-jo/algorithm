package baekjoon;

import java.util.*;
import java.io.*;

public class 가장큰정사각형_1915 {
	static int N, M, map[][], dp[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		dp = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = str.charAt(j - 1) - '0';
			}
		}
		
		int ans = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 0) dp[i][j] = 0;
				else {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
					dp[i][j] += 1;
					
					if(ans < dp[i][j]) ans = dp[i][j];
				}
			}
		}

		System.out.println(ans*ans);

	}
}
