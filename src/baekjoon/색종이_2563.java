package baekjoon;

import java.util.Scanner;

public class 색종이_2563 {
	static int N, map[][], arr[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[101][101];

		arr = new int[N][2];

		// 거꾸로 생각할거라 행열 반대로 받음.
		for (int i = 0; i < N; i++) {
			int col = sc.nextInt();
			int row = sc.nextInt();

			for (int r = row; r < row + 10; r++) {
				for (int c = col; c < col + 10; c++) {
					map[r][c] = 1;
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 1) cnt++;
			}
		}

//		print(map);
		System.out.println(cnt);


	}

	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
