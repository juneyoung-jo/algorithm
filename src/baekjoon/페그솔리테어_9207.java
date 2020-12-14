package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 페그솔리테어_9207 {
	static int T;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static ArrayList<Point> list;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			map = new char[5][];
			list = new ArrayList<Point>();

			for (int i = 0; i < 5; i++) {
				map[i] = br.readLine().toCharArray();
			}
			if (tc != T) {
				String dump = br.readLine();
			}

			// 알고리즘

			cal(0, map, list);

		}

	}

	private static void cal(int idx, char[][] cMap, ArrayList<Point> pList) {
		// TODO Auto-generated method stub
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 9; c++) {
				if (cMap[r][c] == 'o') {
					list.add(new Point(r, c));
				}
			}
		}
		
		
	}

}
