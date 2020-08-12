package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 디저트카페미완성 {
	static int T, N, map[][], rcount, ccount, Ans = -1;
	static int[] dr = { 1, 1, -1, -1 }; // 오른쪽 아래 대각선부터 시계방향
	static int[] dc = { 1, -1, -1, 1 };
	static boolean[] v, vmap[];

	static class Point {
		int r;
		int c;
		int cost;

		public Point(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
//			vmap = new boolean[N][N];
//			v = new boolean[101];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// print(map);
			for (int r = 0; r < map.length - 2; r++) {
				for (int c = 1; c < map.length - 1; c++) {
					rcount = 0;
					ccount = 0;
					dessert(new Point(r, c, 1), new boolean[N][N], new boolean[101]);
				}
			}

			System.out.println(Ans);

		}
	}

	private static void print(boolean[][] vmap) {
		for (int i = 0; i < vmap.length; i++) {
			for (int j = 0; j < vmap.length; j++) {
				System.out.print(vmap[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void dessert(Point p, boolean[][] vmap, boolean[] v) {
		v[map[p.r][p.c]] = true;
		vmap[p.r][p.c] = true;

		int nr = p.r + dr[0];
		int nc = p.c + dc[0];

		if (nr >= 0 && nc >= 0 && nr < N && nc < N && !vmap[nr][nc] && !v[map[nr][nc]]) {
			rcount++;
			dessert(new Point(nr, nc, p.cost + 1), vmap, v);
//			v[map[nr][nc]] = false;
//			vmap[nr][nc] = false;
//			rcount--;

		}

		print(vmap);
		System.out.println(p.cost);

//		if (rcount != 0) {
//			nr = p.r + dr[1];
//			nc = p.c + dc[1];
//
//			if (nr >= 0 && nc >= 0 && nr < N && nc < N && !vmap[nr][nc] && !v[map[nr][nc]]) {
//				ccount++;
//				dessert(new Point(nr, nc, p.cost + 1), vmap, v);
//				v[map[nr][nc]] = false;
//				vmap[nr][nc] = false;
//				ccount--;
//			}
//		}

		// 올라가는거만 하면 됨. rcount or count 가 1이상일 때만 돌리면 아마 될듯?
//		if (rcount >= 1 && ccount >= 1) {
//			for (int i = 1; i <= rcount; i++) {
//				nr = p.r + dr[2] * i;
//				nc = p.c + dc[2] * i;
//
//				if (nr >= 0 && nc >= 0 && nr < N && nc < N && !vmap[nr][nc] && !v[map[nr][nc]]) {
//					p.cost++;
//					v[map[nr][nc]] = true;
//					vmap[nr][nc] = true;
//
//				} else {
//					return;
//				}
//			}
//			
//			
//
//			for (int i = 1; i <= ccount; i++) {
//				nr = p.r + dr[3] * i;
//				nc = p.c + dc[3] * i;
//
//				if (nr >= 0 && nc >= 0 && nr < N && nc < N && !vmap[nr][nc] && !v[map[nr][nc]]) {
//					p.cost++;
//					v[map[nr][nc]] = true;
//					vmap[nr][nc] = true;
//
//				} else if (nr >= 0 && nc >= 0 && nr < N && nc < N && i == ccount && vmap[nr][nc]) {
//					
//					Ans = Math.max(Ans, p.cost);
//					return;
//				} else {
//					return;
//				}
//			}
//
//		}

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
