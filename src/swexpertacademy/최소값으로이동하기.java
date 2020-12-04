package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최소값으로이동하기 {
	static int W, H, N, ans;
	static Point start;

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			ans = 0;

			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			start = new Point(r, c);

			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				r = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				cal(r, c);
			}

			System.out.printf("#%d %d\n", tc, ans);

		}

	}

	private static void cal(int r, int c) {
		int sr = start.r - r;
		int sc = start.c - c;

		// 둘다 양수
		if (sr >= 0 && sc >= 0) {
			ans += Math.min(sr, sc);
			start.r -= Math.min(sr, sc);
			start.c -= Math.min(sr, sc);

			ans += start.r - r;
			ans += start.c - c;
		} else if (sr < 0 && sc < 0) {
			ans += Math.max(sr, sc) * -1;
			start.r += Math.max(sr, sc) * -1;
			start.c += Math.max(sr, sc) * -1;

			ans += Math.abs(start.r - r);
			ans += Math.abs(start.c - c);
		} else {
			ans += Math.abs(start.r - r);
			ans += Math.abs(start.c - c);
		}

		start = new Point(r, c);

	}

}
