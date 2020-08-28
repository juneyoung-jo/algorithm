package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빵집_3109 {
	static int R, C, Ans;
	static char[][] map;
	static boolean[][] v;
	static int[] dr = { -1, 0, 1 };
	static int[] dc = { 1, 1, 1 };
	static boolean vf;

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
			vf = true;
			v[r][0] = true;
			dfs(r, 0);
		}
		System.out.println(Ans);

//		print(map);

	}

	private static void dfs(int r, int c) {
		if (c == C - 1) {
			Ans++;
			// 파이프가 연결이 되면 그 재귀모두 종료해야함.
			// 연결이 되는지 안 되는지가 중요함 모든경우가 필요한게 아님
			vf = false;
			return;
		}

		for (int k = 0; k < 3; k++) {

			int nr = r + dr[k];
			int nc = c + dc[k];

			if (nr < 0 || nr >= R || v[nr][nc] || map[nr][nc] == 'x')
				continue;
			if (!vf)
				return;
			v[nr][nc] = true;
			dfs(nr, nc);
		}
		return;
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

}
