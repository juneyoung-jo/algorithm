package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 특정한최단경로_1504 {
	static int N, E, ans;
	static boolean flag = false;

	static ArrayList<Point>[] list;

	static class Point implements Comparable<Point> {
		int to, from, cnt;

		public Point(int to, int from, int cnt) {
			super();
			this.to = to;
			this.from = from;
			this.cnt = cnt;
		}

		public Point(int from, int cnt) {
			super();
			this.from = from;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.cnt - o.cnt;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int v1 = 0;
		int v2 = 0;

		list = new ArrayList[N + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Point>();
		}

		int to, from, cnt;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			to = Integer.parseInt(st.nextToken());
			from = Integer.parseInt(st.nextToken());
			cnt = Integer.parseInt(st.nextToken());

			list[to].add(new Point(from, cnt));
			list[from].add(new Point(to, cnt));
		}
		st = new StringTokenizer(br.readLine(), " ");
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());

		/**
		 * 시작점, 끝점
		 */

		int case1 = cal(1, v1) + cal(v1, v2) + cal(v2, N);
		int case2 = cal(1, v2) + cal(v2, v1) + cal(v1, N);
		
		if (!flag)
			System.out.println(case1 < case2 ? case1 : case2);
		else
			System.out.println("-1");

	}

	private static int cal(int start, int end) {
		boolean[] v = new boolean[N + 1];
		int[] cost = new int[N + 1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[start] = 0;

		PriorityQueue<Point> q = new PriorityQueue<Point>();
		q.add(new Point(start, 0));

		Point p = null;
		while (!q.isEmpty()) {
			p = q.poll();
			if (v[p.from])
				continue;
			v[p.from] = true;

			int size = list[p.from].size();

			for (int i = 0; i < size; i++) {

				if (!v[list[p.from].get(i).from] && list[p.from].get(i).cnt + p.cnt < cost[list[p.from].get(i).from]) {
					cost[list[p.from].get(i).from] = list[p.from].get(i).cnt + p.cnt;
					q.add(new Point(list[p.from].get(i).from, cost[list[p.from].get(i).from]));
				}

			}

		}
		if (cost[end] == Integer.MAX_VALUE) flag = true;
		return cost[end];

	}

}
