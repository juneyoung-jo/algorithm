package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 말이되고픈원숭이_1600_강의코드 {
	static int K, W, H, map[][], Ans = Integer.MAX_VALUE;
	static int[] dr = { 0, 0, -1, 1, -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dc = { 1, -1, 0, 0, -2, -1, 1, 2, 2, 1, -1, -2 };
	static boolean[][][] v;
	static Queue<Point> q;

	static class Point {
		int r, c, cnt, k;

		public Point(int r, int c, int k, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		v = new boolean[H][W][K + 1];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		print(map);
		bfs(new Point(0, 0, K, 0));
		System.out.println(Ans == Integer.MAX_VALUE ? -1 : Ans);

	}

	private static void bfs(Point point) {
		q = new LinkedList<Point>();
		q.add(point);
		v[point.r][point.c][K] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (p.r == H - 1 && p.c == W - 1) {
				Ans = Math.min(p.cnt, Ans);
			}

			for (int k = 0; k < (p.k > 0 ? 12 : 4); k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				int nk = k < 4 ? p.k : p.k - 1;

				if (ckeck(nr, nc) && !v[nr][nc][nk] && map[nr][nc] != 1) {
					v[nr][nc][nk] = true;
					q.add(new Point(nr, nc, nk, p.cnt + 1));
				}
			}

		}

	}

	private static boolean ckeck(int nr, int nc) {
		if (nr >= 0 && nc >= 0 && nr < H && nc < W)
			return true;
		return false;
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
