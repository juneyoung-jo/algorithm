package swexpertacademy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 최소스패닝트리 {
	static int T, V, E, parents[];

	static class Edge implements Comparable<Edge> {
		int a, b, c;

		public Edge(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.c, o.c);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			V = sc.nextInt();
			E = sc.nextInt();
			parents = new int[100001];
			ArrayList<Edge> edge = new ArrayList<Edge>();

			for (int i = 0; i < E; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				int cost = sc.nextInt();

				edge.add(new Edge(from, to, cost));
			}

			make(parents);
			Collections.sort(edge);

			long cost = 0;
			int cnt = 0;
			for (Edge edg : edge) {
				if (union(edg.a, edg.b)) {
					cost += edg.c;
					if (++cnt == V - 1) {
						break;
					}
				}
			}

			System.out.printf("#%d %d\n", tc, cost);
		}

	}

	private static void make(int[] parents) {
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}

	}

	private static int find(int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = find(parents[x]);
	}

	private static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);

		if (px == py)
			return false;

		parents[py] = px;
		return true;
	}

}
