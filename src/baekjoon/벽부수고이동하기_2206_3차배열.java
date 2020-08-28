package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기_2206_3차배열 {
	static int N, M, map[][], Ans = Integer.MAX_VALUE;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static boolean[][][] v;

	static class Point {
		int r, c, cnt, bk;

		public Point(int r, int c, int cnt, int bk) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.bk = bk;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		v = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		bfs(new Point(0, 0, 1, 0));

		System.out.println(Ans == Integer.MAX_VALUE ? -1 : Ans);

	}

	private static void bfs(Point point) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(point);
		v[point.r][point.c][0] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (p.r == N - 1 && p.c == M - 1) {
				Ans = p.cnt;
				return;
			}

			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];

				// 테두리 체크
				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				// 왔던 길 체크 p.bk인 이유는 벽을 부수고 그다음 방문했던 길은
				// 벽을 안부시고 가는 경우에는 중복으로 갈 수 있기 때문에
				// bk가 0일때와 bk가 1일때의 길을 다르게 방문체크 해야 함.
				if (v[nr][nc][p.bk])
					continue;

				if (map[nr][nc] == 0) {
					v[nr][nc][p.bk] = true;
					q.add(new Point(nr, nc, p.cnt + 1, p.bk));
				} else {
					if (p.bk == 0) {
						v[nr][nc][1] = true;
						q.add(new Point(nr, nc, p.cnt + 1, p.bk + 1));
					}
				}
			}

		}

	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
