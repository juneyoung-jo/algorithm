package baekjoon;

import java.util.*;
import java.io.*;

public class K번째최단경로찾기_1854 {
	static int n, m, k, dist[][];
	static ArrayList<Point>[] list;
	static PriorityQueue<Integer>[] ans;
	static final int INF = Integer.MAX_VALUE;

	static class Point {
		int end, cost;

		public Point(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		list = new ArrayList[n + 1];
		ans = new PriorityQueue[n + 1];
		dist = new int[k + 1][n + 1];

		for (int i = 1; i <= k; i++) {
			Arrays.fill(dist[i], INF);
		}

		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
			ans[i] = new PriorityQueue<>((o1, o2) -> o2 - o1);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list[s].add(new Point(e, c));
		}

		ans[1].add(0);
		cal(1);
		for (int i = 1; i <= n; i++) {
			if (ans[i].size() == k) System.out.println(ans[i].poll());
			else System.out.println(-1);
		}

	}

	private static void cal(int start) {
		PriorityQueue<Point> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		q.add(new Point(start, 0));
		Point p = null;
		while (!q.isEmpty()) {
			p = q.poll();

			for (Point to : list[p.end]) {
				if (ans[to.end].size() < k) {
					ans[to.end].add((p.cost + to.cost));
					q.add(new Point(to.end, p.cost + to.cost));
				} else if (ans[to.end].peek() > p.cost + to.cost) {
					ans[to.end].poll();
					ans[to.end].add((p.cost + to.cost));
					q.add(new Point(to.end, p.cost + to.cost));
				}
			}
		}
	}

}
