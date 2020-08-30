package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빵집_3109 {
	static int R, C, Ans;
	static char[][] map;
	static int[] dr = { -1, 0, 1 };
	static int[] dc = { 1, 1, 1 };
	static boolean[][] v;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][];
		v = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int r = 0; r < R; r++) {
			flag = true;
			dfs(r, 0);
		}
		System.out.println(Ans);
//		print(v);
	}

	private static void print(boolean[][] v) {
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[i].length; j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void dfs(int r, int c) {
		if (c == C - 1) {
			flag = false;
			Ans++;
			return;
		}

		for (int k = 0; k < 3; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];

			if (nr < 0 || nc < 0 || nr >= R || nc >= C)
				continue;
			if (v[nr][nc] || map[nr][nc] == 'x' || !flag)
				continue;
			v[nr][nc] = true;
			dfs(nr, nc);
		}

	}

}
