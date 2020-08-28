package swexpertacademy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 오나의여신님_7793 {
	static int T, N, M, Ans, Dr, Dc;
	static char[][] map;
	static boolean[][][] v;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<Point> q;

	static class Point {
		int r, c, cnt, id;

		public Point(int r, int c, int cnt, int id) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.id = id;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new char[N][M];
			v = new boolean[N][M][2];
			q = new LinkedList<Point>();
			for (int i = 0; i < map.length; i++) {
				String str = sc.next();
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == 'S') {
						v[i][j][0] = true;
						q.add(new Point(i, j, 0, 0));
					}
					if (map[i][j] == 'D') {
						Dr = i;
						Dc = j;
					}
				}
			}

			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map[r].length; c++) {
					if (map[r][c] == '*') {
						v[r][c][1] = true;
						q.add(new Point(r, c, 0, 1));
						break;
					}
				}
			}

			dfs();
			if (Ans == 0) {
				System.out.printf("#%d GAME OVER\n", tc);
			} else {
				System.out.printf("#%d %d\n", tc, Ans);
			}
			Ans = 0;
//			print(map);

		}

	}

	private static void dfs() {
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (p.r == Dr && p.c == Dc) {
				Ans = p.cnt;
				return;
			}
			if (v[p.r][p.c][0] && v[p.r][p.c][1]) {
				// 인간이 이동하고 스킬에 닿았을 때는
				// 더이상 갈 수 없기 때문
				// 이거 안해주면 테케1개 안맞음
				continue;
			}
			if (p.id == 0) {// 인간

				for (int k = 0; k < 4; k++) {
					int nr = p.r + dr[k];
					int nc = p.c + dc[k];

					if (nr < 0 || nc < 0 || nr >= N || nc >= M)
						continue;
					if (v[nr][nc][0] || v[nr][nc][1])
						continue;

					if (map[nr][nc] == '.' || map[nr][nc] == 'D') {
						v[nr][nc][0] = true;
						q.add(new Point(nr, nc, p.cnt + 1, p.id));
					}

				}

			} else {// 스킬
				for (int k = 0; k < 4; k++) {
					int nr = p.r + dr[k];
					int nc = p.c + dc[k];

					if (nr < 0 || nc < 0 || nr >= N || nc >= M)
						continue;
					if (v[nr][nc][1])
						continue;

					if (map[nr][nc] == '.' || map[nr][nc] == 'S') {
						v[nr][nc][1] = true;
						q.add(new Point(nr, nc, p.cnt, p.id));
					}
				}
			}

		}

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
