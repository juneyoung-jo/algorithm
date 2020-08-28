package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 색종이붙이기_17137_1 {
	static int map[][] = new int[10][10];
	static boolean[][][] v = new boolean[10][10][5];
	static int Ans = Integer.MAX_VALUE;
	static int[] dr = { 0, 1, 1 };
	static int[] dc = { 1, 1, 0 };

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 1) {
					dfs(new Point(i, j, 1));

				}
			}
		}

//		print(map);
		System.out.println(Ans == Integer.MAX_VALUE ? "-1" : Ans);

	}

	private static void dfs(Point p) {

		for (int i = 5; i >= 1; i--) {

			if (cal(p.r, p.c, i * i, i)) {
				reset(p.r, p.c, i, i);
			}
		}

	}

	private static void reset(int r, int c, int idx, int size) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				v[i][j][idx] = true;
			}
		}
	}

	private static boolean cal(int r, int c, int max, int size) {
		if (r + size > 10 || c + size > 10) {
			return false;
		}
		int sum = 0;
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				sum += map[i][j];
			}
		}

		if (sum == max)
			return true;
		return false;

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
