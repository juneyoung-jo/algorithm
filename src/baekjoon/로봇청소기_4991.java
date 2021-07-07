package baekjoon;

import java.io.*;
import java.util.*;

public class 로봇청소기_4991 {
	static int w, h, row, col, count, ans;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static char[][] map;
	static boolean v[][][];
	static PriorityQueue<Point> q = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
	static Map<Integer, Integer> vMap = new HashMap<>();

	static class Point {
		int r, c, cnt, bit;

		public Point(int r, int c, int cnt, int bit) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.bit = bit;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			count = ans = 0;
			vMap.clear();

			if (w == 0 && h == 0) break; // 끝

			map = new char[h][];

			for (int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == '*') {
						vMap.put(i * 10000 + j, count);
						count++;
					} else if (map[i][j] == 'o') {
						row = i;
						col = j;
					}
				}
			}

			v = new boolean[1 << count][h][w];

			if (count != 0) cal();
			System.out.println(ans == 0 && count != 0 ? "-1" : ans);

		}
	}

	private static void cal() {
		q.clear();
		q.add(new Point(row, col, 0, (1 << count) - 1));
		v[(1 << count) - 1][row][col] = true;

		Point p = null;

		while (!q.isEmpty()) {
			p = q.poll();
			if (p.bit == 0) {
				ans = p.cnt;
				return;
			}

			if (map[p.r][p.c] == '*' && (p.bit & (1 << vMap.get(p.r * 10000 + p.c))) != 0) {
				q.add(new Point(p.r, p.c, p.cnt, (p.bit & ~(1 << vMap.get(p.r * 10000 + p.c)))));
				continue;
			}

			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];

				if (nr < 0 || nc < 0 || nr >= h || nc >= w || map[nr][nc] == 'x' || v[p.bit][nr][nc]) continue;
				v[p.bit][nr][nc] = true;
				q.add(new Point(nr, nc, p.cnt + 1, p.bit));
			}

		}
	}

}
