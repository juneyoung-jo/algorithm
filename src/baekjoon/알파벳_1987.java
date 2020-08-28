package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳_1987 {
	static int R, C, Ans;
	static char[][] map;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static boolean[] v;

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		v = new boolean[26];
		map = new char[R][];

		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
		}

		dfs(new Point(0, 0, 1));
		System.out.println(Ans);

//		print(map);

	}

	private static void print(char[][] map) {
		// TODO Auto-generated method stub
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void dfs(Point p) {
		v[map[p.r][p.c] - 'A'] = true;

		if (Ans == 26) {
			return;
		}

		for (int k = 0; k < 4; k++) {
			int nr = p.r + dr[k];
			int nc = p.c + dc[k];

			if (nr < 0 || nc < 0 || nr >= R || nc >= C)
				continue;
			if (v[map[nr][nc] - 'A'])
				continue;

			dfs(new Point(nr, nc, p.cnt + 1));
		}

		v[map[p.r][p.c] - 'A'] = false;

		Ans = Math.max(p.cnt, Ans);

	}

}
