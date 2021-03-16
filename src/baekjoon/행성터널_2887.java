package baekjoon;

import java.util.*;
import java.io.*;

public class 행성터널_2887 {
	static int N, parent[];

	static class Point {
		int x, y, z, idx, from, to, cnt;

		public Point(int from, int to, int cnt) {
			super();
			this.from = from;
			this.to = to;
			this.cnt = cnt;
		}

		public Point(int x, int y, int z, int idx) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
			this.idx = idx;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parent = new int[N];

		List<Point> list = new ArrayList<>();
		List<Point> listX = new ArrayList<>();
		List<Point> listY = new ArrayList<>();
		List<Point> listZ = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			listX.add(new Point(x, y, z, i));
			listY.add(new Point(x, y, z, i));
			listZ.add(new Point(x, y, z, i));
		}

		listX.sort((o1, o2) -> o1.x - o2.x);
		listY.sort((o1, o2) -> o1.y - o2.y);
		listZ.sort((o1, o2) -> o1.z - o2.z);

		for (int i = 1; i < N; i++) {
			list.add(new Point(listX.get(i - 1).idx, listX.get(i).idx, Math.abs(listX.get(i - 1).x - listX.get(i).x)));
			list.add(new Point(listY.get(i - 1).idx, listY.get(i).idx, Math.abs(listY.get(i - 1).y - listY.get(i).y)));
			list.add(new Point(listZ.get(i - 1).idx, listZ.get(i).idx, Math.abs(listZ.get(i - 1).z - listZ.get(i).z)));
		}

		init();
		int ans = 0;
		int cnt = 0;
		list.sort((o1, o2) -> o1.cnt - o2.cnt);
		for (Point p : list) {
			if (cnt == N - 1)
				break;
			if (Union(p.from, p.to)) {
				cnt++;
				ans += p.cnt;
			}
		}

		System.out.println(ans);

	}

	private static boolean Union(int xx, int yy) {
		int x = find(xx);
		int y = find(yy);

		if (x == y)
			return false;
		parent[y] = x;
		return true;
	}

	private static int find(int xx) {
		if (xx == parent[xx])
			return parent[xx];
		return parent[xx] = find(parent[xx]);
	}

	private static void init() {
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}

	}

}
