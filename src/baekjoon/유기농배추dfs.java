package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class 유기농배추dfs {
	static int T, M, N, K, map[][];
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			int Ans = 0;

			map = new int[M][N];

			for (int i = 0; i < K; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				map[from][to] = 1;
			}

			// 여기부터
			// print(map);
			for (int r = 0; r < M; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 1) {
						Ans++;
						dfs(r, c);
					}
				}
			}

			System.out.println(Ans);

		}

		sc.close();
	}

	private static void dfs(int r, int c) {
		map[r][c] = 0;

		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if (nr >= 0 && nc >= 0 && nr < M && nc < N && map[nr][nc] == 1) {
				map[nr][nc] = 0;
				dfs(nr, nc);
			}
		}

	}

	private static void print(int[][] adjMrx) {
		for (int i = 0; i < adjMrx.length; i++) {
			for (int j = 0; j < adjMrx[i].length; j++) {
				System.out.print(adjMrx[i][j] + " ");
			}
			System.out.println();
		}
	}

}
