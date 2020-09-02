package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로_1753 {
	static int V, E, start;
	static ArrayList<Point>[] list;

	static class Point implements Comparable<Point> {
		int to, cnt;

		public Point(int to, int cnt) {
			super();
			this.to = to;
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
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());

		list = new ArrayList[V + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Point>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			list[from].add(new Point(to, cnt));
		}

		int[] dis = new int[V + 1];
		boolean[] v = new boolean[V + 1];
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[start] = 0;

		pq.add(new Point(start, dis[start]));
		Point current = null;
		while (!pq.isEmpty()) {
			current = pq.poll();

			v[current.to] = true;
			int size = list[current.to].size();
			for (int i = 0; i < size; i++) {
				if (!v[list[current.to].get(i).to]
						&& current.cnt + list[current.to].get(i).cnt < dis[list[current.to].get(i).to]) {
					dis[list[current.to].get(i).to] = current.cnt + list[current.to].get(i).cnt;
					pq.add(new Point(list[current.to].get(i).to, dis[list[current.to].get(i).to]));
				}
			}

		}
		for (int i = 1; i < dis.length; i++) {
			System.out.println(dis[i] == Integer.MAX_VALUE ? "INF" : dis[i]);
		}

	}

}
