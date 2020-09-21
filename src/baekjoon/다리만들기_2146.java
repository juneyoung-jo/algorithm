package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리만들기_2146 {
	static int N, map[][], Ans = Integer.MAX_VALUE;
	static boolean[][] v;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<Point> q = new LinkedList<Point>();

	static class Point {
		int r, c, cnt, num;

		public Point(int r, int c, int cnt, int number) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.num = number;
		}

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {// 디버깅을 위해
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 알고리즘
		// dfs를 돌려서 섬의 개수를 찾고, 각각 넘버링을 함.
		// (0,0)부터 자신의 넘버가 아닌 다른 넘버가 나올 때까지 bfs를 돌려 최소값을 구하고 리턴
		
		
		// dfs를 돌려서 넘버링 하기.
		int cnt = 1;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == 1 && !v[i][j]) {
					dfs(new Point(i, j, cnt));
					cnt++;
				}
			}
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0)
					continue;
				for (int k = 0; k < 4; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];

					if (nr < 0 || nc < 0 || nr >= N || nc >= N)
						continue;
					if (map[nr][nc] == 0) {
						bfs(new Point(i, j, 0, map[i][j]), new boolean[N][N]);
						q.clear();
						break;
					}
				}
			}
		}

//		bfs(new Point(0, 2, 0, map[0][2]), new boolean[N][N]);
		System.out.println(Ans == Integer.MAX_VALUE ? 0 : Ans);

//		print(map);

	}

	private static void bfs(Point point, boolean[][] v) {
		v[point.r][point.c] = true;
		q.add(point);

		while (!q.isEmpty()) {

			Point p = q.poll();

			if (map[p.r][p.c] != p.num && map[p.r][p.c] != 0) {
				Ans = Math.min(Ans, p.cnt - 1);
				return;
			}

			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == p.num)
					continue;
				if (!v[nr][nc]) {
					v[nr][nc] = true;
					q.add(new Point(nr, nc, p.cnt + 1, p.num));
				}
			}
		}
	}

	private static void dfs(Point point) {
		Point p = point;
		v[p.r][p.c] = true;
		map[p.r][p.c] = p.cnt;

		for (int k = 0; k < 4; k++) {
			int nr = p.r + dr[k];
			int nc = p.c + dc[k];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N)
				continue;
			if (map[nr][nc] == 1 && !v[nr][nc])
				dfs(new Point(nr, nc, p.cnt));
		}

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
