package baekjoon;

import java.util.*;
import java.io.*;

public class 내리막길_1520 {
	static int M, N, map[][], dp[][];
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		dp = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				dp[i][j] = -1;
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(cal(0,0));

	}

	private static int cal(int r, int c) {
		if(r == M-1 && c == N-1) {
			return 1;
		}
		
		if(dp[r][c] != -1) return dp[r][c];
		dp[r][c] = 0;
		
		for(int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			
			if(nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
			if(map[r][c] <= map[nr][nc]) continue;
			dp[r][c] += cal(nr,nc);
		}
		
		return dp[r][c];
		
	}

}
