package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기_2206 {
	static int N, M, map[][], Ans = Integer.MAX_VALUE;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int[][] v;

	static class Point {
		int r, c, cnt, bk;

		public Point(int r, int c, int cnt, int bk) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.bk = bk;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		v = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
				v[i][j] = 2;
			}
		}

		bfs(new Point(0, 0, 1, 0));

		if (Ans == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(Ans);
		}

	}

	private static void bfs(Point point) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(point);
		v[point.r][point.c] = point.bk;

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (p.r == N - 1 && p.c == M - 1) {
				Ans = p.cnt;
				return;
			}

			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				if (v[nr][nc] <= p.bk)
					continue;

				if (map[nr][nc] == 0) {
					v[nr][nc] = p.bk;
					q.add(new Point(nr, nc, p.cnt + 1, p.bk));
				} else {
					if (p.bk == 0) {
						v[nr][nc] = p.bk + 1;
						q.add(new Point(nr, nc, p.cnt + 1, p.bk + 1));
					}
				}
			}

		}

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
