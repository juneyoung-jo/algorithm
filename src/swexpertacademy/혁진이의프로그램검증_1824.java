package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 혁진이의프로그램검증_1824 {
	static int T, R, C;
	static boolean[][][][] v;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 }; // 상 하 왼 오
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<Point> q = new LinkedList<Point>();

	static class Point {
		int r, c, dir, cnt;

		public Point(int r, int c, int dir, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][];
			v = new boolean[R][C][4][16];

			for (int i = 0; i < R; i++) {
				map[i] = br.readLine().toCharArray();
			}
			int num = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == '@') {
						num++;
					}
				}
			}
			q.clear();

			if (map[0][0] - '0' >= 0 && map[0][0] - '1' <= 9) {
				q.add(new Point(0, 0, 3, map[0][0] - '0'));
			} else {
				if (map[0][0] == '<') {
					q.add(new Point(0, 0, 2, 0));
				} else if (map[0][0] == '>') {
					q.add(new Point(0, 0, 3, 0));
				} else if (map[0][0] == '^') {
					q.add(new Point(0, 0, 0, 0));
				} else if (map[0][0] == 'v') {
					q.add(new Point(0, 0, 1, 0));
				} else {
					q.add(new Point(0, 0, 3, 0));
				}
			}

//			print(map);	
//			System.out.println(q.poll().cnt);
			if (num != 0) {
				cal(tc);
			} else {
				System.out.printf("#%d NO\n", tc);
			}
//			System.out.println((int)(Math.random()*4)+1);
		}

	}

	private static void cal(int tc) {
		Point p = null;
		while (!q.isEmpty()) {
			p = q.poll();

			int nr = p.r + dr[p.dir];
			int nc = p.c + dc[p.dir];

			if (nr < 0 || nr >= R)
				nr = (nr + R) % R;
			if (nc < 0 || nc >= C)
				nc = (nc + C) % C;

			if (map[nr][nc] == '@') {
				System.out.printf("#%d YES\n", tc);
				return;
			}
			if(v[nr][nc][p.dir][p.cnt]) continue;
			v[nr][nc][p.dir][p.cnt] = true;
			
			if (map[nr][nc] - '0' >= 0 && map[nr][nc] - '1' <= 9) {
				q.add(new Point(nr, nc, p.dir, map[nr][nc] - '0'));
			} else if (map[nr][nc] == '<') {
				q.add(new Point(nr, nc, 2, p.cnt));
			} else if (map[nr][nc] == '>') {
				q.add(new Point(nr, nc, 3, p.cnt));
			} else if (map[nr][nc] == '^') {
				q.add(new Point(nr, nc, 0, p.cnt));
			} else if (map[nr][nc] == 'v') {
				q.add(new Point(nr, nc, 1, p.cnt));
			} else if (map[nr][nc] == '_') {
				if (p.cnt == 0) {
					q.add(new Point(nr, nc, 3, p.cnt));
				} else {
					q.add(new Point(nr, nc, 2, p.cnt));
				}
			} else if (map[nr][nc] == '|') {
				if (p.cnt == 0) {
					q.add(new Point(nr, nc, 1, p.cnt));
				} else {
					q.add(new Point(nr, nc, 0, p.cnt));
				}
			} else if (map[nr][nc] == '?') {
				q.add(new Point(nr, nc, 0, p.cnt));
				q.add(new Point(nr, nc, 1, p.cnt));
				q.add(new Point(nr, nc, 2, p.cnt));
				q.add(new Point(nr, nc, 3, p.cnt));
			} else if (map[nr][nc] == '.') {
				q.add(new Point(nr, nc, p.dir, p.cnt));
			} else if (map[nr][nc] == '+') {
				if (p.cnt == 15) {
					p.cnt = -1;
				}
				q.add(new Point(nr, nc, p.dir, p.cnt + 1));
			} else if (map[nr][nc] == '-') {
				int count = p.cnt - 1;
				if (count == -1) {
					count = 15;
				}
				q.add(new Point(nr, nc, p.dir, count));
			}

		}

		System.out.printf("#%d NO\n", tc);
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
