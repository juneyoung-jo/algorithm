package baekjoon;

import java.util.*;
import java.io.*;

public class PuyoPuyo_11559 {

	static char map[][];
	static boolean flag;
	static int ans;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static Queue<Point> q = new LinkedList<>();
	static Queue<Character> item = new LinkedList<>();

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new char[12][];

		for (int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();
		}

		while (true) {
			// 모든 맵 bfs 돌면서 블록 제거
			flag = false; // 연쇄 여부
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] != '.') cal(i, j, map[i][j]);
				}
			}

			if (flag) ans++;
			// 정렬
			go();
			if (!flag) break;

		}

		System.out.println(ans);

	}

	private static void go() {

		for (int c = 0; c < 6; c++) {
			item.clear();
			for (int r = 11; r >= 0; r--) {
				if (map[r][c] != '.') {
					item.add(map[r][c]);
					map[r][c] = '.';
				}
			}

			int r = 11;
			while (!item.isEmpty()) {
				char color = item.poll();
				map[r][c] = color;
				r--;
			}

		}

	}

	public static void cal(int r, int c, char color) {
		q.clear();
		int cnt = 1;
		boolean[][] v = new boolean[12][6];
		q.add(new Point(r, c));
		v[r][c] = true;

		Point p = null;

		while (!q.isEmpty()) {
			p = q.poll();

			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];

				if (nr < 0 || nc < 0 || nr >= 12 || nc >= 6 || v[nr][nc] || map[nr][nc] != color)
					continue;

				v[nr][nc] = true;
				cnt++;
				q.add(new Point(nr, nc));
			}
		}

		if (cnt >= 4) {
			for (int i = 0; i < v.length; i++) {
				for (int j = 0; j < v[i].length; j++) {
					if (v[i][j])
						map[i][j] = '.';
				}
			}
			flag = true;
		}
	}

}
