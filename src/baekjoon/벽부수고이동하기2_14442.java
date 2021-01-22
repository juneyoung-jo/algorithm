package baekjoon;

import java.util.*;
import java.io.*;

public class 벽부수고이동하기2_14442 {
	static int N, M, K, map[][];
	static boolean v[][][];
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class Point {
		int r, c, k, cnt;

		public Point(int r, int c, int k, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		v = new boolean[N][M][K + 1];
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		// 알고리즘
		System.out.println(bfs());

	}

	private static int bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, K, 1));
		v[0][0][K] = true;
		Point p = null;

		while (!q.isEmpty()) {
			p = q.poll();
			if (p.r == N - 1 && p.c == M - 1) {
				return p.cnt;
			}

			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || v[nr][nc][p.k])
					continue;
				if (map[nr][nc] == 1) {
					if (p.k > 0) {
						v[nr][nc][p.k - 1] = true;
						q.add(new Point(nr, nc, p.k - 1, p.cnt + 1));
					}
				} else {
					v[nr][nc][p.k] = true;
					q.add(new Point(nr, nc, p.k, p.cnt + 1));
				}

			}
		}

		return -1;

	}

}
