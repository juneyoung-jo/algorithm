package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 파이프옮기기1_17070 {
	static int N, map[][], ans, nmap[][];
	// 가로 세로 대각선
	static int[][] dr = { { 0, 1 }, { 1, 1 }, { 0, 1, 1 } };
	static int[][] dc = { { 1, 1 }, { 0, 1 }, { 1, 0, 1 } };

	static class Point {
		int r, c, n, cnt;

		public Point(int r, int c, int n, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.n = n;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", n=" + n + ", cnt=" + cnt + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		nmap = new int[N][N];

		// bfs는 시간초과
//		bfs(new Point(0, 1, 0, 1));
		dfs(new Point(0, 1, 0, 1));

//		System.out.println(nmap[N-1][N-1]);
		System.out.println(ans);

	}

	private static void dfs(Point point) {
		Point p = point;
		if (p.r == N - 1 && p.c == N - 1) {
			ans += 1;
			return;
		}
		if (p.n == 0) {
			for (int k = 0; k < 2; k++) {
				int nr = p.r + dr[0][k];
				int nc = p.c + dc[0][k];

				if (k == 0) {
					if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 1)
						continue;
					dfs(new Point(nr, nc, 0, p.cnt + 1));
				} else if (k == 1) {
					if (nr < 0 || nc < 0 || nr >= N || nc >= N || !check(nr, nc))
						continue;
					nmap[nr][nc] += p.cnt;
					dfs(new Point(nr, nc, 2, p.cnt + 1));
				}
			}

		} else if (p.n == 1) {
			for (int k = 0; k < 2; k++) {
				int nr = p.r + dr[1][k];
				int nc = p.c + dc[1][k];

				if (k == 0) {
					if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 1)
						continue;
					nmap[nr][nc] += p.cnt;
					dfs(new Point(nr, nc, 1, p.cnt + 1));
				} else if (k == 1) {
					if (nr < 0 || nc < 0 || nr >= N || nc >= N || !check(nr, nc))
						continue;
					nmap[nr][nc] += p.cnt;
					dfs(new Point(nr, nc, 2, p.cnt + 1));
				}
			}

		} else if (p.n == 2) {
			for (int k = 0; k < 3; k++) {
				int nr = p.r + dr[2][k];
				int nc = p.c + dc[2][k];

				if (k == 0) {
					if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 1)
						continue;
					nmap[nr][nc] += p.cnt;
					dfs(new Point(nr, nc, 0, p.cnt + 1));
				} else if (k == 1) {
					if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 1)
						continue;
					nmap[nr][nc] += p.cnt;
					dfs(new Point(nr, nc, 1, 1));
				} else if (k == 2) {
					if (nr < 0 || nc < 0 || nr >= N || nc >= N || !check(nr, nc))
						continue;
					nmap[nr][nc] += p.cnt;
					dfs(new Point(nr, nc, 2, 1));
				}
			}

		}

	}

	private static void bfs(Point point) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(point);

		while (!q.isEmpty()) {
			Point p = q.poll();
			if (p.n == 0) {
				for (int k = 0; k < 2; k++) {
					int nr = p.r + dr[0][k];
					int nc = p.c + dc[0][k];

					if (k == 0) {
						if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 1)
							continue;
						nmap[nr][nc] += p.cnt;
						q.add(new Point(nr, nc, 0, 1));
					} else if (k == 1) {
						if (nr < 0 || nc < 0 || nr >= N || nc >= N || !check(nr, nc))
							continue;
						nmap[nr][nc] += p.cnt;
						q.add(new Point(nr, nc, 2, 1));
					}
				}

			} else if (p.n == 1) {
				for (int k = 0; k < 2; k++) {
					int nr = p.r + dr[1][k];
					int nc = p.c + dc[1][k];

					if (k == 0) {
						if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 1)
							continue;
						nmap[nr][nc] += p.cnt;
						q.add(new Point(nr, nc, 1, 1));
					} else if (k == 1) {
						if (nr < 0 || nc < 0 || nr >= N || nc >= N || !check(nr, nc))
							continue;
						nmap[nr][nc] += p.cnt;
						q.add(new Point(nr, nc, 2, 1));
					}
				}

			} else if (p.n == 2) {
				for (int k = 0; k < 3; k++) {
					int nr = p.r + dr[2][k];
					int nc = p.c + dc[2][k];

					if (k == 0) {
						if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 1)
							continue;
						nmap[nr][nc] += p.cnt;
						q.add(new Point(nr, nc, 0, 1));
					} else if (k == 1) {
						if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 1)
							continue;
						nmap[nr][nc] += p.cnt;
						q.add(new Point(nr, nc, 1, 1));
					} else if (k == 2) {
						if (nr < 0 || nc < 0 || nr >= N || nc >= N || !check(nr, nc))
							continue;
						nmap[nr][nc] += p.cnt;
						q.add(new Point(nr, nc, 2, 1));
					}
				}

			}

		}

	}

	private static boolean check(int nr, int nc) {
		if (map[nr][nc] == 1)
			return false;
		if (map[nr - 1][nc] == 1)
			return false;
		if (map[nr][nc - 1] == 1)
			return false;

		return true;
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
