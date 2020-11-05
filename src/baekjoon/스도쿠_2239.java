package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 스도쿠_2239 {
	static int map[][], copyMap[][];
	static boolean flag = true;
	static boolean[] v = new boolean[10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		copyMap = new int[9][9];

		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				copyMap[i][j] = map[i][j] = str.charAt(j) - '0';
			}
		}

		cal(0);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();

		}

//		print(map);

	}

	private static void cal(int idx) {

		boolean[] v = new boolean[10];
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				if (copyMap[r][c] != 0) continue;
				checkMap(v, copyMap, r, c);
				for (int k = 1; k <= 9; k++) {
					// 중복값 아닌거
					if (v[k]) continue;
					copyMap[r][c] = k;
					cal(idx + 1);
					if (check(copyMap)) {
						map = copyMap;
						return;
					}
					copyMap[r][c] = 0;
				}
				return;
			}

		}

	}

	private static void checkMap(boolean[] v, int[][] map, int r, int c) {
		// TODO Auto-generated method stub
		// 행
		for (int i = 0; i < 9; i++) {
			v[map[r][i]] = true;
		}
		// 열
		for (int i = 0; i < 9; i++) {
			v[map[i][c]] = true;
		}
		// 3x3
		int a = (r / 3) * 3;
		int b = (c / 3) * 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				v[map[a + i][b + j]] = true;
			}
		}

	}

	private static boolean check(int[][] map) {
		Arrays.fill(v, false);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				v[map[i][j]] = true;
			}

			for (int j = 1; j <= 9; j++) {
				if (!v[j])
					return false;
			}
			Arrays.fill(v, false);
			for (int j = 0; j < 9; j++) {
				v[map[j][i]] = true;
			}
			for (int j = 1; j <= 9; j++) {
				if (!v[j])
					return false;
			}
		}
		return true;
	}

	private static void print(int[][] map) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

}
