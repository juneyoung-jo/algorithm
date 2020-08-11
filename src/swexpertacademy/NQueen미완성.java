package swexpertacademy;

import java.util.Scanner;

public class NQueen미완성 {
	static int T, N, map[][], Ans[][], ans, max;
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 }; // 8방
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();

			map = new int[N][N];
			Ans = new int[N][N];

			for (int c = 0; c < N; c++) {
				nqueen(0, c, new boolean[N][N]);
			}

			int count = 0;

		}

	}

	private static void nqueen(int r, int c, boolean[][] v) {

	}

	private static void print(boolean[][] v) {

		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v.length; j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}

	}

}
