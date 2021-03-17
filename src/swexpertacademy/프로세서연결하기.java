package swexpertacademy;
import java.util.*;
import java.io.*;

public class 프로세서연결하기 {
	static int T, N, map[][], ans, ansCnt;
	static ArrayList<Point> list;
	static boolean[][] v;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ans = Integer.MAX_VALUE;
			ansCnt = 0;

			list = new ArrayList<Point>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1 && i != 0 && i != N - 1 && j != 0 && j != N - 1) {
						list.add(new Point(i, j));
					}
				}

			}

			// 알고리즘
			v = new boolean[N][N];
			cal(0, 0, 0);
			System.out.printf("#%d %d\n", tc, ans);
		}

	}

	public static void cal(int idx, int cnt, int ccnt) {

		if (ansCnt < ccnt) {
			ansCnt = ccnt;
			ans = cnt;
		} else if (ansCnt == ccnt) {
			ans = Math.min(ans, cnt);
		}

		if (idx == list.size()) {
			return;
		}

		Point p = list.get(idx);
		for (int k = 0; k < 4; k++) {
			int nr = p.r;
			int nc = p.c;

			while (true) {
				nr += dr[k];
				nc += dc[k];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
					cal(idx + 1, cnt, ccnt + 1);
					cnt -= back(k, idx, nr, nc, v);
					break;
				}

				if (map[nr][nc] == 1 || v[nr][nc]) {
					cnt -= back(k, idx, nr, nc, v);
					break;
				}

				v[nr][nc] = true;
				cnt++;
			}

		}

		cal(idx + 1, cnt, ccnt);

	}

	public static int back(int k, int idx, int nr, int nc, boolean[][] v) {

		int cnt = 0;
		// 돌아가야할 위치
		Point p = list.get(idx);

		// 현재 위치
		nr -= dr[k];
		nc -= dc[k];
		while (true) {
			if (p.r == nr && p.c == nc)
				break;
			v[nr][nc] = false;
			cnt++;
			nr -= dr[k];
			nc -= dc[k];
		}

		return cnt;
	}

	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();

		}

	}

}
