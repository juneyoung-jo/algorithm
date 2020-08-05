package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토1 {
	static int N, M, map[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] v;

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

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[M][N];
		v = new boolean[M][N];
		int Ans = 0;

		Queue<Tomato> Q = new LinkedList<Tomato>();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1) {
					v[r][c] = true;
					Q.add(new Tomato(r, c, 0));
				}
			}
		}

		while (!Q.isEmpty()) {
			Tomato p = Q.poll(); // 큐에서 꺼내기

			Ans = Math.max(Ans, p.date);

			for (int k = 0; k < 4; k++) { // 4방체크
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];

				if (nr >= 0 && nc >= 0 && nr < M && nc < N && map[nr][nc] == 0 && !v[nr][nc]) {
					v[nr][nc] = true;
					Q.add(new Tomato(nr, nc, p.date + 1));
				}

			}
		}
		
		if(check(v)) {
			Ans = -1;
		}

		// print(map);
		System.out.println(Ans);

	}

	private static boolean check(boolean[][] v) {
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[i].length; j++) {
				if(!v[i][j] && map[i][j] == 0) {
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
