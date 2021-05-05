package baekjoon;

import java.util.*;

import java.io.*;

public class 레이저통신_6087 {

	static int W, H, row, col, ans;
	static char map[][];
	static int[] dr = { 1, -1, 0, 0 }; // 하 상 우 좌
	static int[] dc = { 0, 0, 1, -1 };
	static boolean[][] v;
	static Queue<Point> q = new LinkedList<>();

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new char[H][];
		v = new boolean[H][W];

		// 입력
		for (int i = 0; i < H; i++) {
			map[i] = br.readLine().toCharArray();
		}

		L: for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 'C') {
					v[i][j] = true;
					q.add(new Point(i, j, 0));
					row = i;
					col = j;
					break L;
				}
			}
		}
		ans = Integer.MAX_VALUE;
		bfs();
		System.out.println(ans);

	}

	private static void bfs() {

		Point p = null;

		while (!q.isEmpty()) {
			p = q.poll();
			v[p.r][p.c] = true;

			for (int k = 0; k < 4; k++) {

				int nr = p.r;
				int nc = p.c;
				v[nr][nc] = true;

				while (true) {
					nr += dr[k];
					nc += dc[k];

					if (nr < 0 || nc < 0 || nr >= H || nc >= W || v[nr][nc] || map[nr][nc] == '*')
						break;

					if (map[nr][nc] == 'C' && !(nr == row && nc == col)) {
						ans = p.cnt;
						return;
					}

					q.add(new Point(nr, nc, p.cnt + 1));
				}

			}

		}

	}

}
