package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의부모찾기_11725 {

	static int N, ans[];
	static ArrayList<Integer>[] list;

	static class Point {
		int prev, start;
		
		

		public Point(int start) {
			super();
			this.start = start;
		}


		public Point(int start, int end) {
			super();
			this.prev = start;
			this.start = end;
		}

	}

	static Queue<Point> q;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		ans = new int[N+1];
		list = new ArrayList[N + 1];
		q = new LinkedList<Point>();

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		int start, end;
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());

			list[start].add(end);
			list[end].add(start);
		}

		bfs(1, new boolean[N + 1]);
		
		for (int i = 2; i <= N; i++) {
			System.out.println(ans[i]);
		}

	}

	private static void bfs(int idx, boolean[] v) {
		v[idx] = true;
		q.add(new Point(idx));

		Point p = null;
		while (!q.isEmpty()) {
			p = q.poll();

			ans[p.start] = p.prev;

			int size = list[p.start].size();
			for (int i = 0; i < size; i++) {

				if (v[list[p.start].get(i)])
					continue;
				v[list[p.start].get(i)] = true;
				q.add(new Point(p.start,list[p.start].get(i)));
			}
		}

	}

}
