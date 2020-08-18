package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 적록색약 {
	static int N;
	static char[][] map;
	static boolean v[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point {
		int x;
		int y;
		char col;

		public Point(int x, int y, char col) {
			super();
			this.x = x;
			this.y = y;
			this.col = col;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		// 알고리즘
		// dfs문제인데 2가지 방법으로 나눠서 풀어야 함.
		// 1. 적록색약이 아닌사람, 2. 적록색약인 사람 -> 조건만 바꿔주면 될듯
		// 적록색약이 아닌 사람
		v = new boolean[N][N];
		int cntN = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!v[r][c]) {
					cntN++;
					dfs(new Point(r, c, map[r][c]), v);
				}
			}
		}
		// 적록색약인 사람
		v = new boolean[N][N];
		int cntY = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!v[r][c]) {
					cntY++;
					dfsY(new Point(r, c, map[r][c]), v);
				}
			}
		}

		System.out.println(cntN + " " + cntY);

	}

	// 적록색약 기존 dfs에 조건만 추가해줌
	private static void dfsY(Point point, boolean[][] v) {
		v[point.x][point.y] = true;

		for (int k = 0; k < 4; k++) {
			int nr = point.x + dr[k];
			int nc = point.y + dc[k];

			if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
				if (point.col == 'R' || point.col == 'G') {
					if ((map[nr][nc] == 'R' || map[nr][nc] == 'G') && !v[nr][nc]) {
						dfsY(new Point(nr, nc, map[nr][nc]), v);
					}
				} else {
					if (map[nr][nc] == point.col && !v[nr][nc]) {
						dfsY(new Point(nr, nc, map[nr][nc]), v);
					}
				}

			}
		}

	}

	private static void dfs(Point point, boolean[][] v) {
		v[point.x][point.y] = true;

		for (int k = 0; k < 4; k++) {
			int nr = point.x + dr[k];
			int nc = point.y + dc[k];

			if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
				if (map[nr][nc] == point.col && !v[nr][nc]) {
					dfs(new Point(nr, nc, map[nr][nc]), v);
				}
			}

		}

	}

	private static void print(boolean[][] v) {
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v.length; j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}

	}

	// 출력부 확인용
	private static void print(char[][] v) {
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v.length; j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}

	}

}
