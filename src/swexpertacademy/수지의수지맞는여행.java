package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수지의수지맞는여행 {
	static int T, R, C, Ans, max;
	static char[][] map;
	static boolean[] v;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new char[R][C];
			for (int i = 0; i < map.length; i++) {
				String str = br.readLine();
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			// 알고리즘
			v = new boolean[26]; // 알파벳 수 (중복체크할거임)
			dfs(0, 0);

			// print(map);
			System.out.printf("#%d %d\n", tc, Ans);
			Ans = 0;
			max = 0;
		}
	}

	private static void dfs(int r, int c) {
		v[map[r][c] - 'A'] = true;
		max++;
		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];

			if (nr >= 0 && nc >= 0 && nr < R && nc < C && !v[map[nr][nc] - 'A']) {
				dfs(nr, nc);

			}
		}
		v[map[r][c] - 'A'] = false;
		Ans = Math.max(Ans, max);
		max--;

	}

	private static void print(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
