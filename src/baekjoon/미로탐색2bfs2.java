package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import baekjoon.유기농배추.Point;

public class 미로탐색2bfs2 {
	static int N, M, map[][];
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int Ans = Integer.MAX_VALUE;
	static boolean[][] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		v = new boolean[N][M];

		String[] str = new String[N];
		for (int i = 0; i < str.length; i++) {
			str[i] = sc.next();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = str[i].charAt(j) - '0';
			}
		}

		dfs(0, 0, 1);

		//print(map);
		System.out.println(Ans);
	}

	private static void dfs(int r, int c, int cnt) {
		if (r == N - 1 && c == M - 1) {
			Ans = Math.min(Ans, cnt);
			return;
		}

		v[r][c] = true;
		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			// 지도안에있는지 여부
			if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
				if (map[nr][nc] == 1 && !v[nr][nc]) {
					dfs(nr, nc, cnt + 1);
				}
			}

		}
		v[r][c] = false;
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
