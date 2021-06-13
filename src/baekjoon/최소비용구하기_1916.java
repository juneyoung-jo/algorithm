package baekjoon;

import java.util.*;
import java.io.*;

public class 최소비용구하기_1916 {

	static int N, M, start, end, ans;
	static final int INF = Integer.MAX_VALUE;
	static ArrayList<Point>[] list;

	static class Point {
		int end, cost;

		public Point(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list[s].add(new Point(e, c));
		}

		st = new StringTokenizer(br.readLine(), " ");

		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		;
		System.out.println(cal(start, end));

	}

	public static int cal(int start, int end) {
		// 우선순위큐
		PriorityQueue<Point> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		// 방문배열
		boolean[] v = new boolean[N + 1];
		// dist배열
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		q.add(new Point(start, 0));

		Point p = null;
		while (!q.isEmpty()) {
			p = q.poll();
			if (v[p.end]) continue;
			v[p.end] = true;

			for (Point to : list[p.end]) {
				if (!v[to.end] && p.cost + to.cost < dist[to.end]) {
					dist[to.end] = p.cost + to.cost;
					q.add(new Point(to.end, dist[to.end]));
				}
			}
		}

		return dist[end];

	}

}
