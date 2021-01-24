package baekjoon;

import java.util.*;
import java.io.*;

public class 프린터큐_1966 {

	static int T, N, M, arr[], ans;

	static class Point {
		int idx, pr;

		public Point(int idx, int pr) {
			this.idx = idx;
			this.pr = pr;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			ans = 0;

			arr = new int[N];
			Queue<Point> q = new LinkedList<>();

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				q.add(new Point(i, num));
				arr[i] = num;
			}

			// 알고리즘
			System.out.println(cal(q));

		}

	}

	private static int cal(Queue<Point> q) {
		int cnt = 1;

		Point p = null;
		L: while (!q.isEmpty()) {
			p = q.poll();

			int num = p.pr;
			for (int i = 0; i < arr.length; i++) {
				if (num < arr[i]) {
					q.add(p);
					continue L;
				}
			}
			if (p.idx == M) {
				return cnt;
			}
			cnt++;
			arr[p.idx] = -1;
		}

		return 0;

	}

}
