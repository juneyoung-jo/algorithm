package baekjoon;

import java.util.*;
import java.io.*;

public class KCMTravel_10217 {
	static int T, N, M, K, cost[][], ans;
	static List<Point>[] list;
	static PriorityQueue<Point> q = new PriorityQueue<>();
	static final int inf = Integer.MAX_VALUE;

	static class Point implements Comparable<Point> {
		int e, c, d;

		public Point(int e, int c, int d) {
			this.e = e;
			this.c = c;
			this.d = d;
		}

		@Override
		public int compareTo(Point o) {
			if (this.d == o.d) return this.c - o.c;
			return this.d - o.d;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;

			list = new ArrayList[N + 1];
			cost = new int[N + 1][M + 1];

			for (int i = 0; i <= N; i++) {
				list[i] = new ArrayList<>();
				Arrays.fill(cost[i], inf);
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());

				list[u].add(new Point(v, c, d));
			}

			cal();
			System.out.println(ans == inf ? "Poor KCM" : ans);
		}

	}

	private static void cal() {
		q.clear();
		cost[1][0] = 0;
		q.add(new Point(1, 0, 0));
		Point p = null;
		while (!q.isEmpty()) {
			p = q.poll();

			if (p.e == N) {
				ans = Math.min(ans, p.d);
				return;
			}

			for (Point node : list[p.e]) {
				if (p.c + node.c <= M && p.d + node.d < cost[node.e][p.c + node.c]) {
					cost[node.e][p.c + node.c] = p.d + node.d;
					q.add(new Point(node.e, p.c + node.c, p.d + node.d));
				}
			}
		}
	}

}
