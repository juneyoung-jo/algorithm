package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 홈방범서비스 {
	static int T, N, M, map[][], Ans;
	static Queue<Point> q;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point {
		int r, c, k;

		public Point(int r, int c, int k) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			q = new LinkedList<Point>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Ans = 1;
			// 알고리즘
			// 3중 포문 ( k의 최대 넓어지는 회수, map[i], map[i][j])
			int val = 1;
			for (int k = 2; k <= N + 1; k++) { // 2부터 시작이니까 n+1번 돌아감.
				val += (4 * (k - 1));
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						// 2- 5, 3-13 4-25;
						int cnt = bfs(new Point(r, c, k), new boolean[N][N], 0, val, 0);
						q.clear();
						Ans = Math.max(Ans, cnt);
					}
				}
			}

			System.out.printf("#%d %d\n", tc, Ans);
//			print(map);

		}

	}

	private static int bfs(Point point, boolean[][] v, int cnt, int val, int index) {
		v[point.r][point.c] = true;
		q.add(point);
		index += map[point.r][point.c];
		cnt += (map[point.r][point.c] * M);

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (p.k != 1) {
				for (int d = 0; d < 4; d++) {
					int nr = p.r + dr[d];
					int nc = p.c + dc[d];

					if (nr < 0 || nc < 0 || nr >= N || nc >= N || v[nr][nc])
						continue;
					cnt += (map[nr][nc] * M);
					index += map[nr][nc];

					v[nr][nc] = true;
					q.add(new Point(nr, nc, p.k - 1));
				}

			}

		}

		if (cnt - val >= 0) {
			return index;
		}
		return 0;

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
