package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 구슬탈출2_13460 {

	static int N, M, Hr, Hc;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static char map[][];
	static boolean v[][][][];

	static class Point {
		int Rr, Rc, Br, Bc, cnt;

		public Point(int rr, int rc, int br, int bc, int cnt) {
			super();
			Rr = rr;
			Rc = rc;
			Br = br;
			Bc = bc;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][];
		v = new boolean[N][M][N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int Rr = 0, Rc = 0, Br = 0, Bc = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 'R') {
					Rr = i;
					Rc = j;
				} else if (map[i][j] == 'B') {
					Br = i;
					Bc = j;
				} else if (map[i][j] == 'O') {
					Hr = i;
					Hc = j;
				}
			}
		}

		System.out.println(bfs(Rr, Rc, Br, Bc));

	}

	private static int bfs(int rr, int rc, int br, int bc) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(rr, rc, br, bc, 1));

		Point p = null;
		while (!q.isEmpty()) {
			p = q.poll();

			if (v[p.Rr][p.Rc][p.Br][p.Bc])
				continue;
			v[p.Rr][p.Rc][p.Br][p.Bc] = true;
			if (p.cnt == 11)
				continue;

			for (int k = 0; k < 4; k++) {

				if (p.Rr + dr[k] == p.Br && p.Rc + dc[k] == p.Bc) {
					int Rnr = p.Rr;
					int Rnc = p.Rc;
					int Bnr = p.Br;
					int Bnc = p.Bc;
					boolean B = false;
					boolean R = false;
					boolean b = true;
					boolean r = true;
					while (b || r) {
						Rnr += dr[k];
						Rnc += dc[k];
						Bnr += dr[k];
						Bnc += dc[k];

						if (map[Bnr][Bnc] == 'O') {
							B = true;
						}

						if (map[Bnr][Bnc] == '#' || (Bnr == Rnr - dr[k] && Bnc == Rnc - dr[k])) {
							Bnr -= dr[k];
							Bnc -= dc[k];
							b = false;
						}

						if (map[Rnr][Rnc] == 'O') {
							R = true;
						}

						if (map[Rnr][Rnc] == '#' || (Rnr == Bnr && Rnc == Bnc)) {
							Rnr -= dr[k];
							Rnc -= dc[k];
							r = false;
						}

					}
					if (R && !B) {
						return p.cnt;
					}
					if (!R && !B) {
						q.add(new Point(Rnr, Rnc, Bnr, Bnc, p.cnt + 1));
					}
				} else {
					// 아닐 떄
					int Rnr = p.Rr;
					int Rnc = p.Rc;
					int Bnr = p.Br;
					int Bnc = p.Bc;
					boolean B = false;
					boolean R = false;
					boolean b = true;
					boolean r = true;
					while (b || r) {
						Rnr += dr[k];
						Rnc += dc[k];
						Bnr += dr[k];
						Bnc += dc[k];

						if (map[Rnr][Rnc] == 'O') {
							R = true;
						}

						if (map[Rnr][Rnc] == '#' || (Rnr == Bnr - dr[k] && Rnc == Bnc - dc[k])) {
							Rnr -= dr[k];
							Rnc -= dc[k];
							r = false;
						}

						if (map[Bnr][Bnc] == 'O') {
							B = true;
						}

						if (map[Bnr][Bnc] == '#' || (Bnr == Rnr && Bnc == Rnc)) {
							Bnr -= dr[k];
							Bnc -= dc[k];
							b = false;
						}

					}
					if (R && !B) {
						return p.cnt;
					}
					if (!R && !B) {
						q.add(new Point(Rnr, Rnc, Bnr, Bnc, p.cnt + 1));
					}

				}

			}

		}

		return -1;

	}

}
