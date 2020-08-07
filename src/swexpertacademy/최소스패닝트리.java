package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

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

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			parents = new int[100001];
			ArrayList<Edge> edge = new ArrayList<Edge>();

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());

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
