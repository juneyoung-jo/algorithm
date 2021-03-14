package baekjoon;

import java.util.*;
import java.io.*;

public class 거의최단경로_5719 {

	static int N, M, S, D, dist[], pList[];
	static PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
	static List<Point>[] list, RList;
	static boolean[] v;

	static class Point {
		int to, cnt;

		public Point(int to, int cnt) {
			this.to = to;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0)
				break;
			st = new StringTokenizer(br.readLine(), " ");
			S = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			list = new ArrayList[N]; // 가는 방향
			RList = new ArrayList[N]; // 가는 방향의 반대 (추적하기위해)

			for (int i = 0; i < N; i++) {
				list[i] = new ArrayList<>();
				RList[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());

				list[from].add(new Point(to, cnt));
				RList[to].add(new Point(from, cnt));
			}

			// 알고리즘
			// 다익스트라 (최단거리)
			dijk();

			// 최적 경로 찾아내서 지우기.
			cal(D);

			// 거의 최단경로 찾기.
			dijk();

			System.out.println(dist[D] == Integer.MAX_VALUE ? "-1" : dist[D]);

		}
	}

	private static void dijk() {
		v = new boolean[N];
		dist = new int[N];
		pList = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE); // 최단 거리
		Arrays.fill(pList, -1); // 최단 거리로 이동하는 노드

		pq.clear();
		dist[S] = 0;
		pq.add(new Point(S, dist[S]));
		Point p = null;
		while (!pq.isEmpty()) {
			p = pq.poll();

			if (v[p.to])
				continue;
			v[p.to] = true;

			int size = list[p.to].size();

			for (int i = 0; i < size; i++) {
				int to = list[p.to].get(i).to;
				int cnt = list[p.to].get(i).cnt;

				if (!v[to] && p.cnt + cnt < dist[to]) {
					dist[to] = p.cnt + cnt;
					pList[to] = p.to;
					pq.add(new Point(to, dist[to]));

				}
			}

		}

	}

	private static void cal(int d) {
		// 해당 노드에서 최단 거리로 연결되는 간선을 지움(재귀)
		Point p = null;
		for (int i = 0; i < RList[d].size(); i++) {
			p = RList[d].get(i);
			if (p.cnt + dist[p.to] == dist[d]) {
				for (int j = 0; j < list[p.to].size(); j++) {
					if (list[p.to].get(j).to == d) {
						list[p.to].remove(j);
						cal(p.to);
						j--;
					}

				}
			}
		}
	}

}
