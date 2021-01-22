package baekjoon;

import java.util.*;
import java.io.*;

public class 스도미노쿠_4574 {

	static int N;
	static boolean flag;
	static boolean[][] v;
	static int[] dr = { 0, 1 }; // 우 하
	static int[] dc = { 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			int[][] map = new int[9][9];
			v = new boolean[10][10];
			flag = false;

			int num1, num2;
			String str1, str2;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				num1 = Integer.parseInt(st.nextToken());
				str1 = st.nextToken();
				num2 = Integer.parseInt(st.nextToken());
				str2 = st.nextToken();

				v[num1][num2] = true;
				v[num2][num1] = true;

				map[str1.charAt(0) - 65][str1.charAt(1) - '1'] = num1;
				map[str2.charAt(0) - 65][str2.charAt(1) - '1'] = num2;
			}

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= 9; i++) {
				str1 = st.nextToken();
				map[str1.charAt(0) - 65][str1.charAt(1) - '1'] = i;
			}

			// 알고리즘
			System.out.printf("Puzzle %d\n", num++);
			cal(map, 0);

		}

	}

	private static void cal(int[][] map, int idx) {
		if (flag)
			return;
		if (idx == 81) {
			flag = true;
			print(map);
			return;
		}

		int r = idx / 9;
		int c = idx % 9;

		if (map[r][c] != 0) {
			cal(map, idx + 1);
			return;
		}
		for (int k = 0; k < 2; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if (nr < 0 || nc < 0 || nr >= 9 || nc >= 9 || map[nr][nc] != 0)
				continue;
			for (int i = 1; i < 10; i++) {
				for (int j = 1; j < 10; j++) {
					if (i == j || v[i][j] || !check(j, map, nr, nc) || !check(i, map, r, c))
						continue;
					map[r][c] = i;
					v[i][j] = true;
					v[j][i] = true;
					map[nr][nc] = j;
					cal(map, idx + 1);
					map[nr][nc] = 0;
					v[i][j] = false;
					v[j][i] = false;
					map[r][c] = 0;

				}
			}
		}

	}

	private static boolean check(int idx, int[][] map, int r, int c) {

		int row = r / 3 * 3;
		int col = c / 3 * 3;

		// 3 X 3 검사
		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				if (map[i][j] == idx)
					return false;
			}
		}

		// 행 검사
		for (int i = 0; i < map.length; i++) {
			if (map[r][i] == idx)
				return false;
		}

		// 열 검사
		for (int i = 0; i < map.length; i++) {
			if (map[i][c] == idx)
				return false;
		}

		return true;
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();

		}

	}

}
