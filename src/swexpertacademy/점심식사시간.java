package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 점심식사시간 {
	static int T, N, ans, map[][];
	static List<Point> manlist;
	static List<Point> holelist;
	static boolean[] v;

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			ans = Integer.MAX_VALUE;
			StringTokenizer st = null;
			manlist = new ArrayList<Point>();
			holelist = new ArrayList<Point>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						manlist.add(new Point(i, j));
					} else if (map[i][j] > 1) {
						holelist.add(new Point(i, j, map[i][j]));
					}
				}
			}
			v = new boolean[manlist.size()];

			// 구현.
			// 부분집합을 구해야 함.
			powerSet(0);
			System.out.printf("#%d %d\n", tc, ans);

//			 print(map);

		}

	}

	private static void powerSet(int idx) {
		if (idx == manlist.size()) {
			// true인거 A hole
			int numA = calA(v, 0);
			// false인거 B hole
			int numB = calB(v, 1);
			int cnt = Math.max(numA, numB);
			ans = Math.min(ans, cnt);
			return;
		}

		v[idx] = true;
		powerSet(idx + 1);
		v[idx] = false;
		powerSet(idx + 1);

	}
	
	private static int calB(boolean[] v, int idx) {
		int[] time = new int[manlist.size()];
		Arrays.fill(time, -1);

		for (int i = 0; i < v.length; i++) {
			if (!v[i]) {
				time[i] = Math.abs(manlist.get(i).r - holelist.get(idx).r)
						+ Math.abs(manlist.get(i).c - holelist.get(idx).c);
			}
		}

		Arrays.sort(time);
		int start = -1;
		int end = -1;
		for (int i = 0; i < time.length; i++) {
			if (time[i] > -1) {
				start = i;
				break;
			}
		}
		for (int i = 0; i < time.length; i++) {
			if (time[i] > -1) {
				end = i;
			}
		}
		if (start == -1 || end == -1) {
			return 0;
		}
		int n = 0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = start; i <= end; i++) {
			if (q.size() < 3) {
				q.add(time[i] + holelist.get(idx).cnt);
			} else {
				n = q.poll();
				if (n > time[i]) {
					q.add(n + holelist.get(idx).cnt);
				} else {
					q.add(time[i] + holelist.get(idx).cnt);
				}

			}
		}

		while (!q.isEmpty()) {
			n = q.poll();
		}
		return n +1;

	}

	private static int calA(boolean[] v, int idx) {
		int[] time = new int[manlist.size()];
		Arrays.fill(time, -1);

		for (int i = 0; i < v.length; i++) {
			if (v[i]) {
				time[i] = Math.abs(manlist.get(i).r - holelist.get(idx).r)
						+ Math.abs(manlist.get(i).c - holelist.get(idx).c);
			}
		}

		Arrays.sort(time);
		int start = -1;
		int end = -1;
		for (int i = 0; i < time.length; i++) {
			if (time[i] > -1) {
				start = i;
				break;
			}
		}
		for (int i = 0; i < time.length; i++) {
			if (time[i] > -1) {
				end = i;
			}
		}
		if (start == -1 || end == -1) {
			return 0;
		}
		int n = 0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = start; i <= end; i++) {
			if (q.size() < 3) {
				q.add(time[i] + holelist.get(idx).cnt);
			} else {
				n = q.poll();
				if (n > time[i]) {
					q.add(n + holelist.get(idx).cnt);
				} else {
					q.add(time[i] + holelist.get(idx).cnt);
				}

			}
		}

		while (!q.isEmpty()) {
			n = q.poll();
		}
		return n +1;

	}

	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

}

