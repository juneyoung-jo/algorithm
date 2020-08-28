package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 색종이붙이기_17136 {
	static int map[][] = new int[10][10];
	static boolean[] v = new boolean[6];
	static int[] pArr = new int[5];
	static int Ans = Integer.MAX_VALUE;
	static int[] dr = { 0, 1, 1 };
	static int[] dc = { 1, 1, 0 };
	static int[][] nmap;

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
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
		pArr[3] = 2;
		pArr[4] = 1;
		permutation(0);

//		boolean isOk = false;
//		for (int answers : answer) {
//			if (answers > 6) {
//				isOk = true;
//			}
//			Ans += answers;
//		}
//		if (!isOk) {
//			System.out.println(Ans);
//		} else {
//			System.out.println("-1");
//		}
//		print(map);
		System.out.println(Ans == Integer.MAX_VALUE ? "-1" : Ans);

	}

	public static int[][] mapCopy(int[][] map) {
		if (map == null) {
			return null;
		}

		int[][] result = new int[10][10];
		for (int i = 0; i < map.length; i++) {
			System.arraycopy(map[i], 0, result[i], 0, map[i].length);
		}
		return result;
	}

	private static void permutation(int idx) {
		if (idx == 3) {

			int[] answer = new int[6];
			nmap = mapCopy(map);
			for (int index = 0; index < 5; index++) { // 5x5 ~ 1x1 까지 돌려야 하기 때문에
				for (int r = 0; r < map.length; r++) {
					for (int c = 0; c < map[r].length; c++) {
						if (nmap[r][c] == 1) {
							if (cal(r, c, pArr[index] * pArr[index], pArr[index])) {
								reset(r, c, pArr[index]);
								answer[pArr[index]]++;
								if (answer[pArr[index]] > 5) {
									return;
								}
							}
						}
					}
				}
			}
			int suma = 0;
			for (int answers : answer) {
				suma += answers;
			}

			Ans = Math.min(Ans, suma);
			return;
		}

		for (int i = 3; i <= 5; i++) {
			if (v[i])
				continue;
			v[i] = true;
			pArr[idx] = i;
			permutation(idx + 1);
			v[i] = false;
		}
	}

	private static void reset(int r, int c, int size) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				nmap[i][j] = 0;
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
				sum += nmap[i][j];
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
