package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 안전영역bfs {
	static int N, map[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] v;

	static class Safe {
		int r;
		int c;

		public Safe(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// print(map);
		int max = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				max = Math.max(max, map[i][j]);
			}
		}

		int Ans = 0;
		for (int i = 0; i <= max; i++) {
			int count = 0;
			v = new boolean[N][N];

			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map.length; c++) {
					if (map[r][c] <= i) {
						map[r][c] = 0;
					}
				}
			}

			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map.length; c++) {
					if (map[r][c] != 0 && !v[r][c]) {
						count++;
						bfs(new Safe(r, c));
					}
				}
			}
			Ans = Math.max(Ans, count);
		}
		System.out.println(Ans);
	}

	private static void bfs(Safe safe) {
		Queue<Safe> Q = new LinkedList<Safe>();
		Q.add(safe);
		v[safe.r][safe.c] = true;

		while (!Q.isEmpty()) {
			Safe p = Q.poll();
			for (int k = 0; k < 4; k++) {// 4방체크
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];

				if (nr >= 0 && nc >= 0 && nr < N && nc < N && map[nr][nc] != 0 && !v[nr][nc]) {
					v[nr][nc] = true;
					Q.add(new Safe(nr, nc));
				}
			}
		}

	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
