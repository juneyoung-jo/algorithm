package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 내리막길_강의코드_1520 {
	static int N, M, Ans;
	static int[][] map;
	static boolean[][] v;
	static int[][] dp;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		v = new boolean[N][M];
		dp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		print(map);
//		dfs(0, 0);
//		System.out.println(Ans);
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		int Ans = dfs_dp(0,0);
//		print(dp);
		
		System.out.println(Ans);

	}

	private static int dfs_dp(int r, int c) {
		// TODO Auto-generated method stub
		
		if(r== N-1 && c== M-1) {
			return 1;
		}
		if(dp[r][c] != -1) return dp[r][c];
		dp[r][c] = 0;
		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			
			if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[r][c] <= map[nr][nc]) continue;
			dp[r][c] = dp[r][c] +  dfs_dp(nr, nc);
		}
		
		return dp[r][c];
		
	}

	private static void dfs(int r, int c) {
		if (r == N - 1 && c == M - 1) {
			Ans++;
			return;
		}
		v[r][c] = true;
		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];

			if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[r][c] <= map[nr][nc] || v[nr][nc]) continue;
			dfs(nr, nc);
		}
		v[r][c] = false;

	}

	private static void print(int[][] map) {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
