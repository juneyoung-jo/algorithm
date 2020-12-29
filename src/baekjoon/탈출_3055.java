package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈출_3055 {

	static char[][] map;
	static int R, C, ans, r, c;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1, };
	static boolean[][][] v;
	static Queue<Point> q, water;
	static ArrayList<Point> wList, sList;

	static class Point {
		int r, c, cnt;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][];
		v = new boolean[2][R][C];
		q = new LinkedList<Point>();
		water = new LinkedList<Point>();
		wList = new ArrayList<Point>();
		sList = new ArrayList<Point>();

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}


		// 알고리즘
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 'S') {
					v[0][i][j] = true;
					q.add(new Point(i, j, 0));
				} else if (map[i][j] == '*') {
					v[0][i][j] = true;
					v[1][i][j] = true;
					water.add(new Point(i, j));
				}
			}
		}

		bfs();
		System.out.println(ans == 0 ? "KAKTUS" : ans);

	}

	private static void bfs() {

		while (true) {

			// 물 먼저
			Point w = null;
			while (!water.isEmpty()) {
				w = water.poll();
				for (int k = 0; k < 4; k++) {
					int nr = w.r + dr[k];
					int nc = w.c + dc[k];

					if (nr < 0 || nc < 0 || nr >= R || nc >= C || v[1][nr][nc])
						continue;
					if (map[nr][nc] == 'D' || map[nr][nc] == 'X')
						continue;
					v[0][nr][nc] = true;
					v[1][nr][nc] = true;
					wList.add(new Point(nr, nc));
				}
			}

			water.addAll(wList);
			wList.clear();

			// 고슴도치
			Point d = null;
			while (!q.isEmpty()) {
				d = q.poll();

				for (int k = 0; k < 4; k++) {
					int nr = d.r + dr[k];
					int nc = d.c + dc[k];

					if (nr < 0 || nc < 0 || nr >= R || nc >= C || v[0][nr][nc] || v[1][nr][nc])
						continue;
					if (map[nr][nc] == 'X') continue;
					if (map[nr][nc] == 'D') {
						ans = d.cnt + 1;
						return;
					}
					v[0][nr][nc] = true;
					sList.add(new Point(nr, nc, d.cnt + 1));
				}

			}

			q.addAll(sList);
			sList.clear();

			if (q.size() == 0)
				break;
		}

	}

}
