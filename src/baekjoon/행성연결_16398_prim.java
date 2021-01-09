package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 행성연결_16398_prim {
	static int N, map[][];

	static class Point implements Comparable<Point> {
		int to;
		long cost;

		public Point(int start, long cost) {
			super();
			this.to = start;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Long.compare(this.cost, o.cost);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		long[] dist = new long[N];
		boolean[] v = new boolean[N];

		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		Arrays.fill(dist, Long.MAX_VALUE);

		dist[0] = 0;
		pq.add(new Point(0, dist[0]));
		int cnt = 0;

		Point current = null;
		while (!pq.isEmpty()) {
			current = pq.poll();
			if (v[current.to]) {
				continue;
			}
			cnt++;
			if (cnt == N) {
				break;
			}

			v[current.to] = true;
			for (int i = 0; i < N; i++) {
				if (map[current.to][i] == 0)
					continue;
				if (!v[i] && map[current.to][i] != 0 && map[current.to][i] < dist[i]) {
					dist[i] = map[current.to][i];
					pq.add(new Point(i, dist[i]));
				}
			}

		}

		long ans = 0;

		for (Long l : dist) {
			ans += l;
		}

		System.out.println(ans);

	}

}
