package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class 최소스패닝트리_1197_kruskal {
	static int V, E, parents[];

	static class Point implements Comparable<Point> {
		int from, to, cnt;

		public Point(int from, int to, int cnt) {
			super();
			this.from = from;
			this.to = to;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.cnt, o.cnt);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		ArrayList<Point> list = new ArrayList<Point>();

		parents = new int[V + 1];

		// 인접 리스트 만들기
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			list.add(new Point(from, to, cnt));
		}

		makeSet();
		Collections.sort(list);
		int Ans = 0;
		int v = 0;
		for (Point point : list) {
			if (v == V - 1)
				break;
			if (Union(point.from, point.to)) {
				Ans += point.cnt;
				v++;
			}
		}

		System.out.println(Ans);

	}

	private static boolean Union(int x, int y) {
		int xx = find(x);
		int yy = find(y);

		if (xx == yy)
			return false;
		parents[yy] = xx;
		return true;

	}

	private static void makeSet() {
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
	}

	private static int find(int x) {
		if (x == parents[x]) {
			return x;
		}
		return parents[x] = find(parents[x]);
	}

}
