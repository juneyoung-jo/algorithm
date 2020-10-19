package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노_14500 {
	static int N, M, map[][], ans;
	static int[] dr = { 1, 0, 0, -1 };
	static int[] dc = { 0, -1, 1, 0 };
	static boolean[][] v;

	static class Point {
		int r, c, cnt, size;

		public Point(int r, int c, int cnt, int size) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.size = size;
		}

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		v = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				dfs(new Point(r, c, 0, map[r][c]));
				ans = Math.max(bfs(new Point(r, c)), ans);
			}
		}

		System.out.println(ans);
//		print(map);

	}

	private static int bfs(Point p) {
		int size = map[p.r][p.c];
		int maxsize = 0;
		for (int k = 0; k < 4; k++) {
			int nr = p.r + dr[k];
			int nc = p.c + dc[k];

			if (nr < 0 || nc < 0 || nr >= N || nc >= M)
				continue;
			size += map[nr][nc];
		}

		for (int k = 0; k < 4; k++) {
			int nr = p.r + dr[k];
			int nc = p.c + dc[k];

			if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
				maxsize = Math.max(maxsize, size);
				continue;
			}
			int sizesum = size - map[nr][nc];
			maxsize = Math.max(maxsize, sizesum);
		}

		return maxsize;

	}

	private static void dfs(Point p) {
		v[p.r][p.c] = true;
		if (p.cnt == 3) {
			ans = Math.max(p.size, ans);
			return;
		}

		for (int k = 0; k < 4; k++) {
			int nr = p.r + dr[k];
			int nc = p.c + dc[k];

			if (nr < 0 || nc < 0 || nr >= N || nc >= M || v[nr][nc])
				continue;
			dfs(new Point(nr, nc, p.cnt + 1, p.size + map[nr][nc]));
			v[nr][nc] = false;
		}

		v[p.r][p.c] = false;

	}

	private static void print(int[][] map) {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

}
