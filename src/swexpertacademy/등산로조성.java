package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 등산로조성 {
	static int T, N, K, map[][], ans;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Point {
		int r, c, cnt, point, cost;

		public Point(int r, int c, int cnt, int point, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.point = point;
			this.cost = cost;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			int max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == max) {
						dfs(new Point(r, c, 1, K, 1), new boolean[N][N]);
					}
				}
			}

			System.out.printf("#%d %d\n", tc, ans);
			ans = 0;
//			print(map);
		}

	}

	private static void dfs(Point point, boolean[][] v) {
		Point p = point;
		v[p.r][p.c] = true;

		for (int k = 0; k < 4; k++) {
			int nr = p.r + dr[k];
			int nc = p.c + dc[k];

			// 테두리체크
			if (nr < 0 || nc < 0 || nr >= N || nc >= N || v[nr][nc])
				continue;

			if (map[nr][nc] < map[p.r][p.c]) {
				dfs(new Point(nr, nc, p.cnt + 1, p.point, p.cost), v);
			}

			if (map[nr][nc] >= map[p.r][p.c] && p.cost == 1 && map[nr][nc] - p.point < map[p.r][p.c]) {
				int num = map[nr][nc] - map[p.r][p.c] + 1;
				map[nr][nc] -= num;
				dfs(new Point(nr, nc, p.cnt + 1, p.point - num, 0), v);
				map[nr][nc] += num;
			}
		}
		v[p.r][p.c] = false;

		ans = Math.max(ans, p.cnt);

	}

	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
