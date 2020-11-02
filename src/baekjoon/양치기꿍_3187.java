package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 양치기꿍_3187 {

	static int R, C, wolf, sheep, S, W;
	static char[][] map;
	static boolean[][] v;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		v = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if ((map[r][c] == '.' || map[r][c] == 'v' || map[r][c] == 'k') && !v[r][c]) {

					bfs(new Point(r, c));

					if (S > W) {
						sheep += S;
					} else {
						wolf += W;
					}
				}
				W = 0;
				S = 0;
			}
		}

		System.out.println(sheep + " " + wolf);

	}

	private static void bfs(Point point) {
		Queue<Point> q = new LinkedList<Point>();
		v[point.r][point.c] = true;
		q.add(point);
		if (map[point.r][point.c] == 'v')
			W++;
		if (map[point.r][point.c] == 'k')
			S++;

		Point p = null;

		while (!q.isEmpty()) {
			p = q.poll();

			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C || v[nr][nc])
					continue;
				if (map[nr][nc] == '#')
					continue;
				if (map[nr][nc] == 'k') {
					v[nr][nc] = true;
					S++;
					q.add(new Point(nr, nc));
				}

				if (map[nr][nc] == 'v') {
					W++;
					v[nr][nc] = true;
					q.add(new Point(nr, nc));
				}

				v[nr][nc] = true;
				q.add(new Point(nr, nc));
			}

		}

	}

}
