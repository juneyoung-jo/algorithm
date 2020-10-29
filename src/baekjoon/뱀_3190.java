package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 뱀_3190 {
	static int N, K, L, map[][];
	static int[] dr = { 0, 1, 0, -1 }; // 오 , 하, 왼, 상
	static int[] dc = { 1, 0, -1, 0 };
	static List<Point> list;
	static Queue<Point> plist;
	static boolean falg = true;

	static class Point {
		int time;
		String str;

		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public Point(int time, String str) {
			super();
			this.time = time;
			this.str = str;
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		map = new int[N][N];

		for (int i = 0; i < K; i++) {
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			map[r][c] = -1; // 사과
		}

		list = new ArrayList<Point>();
		plist = new LinkedList<Point>();
		L = sc.nextInt();
		for (int i = 0; i < L; i++) {
			list.add(new Point(sc.nextInt(), sc.next()));
		}

		cal(0, 0, 0, 0);

	}

	private static void cal(int idx, int dir, int r, int c) {

		if (!falg) return;
		map[r][c] = 1;
		plist.add(new Point(r, c));

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).time == idx) {
				dir = dircal(dir, list.get(i).str);
				break;
			}
		}

		int nr = r + dr[dir];
		int nc = c + dc[dir];

		if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 1) {
			System.out.println(idx + 1); // 결과 값
			falg = false;
			return;
		}

		if (map[nr][nc] == -1) {
			cal(idx + 1, dir, nr, nc);
			return;
		}

		if (!plist.isEmpty()) {
			Point p = plist.poll();
			map[p.r][p.c] = 0;
		}
		cal(idx + 1, dir, nr, nc);
	}

	// 방향 계산
	private static int dircal(int dir, String str) {

		if (dir == 0) {

			if (str.equals("D")) {
				return 1;
			} else {
				return 3;
			}
		} else if (dir == 1) {

			if (str.equals("D")) {
				return 2;
			} else {
				return 0;
			}

		} else if (dir == 2) {

			if (str.equals("D")) {
				return 3;
			} else {
				return 1;
			}

		} else {

			if (str.equals("D")) {
				return 0;
			} else {
				return 2;
			}

		}

	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}
}
