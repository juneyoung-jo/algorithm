package swexpertacademy;

import java.util.Scanner;

public class NQueen미완성 {
	static int T, N, map[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();

			map = new int[N][N];

			queen(0, new boolean[N][N]);

		}

	}

	private static void queen(int idx, boolean[][] v) {
		if (idx == N) {

			return;
		}

	}

}
