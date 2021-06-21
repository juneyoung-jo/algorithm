package baekjoon;

import java.util.*;
import java.io.*;

public class 돌그룹BFS_12886 {

	static int A, B, C, ans;
	static boolean[][] v;

	static class Point {
		int a, b, c;

		public Point(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		v = new boolean[1501][1501];

		if ((A + B + C) % 3 != 0) System.out.println(0);
		else System.out.println(cal());
	}

	public static int cal() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(A, B, C));
		Point p = null;
		while (!q.isEmpty()) {
			p = q.poll();

			if (p.a == p.b && p.b == p.c) return 1;
			if (p.a != p.b) {
				if (!v[Math.max(p.a, p.b) - Math.min(p.a, p.b)][Math.min(p.a, p.b) * 2]) {
					v[Math.max(p.a, p.b) - Math.min(p.a, p.b)][Math.min(p.a, p.b) * 2] = true;
					q.add(new Point(Math.max(p.a, p.b) - Math.min(p.a, p.b), Math.min(p.a, p.b) * 2, p.c));
				}
			}
			if (p.a != p.c) {
				if (!v[Math.max(p.a, p.c) - Math.min(p.a, p.c)][Math.min(p.a, p.c) * 2]) {
					v[Math.max(p.a, p.c) - Math.min(p.a, p.c)][Math.min(p.a, p.c) * 2] = true;
					q.add(new Point(Math.max(p.a, p.c) - Math.min(p.a, p.c), Math.min(p.a, p.c) * 2, p.b));
				}
			}
		}

		return 0;
	}

}
