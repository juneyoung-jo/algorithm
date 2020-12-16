package baekjoon;

import java.util.*;
import java.io.*;

public class 촌수계산_2644 {

	static int n, x, y, ans;
	static boolean[] v;
	static ArrayList<Integer>[] list;

	static class Point {
		int p, cnt;

		public Point(int p, int cnt) {
			super();
			this.p = p;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		ans = -1;

		int num = Integer.parseInt(br.readLine());

		list = new ArrayList[n + 1];
		v = new boolean[n + 1];

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}

		int start, end;
		for (int index = 0; index < num; index++) {
			st = new StringTokenizer(br.readLine(), " ");
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());

			list[start].add(end);
			list[end].add(start);
		}

		// 알고리즘
		bfs();

		System.out.println(ans);

	}

	private static void bfs() {
		Queue<Point> q = new LinkedList<Point>();
		v[x] = true;
		q.add(new Point(x, 0));

		Point person = null;
		while (!q.isEmpty()) {
			person = q.poll();

			if (person.p == y) {
				ans = person.cnt;
				break;
			}

			int size = list[person.p].size();
			for (int i = 0; i < size; i++) {

				if (v[list[person.p].get(i)])
					continue;
				v[list[person.p].get(i)] = true;
				q.add(new Point(list[person.p].get(i), person.cnt + 1));

			}

		}

	}

}
