package baekjoon;

import java.util.*;
import java.io.*;

public class DSLR_9019 {
	static int T, A, B;
	static Queue<Point> q = new LinkedList<>();
	static boolean[] v;

	static class Point {
		int n;
		String s;

		public Point(int n, String s) {
			this.n = n;
			this.s = s;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			v = new boolean[10000];

			q.clear();
			v[D(A)] = true;
			v[S(A)] = true;
			v[L(A)] = true;
			v[R(A)] = true;
			q.add(new Point(D(A), "D"));
			q.add(new Point(S(A), "S"));
			q.add(new Point(L(A), "L"));
			q.add(new Point(R(A), "R"));
			System.out.println(cal());
		}

	}

	private static String cal() {
		Point p = null;
		while (!q.isEmpty()) {
			p = q.poll();
			if (p.n == B)
				return p.s;
			int num = p.n;
			if (!v[D(num)]) {
				v[D(num)] = true;
				q.add(new Point(D(num), p.s + "D"));
			}
			if (!v[S(num)]) {
				v[S(num)] = true;
				q.add(new Point(S(num), p.s + "S"));
			}
			if (!v[L(num)]) {
				v[L(num)] = true;
				q.add(new Point(L(num), p.s + "L"));
			}
			if (!v[R(num)]) {
				v[R(num)] = true;
				q.add(new Point(R(num), p.s + "R"));
			}
		}

		return null;
	}

	public static int D(int n) {
		return n * 2 % 10000;
	}

	public static int S(int n) {
		return n == 0 ? 9999 : n - 1;
	}

	public static int L(int n) {
		return n % 1000 * 10 + n / 1000;
	}

	public static int R(int n) {
		return n % 10 * 1000 + n / 10;
	}

}
