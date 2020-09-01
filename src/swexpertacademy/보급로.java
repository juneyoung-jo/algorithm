package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 보급로 {
	static int T, N, map[][], Ans = Integer.MAX_VALUE;
	static boolean[][] v;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point implements Comparable<Point> {
		int r;
		int c;
		int cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			return this.cnt - o.cnt;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			v = new boolean[N][N];

			for (int i = 0; i < map.length; i++) {
				String str = br.readLine();
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			// 알고리즘
			// dfs는 100x100이라 불가능 할듯
			// bfs로 풀어야 하는데 최단거리가 아닌 값이 가장 작은 수를 구해야 함.
			// 값을 더해가면서 저장하는데 값이 가장 작은 것부터 계속 더해 나가야 하기 때문에
			// 우선순위 큐를 사용하여 더한 값이 작은 순으로 실행.
			// 결론에 도달했을 때는 가장 작은 값이 저장 됨.
			bfs(new Point(0, 0, 0));
//			print(map);

			System.out.printf("#%d %d\n", tc, Ans);
			Ans = Integer.MAX_VALUE;

		}

	}

	private static void bfs(Point point) {
		PriorityQueue<Point> q = new PriorityQueue<Point>();
		q.add(point);
		v[point.r][point.c] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (p.r == N - 1 && p.c == N - 1) {

				Ans = Math.min(Ans, p.cnt);
				return;
			}

			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N) // 테두리 체크
					continue;
				if (v[nr][nc]) // 방문 배열 체크
					continue;

				if (map[nr][nc] == 0) { // 0일때를 먼저 넣고 실행해야 값이 가장 적은 것임.
					q.add(new Point(nr, nc, p.cnt + map[nr][nc]));
					v[nr][nc] = true;

				}

				if (map[nr][nc] != 0) { // 0이 아닐때는 그냥 다 넣어줌
					q.add(new Point(nr, nc, p.cnt + map[nr][nc]));
					v[nr][nc] = true;

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
