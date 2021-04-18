package baekjoon;

import java.util.*;
import java.io.*;

public class 스도쿠_2580 {
	static int map[][];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[9][9];

		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cal(0);

	}

	private static void cal(int idx) {
		if (idx == 81) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (j == 0) System.out.print(map[i][j]);
					else System.out.print(" " + map[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}

		int row = idx / 9;
		int col = idx % 9;

		if (map[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (check(row, col, i)) {
					map[row][col] = i;
					cal(idx + 1);
					map[row][col] = 0;
				}
			}
		} else {
			cal(idx + 1);
			}
	}

	private static boolean check(int row, int col, int i) {

		// 행 열 체크
		for (int j = 0; j < 9; j++) {
			if (map[row][j] == i) return false;
			if (map[j][col] == i) return false;
		}


		// 3*3 체크
		int r = row / 3 * 3;
		int c = col / 3 * 3;

		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < 3; k++) {
				if (map[r + j][c + k] == i) return false;
			}
		}

		return true;
	}

}
