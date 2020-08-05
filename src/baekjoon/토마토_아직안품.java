package baekjoon;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토_아직안품 {
	static int M, N, map[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int Ans = 0;

	static class Tomato {
		int r, c, date;

		public Tomato(int r, int c, int date) {
			this.r = r;
			this.c = c;
			this.date = date;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();

		map = new int[N][M];
		boolean[][] v = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// System.out.println();
		// print(map);

		Queue<Tomato> Q = new LinkedList<Tomato>();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 1) {
					Q.add(new Tomato(r, c, 0));
					v[r][c] = true;
				}
			}
		}

		while (!Q.isEmpty()) {
			Tomato p = Q.poll();
			Ans = Math.max(Ans, p.date);

			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && map[nr][nc] == 0) {
					Q.add(new Tomato(nr, nc, p.date + 1));
					v[nr][nc] = true;
				}

			}
		}
		if (check(v)) {
			Ans = -1;
		}

		System.out.println(Ans);

	}

	private static boolean check(boolean[][] v) {
		for (int r = 0; r < v.length; r++) {
			for (int c = 0; c < v[r].length; c++) {
				if (map[r][c] == 0 && v[r][c] == false) {
					return true;
				}
			}
		}

		return false;
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");

			}
			System.out.println();
		}
	}

}
