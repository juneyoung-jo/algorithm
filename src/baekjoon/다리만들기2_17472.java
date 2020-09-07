package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 다리만들기2_17472 {
	static int N, M, map[][], index = 2, parents[];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static ArrayList<Point> list;

	static class Point implements Comparable<Point> {
		int from, to, cnt;

		public Point(int from, int to, int cnt) {
			super();
			this.from = from;
			this.to = to;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [from=" + from + ", to=" + to + ", cnt=" + cnt + "]";
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cnt, o.cnt);
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		list = new ArrayList<Point>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 1) {
					map[r][c] = index;
					dfs(r, c);
					index++;
				}
			}
		}

		parents = new int[index];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 0)
					continue;
				// 해당 좌표에서 상하좌우로 움직이면서 연결 할 수 있는 지점 찾기
				check(r, c);
			}
		}

		Collections.sort(list);
		makeSet();

		int Ans = 0;
		int e = 0;

		for (Point lists : list) {
			if (e == index - 3)
				break;
			if (union(lists.from, lists.to)) {
				e++;
				Ans += lists.cnt;
			}
		}

		if (e == index - 3) {
			System.out.println(Ans);
		} else {
			System.out.println("-1");
		}

//		print(map);
//		System.out.println(e);
//		System.out.println(index);
//		System.out.println(Ans);
//		System.out.println(list.size());

	}

	private static boolean union(int x, int y) {
		int xx = find(x);
		int yy = find(y);

		if (xx == yy)
			return false;
		parents[yy] = xx;
		return true;
	}

	private static int find(int x) {
		if (x == parents[x])
			return x;
		return parents[x] = find(parents[x]);

	}

	private static void makeSet() {
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}

	}

	private static void check(int r, int c) {

		// 상
		cal(0, r, c);
		// 하
		cal(1, r, c);
		// 좌
		cal(2, r, c);
		// 우
		cal(3, r, c);

	}

	private static void cal(int i, int r, int c) {
		int count = 0;
		int nr = r;
		int nc = c;
		while (true) {
			nr += dr[i];
			nc += dc[i];

			if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == map[r][c])
				break;
			count++;
			if (map[nr][nc] != 0) {
				if (count > 2) {
					list.add(new Point(map[r][c], map[nr][nc], count - 1));

				}
				break;
			}

		}

	}

	private static void dfs(int r, int c) {

		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];

			if (nr < 0 || nc < 0 || nr >= N || nc >= M)
				continue;
			if (map[nr][nc] == 1) {
				map[nr][nc] = index;
				dfs(nr, nc);
			}
		}

	}

	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
