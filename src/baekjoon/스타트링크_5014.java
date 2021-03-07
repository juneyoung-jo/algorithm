package baekjoon;

import java.util.*;
import java.io.*;

public class 스타트링크_5014 {
	static int F, S, G, U, D, ans;
	static boolean[] v;
	static int[] dr;

	static class Point {
		int start, cnt, state;

		public Point(int start, int cnt, int state) {
			this.start = start;
			this.cnt = cnt;
			this.state = state;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		F = Integer.parseInt(st.nextToken()); // 전체 층
		S = Integer.parseInt(st.nextToken()); // 현재 층
		G = Integer.parseInt(st.nextToken()); // 도착 층
		U = Integer.parseInt(st.nextToken()); // 위
		D = Integer.parseInt(st.nextToken()); // 아래

		ans = Integer.MAX_VALUE;

		dr = new int[2];
		dr[0] = U;
		dr[1] = -D;

		v = new boolean[F + 1];
		cal();

		System.out.println(ans == Integer.MAX_VALUE ? "use the stairs" : ans);

	}

	private static void cal() {
		Queue<Point> q = new LinkedList<>();
		v[S] = true;
		q.add(new Point(S, 0, 1));

		Point p = null;
		while (!q.isEmpty()) {
			p = q.poll();

			if (p.start == G) {
				ans = p.cnt;
				break;
			}

			for (int k = 0; k < 2; k++) {
				int r = p.start + dr[k];

				if (r <= 0 || r > F || v[r]) continue;

				v[r] = true;
				q.add(new Point(r, p.cnt + 1, 0));

			}
		}

	}

}
