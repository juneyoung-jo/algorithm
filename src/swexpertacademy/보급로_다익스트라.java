package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 보급로_다익스트라 {
	static int T, N, map[][], Ans;
	static boolean[][] v;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			v = new boolean[N][N];

			for (int i = 0; i < map.length; i++) {
				String str = br.readLine();
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			Ans = Integer.MAX_VALUE;

			dijkstra(0, 0);
			System.out.printf("#%d %d\n", tc, Ans);

		}

	}

	private static void dijkstra(int r, int c) {
		int[][] dist = new int[N][N];
		for (int i = 0; i < dist.length; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}

		dist[r][c] = 0;
		PriorityQueue<Point> q = new PriorityQueue<Point>((o1, o2) -> (Integer.compare(o1.cnt, o2.cnt)));
		q.add(new Point(r, c, 0));
		Point p = null;
		while (!q.isEmpty()) {
			p = q.poll();

			if (v[p.r][p.c])
				continue;

			v[p.r][p.c] = true;
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];

				if (check(nr, nc))
					continue;
				if (!v[nr][nc] && dist[nr][nc] > map[nr][nc] + p.cnt) {
					dist[nr][nc] = map[nr][nc] + p.cnt;
					q.add(new Point(nr, nc, dist[nr][nc]));
				}
			}

		}

		Ans = dist[N - 1][N - 1];
	}

	private static boolean check(int nr, int nc) {
		if (nr < 0 || nc < 0 || nr >= N || nc >= N)
			return true;
		return false;
	}

}
