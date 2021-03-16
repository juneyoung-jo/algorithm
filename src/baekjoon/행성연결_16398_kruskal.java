package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 행성연결_16398_kruskal {
	static int N, parents[];

	static class Point implements Comparable<Point> {

		int s, e, c;

		public Point(int e, int c) {
			super();
			this.e = e;
			this.c = c;
		}

		public Point(int s, int e, int c) {
			super();
			this.s = s;
			this.e = e;
			this.c = c;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.c, o.c);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ArrayList<Point> list = new ArrayList<Point>();
		parents = new int[N];
		boolean[][] v = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (v[i][j] || v[j][i])
					continue;
				if (num == 0)
					continue;
				v[i][j] = true;
				list.add(new Point(i, j, num));
			}
		}

		makeSet(parents);

		Collections.sort(list);
		int cnt = 0;
		long ans = 0;
		for (Point p : list) {
			if (cnt == N - 1)
				break;
			if (union(p.s, p.e))
				continue;
			ans += p.c;
			cnt++;
		}

		System.out.println(ans);

	}

	private static boolean union(int xx, int yy) {
		int x = find(xx);
		int y = find(yy);

		if (x == y)
			return true;
		else {
			parents[y] = x;
			return false;
		}
	}

	private static int find(int x) {
		if (parents[x] == x)
			return x;
		else
			return parents[x] = find(parents[x]);
	}

	private static void makeSet(int[] parents) {
		for (int j = 0; j < parents.length; j++) {
			parents[j] = j;
		}
	}

}
