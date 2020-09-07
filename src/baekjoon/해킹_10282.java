package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 해킹_10282 {
	static int T, n, d, c;

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

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			ArrayList<Point>[] list = new ArrayList[n + 1];// 1번부터 사용하기 위해서
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList<Point>();
			}

			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				list[to].add(new Point(from, cnt));
			}

			// 방향이 있는 다익스트라 문제

			int[] dis = new int[n + 1];
			boolean[] v = new boolean[n + 1];
			Arrays.fill(dis, Integer.MAX_VALUE);
			PriorityQueue<Point> pq = new PriorityQueue<Point>();

			dis[c] = 0;
			pq.add(new Point(c, dis[c]));
			Point current = null;
			while (!pq.isEmpty()) {
				current = pq.poll();

				v[current.to] = true;

				int size = list[current.to].size();
				for (int i = 0; i < size; i++) {

					int e = list[current.to].get(i).to;
					int cnt = list[current.to].get(i).cnt;

					if (!v[e] && cnt + dis[current.to] < dis[e]) {
						dis[e] = cnt + dis[current.to];
						pq.add(new Point(e, dis[e]));
					}

				}

			}
			int cnt = 0;
			int Ans = 0;
			Arrays.sort(dis);
			for (int i = 0; i < v.length - 1; i++) {
				if (dis[i] == Integer.MAX_VALUE)
					continue;
				cnt++;
				Ans = Math.max(Ans, dis[i]);
			}

			System.out.printf("%d %d\n", cnt, Ans);
//			System.out.println(Arrays.toString(dis));

		}
	}

}
