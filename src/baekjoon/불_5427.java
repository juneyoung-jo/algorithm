package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불_5427 {
	static int T, w, h, Ans;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<Point> q;
	static boolean[][][] v;

	static class Point {
		int r, c, cnt, no;

		public Point(int r, int c, int cnt, int no) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.no = no;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int Tc = 0; Tc < T; Tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			map = new char[h][];
			v = new boolean[h][w][2]; // 불 배열과 사람 배열을 따로 씀.
			q = new LinkedList<Point>();

			for (int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();
			}

			// 알고리즘
			// 불 부터 bfs를 돌리고 사람을 돌려야 함.

			// 불 넣기
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == '*') {
						v[i][j][0] = true;
						q.add(new Point(i, j, 0, 0));
					}
				}
			}

			// 사람 넣기
			L: for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == '@') {
						q.add(new Point(i, j, 1, 1));
						v[i][j][1] = true;
						break L;
					}
				}
			}

			dfs();

//			print(map);
			System.out.println(Ans == 0 ? "IMPOSSIBLE" : Ans);
			Ans = 0;
		}

	}

	private static void dfs() {

		while (!q.isEmpty()) {
			Point p = q.poll();

			// 사람이 맵의 끝에 도달했을 때 탈출할 수 있음.
			if (p.no == 1 && (p.r == 0 || p.r == h - 1 || p.c == 0 || p.c == w - 1)) {
				Ans = p.cnt;
				return;
			}

			if (p.no == 0) { // 불
				for (int k = 0; k < 4; k++) {
					int nr = p.r + dr[k];
					int nc = p.c + dc[k];

					if (nr < 0 || nc < 0 || nr >= h || nc >= w)
						continue;
					if (!v[nr][nc][0] && (map[nr][nc] == '.' || map[nr][nc] == '@')) {
						v[nr][nc][0] = true;
						q.add(new Point(nr, nc, p.cnt + 1, p.no));
					}
				}
			} else { // 사람
				for (int k = 0; k < 4; k++) {
					int nr = p.r + dr[k];
					int nc = p.c + dc[k];

					if (nr < 0 || nc < 0 || nr >= h || nc >= w)
						continue;
					if (v[nr][nc][0])
						continue; // 불이 있는곳 갈 수 없음.
					if (!v[nr][nc][1] && map[nr][nc] == '.') {
						v[nr][nc][1] = true;
						q.add(new Point(nr, nc, p.cnt + 1, p.no));
					}
				}

			}
		}
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
