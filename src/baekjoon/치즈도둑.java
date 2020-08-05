package baekjoon;

import java.util.Scanner;

public class 치즈도둑 {
	static int T, N, map[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int Ans;
	static boolean[][] v;

	static class Lump {
		int r, c;

		public Lump(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i <= 100; i++) {
				int max = 0;
				v = new boolean[N][N];
				for (int r = 0; r < N; r++) {

					for (int c = 0; c < N; c++) {
						if (map[r][c] == i) { // 일수별 갉아먹은 치즈
							map[r][c] = 0;
							v[r][c] = true;
						}
					}

				}
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {// dfs 돌려서 개수 구해야함.
						if (map[r][c] != 0 && !v[r][c]) {
							max++;
							dfs(new Lump(r, c));
						}
					}
				}
				Ans = Math.max(max, Ans);
			}

			System.out.printf("#%d %d\n", tc, Ans);
			Ans = 0;
		}

	}

	private static void dfs(Lump lump) {
		v[lump.r][lump.c] = true;

		for (int k = 0; k < 4; k++) {
			int nr = lump.r + dr[k];
			int nc = lump.c + dc[k];
			if (nr >= 0 && nc >= 0 && nr < N && nc < N && map[nr][nc] != 0 && !v[nr][nc]) {
				dfs(new Lump(nr, nc));
			}
		}

	}

	private static void print(boolean[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
