package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 경쟁적전염_18405 {
	static int n, k, map[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1, };
	static LinkedList<Point> list = new LinkedList<Point>();

	static class Point implements Comparable<Point> {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cnt, o.cnt);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		PriorityQueue<Point> q = new PriorityQueue<Point>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0)
					q.add(new Point(i, j, map[i][j]));
			}
		}

		st = new StringTokenizer(br.readLine());
		int[] Ans = new int[3];
		for (int i = 0; i < Ans.length; i++) {
			Ans[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = Ans[0];
		while (--cnt >= 0) {
			while (!q.isEmpty()) {
				Point p = q.poll();
				for (int j = 0; j < 4; j++) {
					int nr = p.r + dr[j];
					int nc = p.c + dc[j];

					if (nr < 0 || nc < 0 || nr >= n || nc >= n)
						continue;
					if (map[nr][nc] != 0)
						continue;
					map[nr][nc] = p.cnt;
					list.add(new Point(nr, nc, p.cnt));
				}

			}

			q.addAll(list);
			list.clear();
		}

//		print(map);

		System.out.println(map[Ans[1] - 1][Ans[2] - 1]);

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
