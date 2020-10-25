package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 마법사상어와파이어볼_20056 {
	static int N, M, K, map[][][], ans;
	static int dr[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dc[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static List<Point> list;

	static class Point {
		int r, c, m, s, d;

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", m=" + m + ", s=" + s + ", d=" + d + "]";
		}

		public Point(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		list = new ArrayList<Point>();

		for (int i = 0; i < M; i++) {
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			int m = sc.nextInt();
			int s = sc.nextInt();
			int d = sc.nextInt();

			list.add(new Point(r, c, m, s, d));
		}

		cal(0);

		System.out.println(ans);
	}

	private static void cal(int idx) {
		if (idx == K) {
			for (Point p : list) {
				ans += p.m;
			}

			return;
		}

		// [0] = 질량 m
		// [1] = 속력 s
		// [2] = 방향 d
		// [3] = 개수
		map = new int[N][N][4];
		for (int i = 0; i < list.size(); i++) {
			Point p = list.get(i);

			// 방향
			int nr = p.r + dr[p.d] * (p.s % N);
			int nc = p.c + dc[p.d] * (p.s % N);

			if (nr < 0 || nr >= N) nr = (nr+N) %N;
			if (nc < 0 || nc >= N) nc = (nc+N) %N;

			map[nr][nc][3] += 1;
			map[nr][nc][0] += p.m;
			map[nr][nc][1] += p.s;
			if (map[nr][nc][3] == 1) {
				map[nr][nc][2] += p.d;
			} else {
				if (map[nr][nc][2] == Integer.MAX_VALUE)
					continue;
				if (map[nr][nc][2] % 2 != p.d % 2) {
					map[nr][nc][2] = Integer.MAX_VALUE;
				}
			}
		}

		// 리스트 초기화
		list.clear();

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c][3] == 0)
					continue;
				if (map[r][c][3] == 1) { // 1개일 떄,
					list.add(new Point(r, c, map[r][c][0], map[r][c][1], map[r][c][2]));
				} else {
					if (map[r][c][0] / 5 == 0)
						continue;
					int row = r;
					int col = c;
					int m = map[r][c][0] / 5;
					int s = map[r][c][1] / map[r][c][3];

					if (map[r][c][2] != Integer.MAX_VALUE) { // 모두 짝수이거나 홀수
						list.add(new Point(row, col, m, s, 0));
						list.add(new Point(row, col, m, s, 2));
						list.add(new Point(row, col, m, s, 4));
						list.add(new Point(row, col, m, s, 6));
					} else {
						list.add(new Point(row, col, m, s, 1));
						list.add(new Point(row, col, m, s, 3));
						list.add(new Point(row, col, m, s, 5));
						list.add(new Point(row, col, m, s, 7));
					}

				}
			}

		}

		cal(idx + 1);
	}

}

