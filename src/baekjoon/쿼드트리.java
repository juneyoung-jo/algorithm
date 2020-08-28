package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿼드트리 {
	static int N, map[][];
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < map.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

//		print(map);
		div(0, 0, N);
		System.out.println(sb.toString());

	}

	private static void div(int r, int c, int size) {

		boolean isOk = true;
		int number = map[r][c];
		L: for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (map[i][j] != number) {
					isOk = false;
					break L;
				}
			}
		}
		if (isOk) {
			if (number == 0) {
				sb.append('0');
			} else {
				sb.append('1');
			}
			return;
		}

		int num = size / 2;
		sb.append('(');
		div(r, c, num);
		div(r, c + num, num);
		div(r + num, c, num);
		div(r + num, c + num, num);
		sb.append(')');

	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
