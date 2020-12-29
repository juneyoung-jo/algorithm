package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 연구소3_17142 {

	static int N, M, map[][], ans = Integer.MAX_VALUE;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static boolean v[];
	static ArrayList<Point> virus, s_virus;
	static PriorityQueue<Point> q = new PriorityQueue<Point>();

	static class Point implements Comparable<Point> {
		int r, c, time;

		public Point(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.time, o.time);
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		virus = new ArrayList<Point>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					virus.add(new Point(i, j, 1));
			}
		}

		v = new boolean[virus.size()];
		// 알고리즘
		combination(0, 0);

		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

	}

	private static void combination(int idx, int start) {
		if (idx == M) {
			bfs(v);
			return;
		}

		for (int i = start; i < virus.size(); i++) {
			v[i] = true;
			combination(idx + 1, i + 1);
			v[i] = false;
		}
	}

	private static void bfs(boolean[] v) {
		q.clear();
		Point p = null;
		boolean check[][] = new boolean[N][N];
		int[][] nMap = new int[N][N];
		for (int i = 0; i < v.length; i++) {
			if (v[i]) {
				p = virus.get(i);
				check[p.r][p.c] = true;
				q.add(new Point(p.r, p.c, p.time));
			}
		}

		Point virus = null;
		int max = 0;
		while (!q.isEmpty()) {
			virus = q.poll();

			if (max > ans)
				return;

			for (int k = 0; k < 4; k++) {
				int nr = virus.r + dr[k];
				int nc = virus.c + dc[k];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N || check[nr][nc])
					continue;
				if (map[nr][nc] == 1) continue; // 벽일 경우
				if (map[nr][nc] == 2) {
					check[nr][nc] = true;
					q.add(new Point(nr, nc, virus.time+1));
					continue;
				}
				

				nMap[nr][nc] = virus.time;
				if (max < virus.time)
					max = virus.time;
				check[nr][nc] = true;
				q.add(new Point(nr, nc, virus.time + 1));
			}

		}
		for (int i = 0; i < nMap.length; i++) {
			for (int j = 0; j < nMap.length; j++) {
				if (map[i][j] == 0 && nMap[i][j] == 0)
					return;
			}
		}
		ans = max;

	}

}
